import java.util.*;

abstract class Customer {
    double amount;
    Customer(double amount) { this.amount = amount; }
    abstract double getFinalAmount();
}

class Student extends Customer {
    Student(double amount) { super(amount); }
    double getFinalAmount() { return amount * 0.9; }
}

class Staff extends Customer {
    Staff(double amount) { super(amount); }
    double getFinalAmount() { return amount * 0.95; }
}

class Guest extends Customer {
    Guest(double amount) { super(amount); }
    double getFinalAmount() { return amount + 10; }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amt = sc.nextDouble();
            Customer c = switch(type) {
                case "STUDENT" -> new Student(amt);
                case "STAFF" -> new Staff(amt);
                default -> new Guest(amt);
            };
            double finalAmt = c.getFinalAmount();
            System.out.printf("%s: %.2f%n", type, finalAmt);
            total += finalAmt;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
