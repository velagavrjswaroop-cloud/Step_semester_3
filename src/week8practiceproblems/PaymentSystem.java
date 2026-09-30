import java.util.*;

abstract class Payment {
    double amount;
    Payment(double amount) { this.amount = amount; }
    abstract double getFinalAmount();
}

class CardPayment extends Payment {
    CardPayment(double amount) { super(amount); }
    double getFinalAmount() { return amount * 1.02; } // 2% fee
}

class WalletPayment extends Payment {
    WalletPayment(double amount) { super(amount); }
    double getFinalAmount() { return amount * 1.01; } // 1% fee
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) { super(amount); }
    double getFinalAmount() { return amount; } // no fee
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amt = sc.nextDouble();
            Payment p = switch(type) {
                case "CARD" -> new CardPayment(amt);
                case "WALLET" -> new WalletPayment(amt);
                default -> new BankTransferPayment(amt);
            };
            double finalAmt = p.getFinalAmount();
            System.out.printf("%s: %.2f%n", type, finalAmt);
            total += finalAmt;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

