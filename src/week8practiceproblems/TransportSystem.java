import java.util.*;

abstract class Transport {
    double distance;
    Transport(double distance) { this.distance = distance; }
    abstract double getFare();
}

class Bus extends Transport {
    Bus(double d) { super(d); }
    double getFare() {
        // Base fare $2 + $0.10 per km, capped at $10
        return Math.min(2 + 0.1 * distance, 10);
    }
}

class Train extends Transport {
    Train(double d) { super(d); }
    double getFare() {
        // Base fare $3 + $0.15 per km
        return 3 + 0.15 * distance;
    }
}

class Metro extends Transport {
    double peakFactor;
    Metro(double d, double pf) { super(d); this.peakFactor = pf; }
    double getFare() {
        // Base fare $1.50 + $0.20 per km, multiplied by peak hour factor
        return (1.5 + 0.2 * distance) * peakFactor;
    }
}

public class TransportSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // number of journeys
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            if (type.equals("METRO")) {
                double d = sc.nextDouble();
                double pf = sc.nextDouble();
                Transport t = new Metro(d, pf);
                double fare = t.getFare();
                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            } else {
                double d = sc.nextDouble();
                Transport t = type.equals("BUS") ? new Bus(d) : new Train(d);
                double fare = t.getFare();
                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
