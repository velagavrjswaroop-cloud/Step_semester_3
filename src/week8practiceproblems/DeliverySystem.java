import java.util.*;

abstract class Delivery {
    double weight, distance;
    Delivery(double weight, double distance) { this.weight = weight; this.distance = distance; }
    abstract double getFee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double w, double d) { super(w, d); }
    double getFee() { return 5 + 0.5 * weight + 0.1 * distance; }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double w, double d) { super(w, d); }
    double getFee() { return 15 + 1.0 * weight + 0.2 * distance; }
}

class InternationalDelivery extends Delivery {
    double customsFee;
    InternationalDelivery(double w, double d, double c) { super(w, d); customsFee = c; }
    double getFee() { return 25 + 2.0 * weight + 0.5 * distance + customsFee; }
}

public class DeliverySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            if (type.equals("INTERNATIONAL")) {
                double w = sc.nextDouble(), d = sc.nextDouble(), c = sc.nextDouble();
                Delivery del = new InternationalDelivery(w, d, c);
                double fee = del.getFee();
                System.out.printf("%s: %.2f%n", type, fee);
                total += fee;
            } else {
                double w = sc.nextDouble(), d = sc.nextDouble();
                Delivery del = type.equals("STANDARD") ? new StandardDelivery(w, d) : new ExpressDelivery(w, d);
                double fee = del.getFee();
                System.out.printf("%s: %.2f%n", type, fee);
                total += fee;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
