package week77practice;
class PiggyBank {
    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0; // starts at 0
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
            System.out.println("Deposited: " + amount + " | Savings = " + savings);
        } else {
            System.out.println("Deposit rejected: amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Withdraw rejected: insufficient savings.");
        } else {
            savings -= amount;
            System.out.println("Withdrew: " + amount + " | Savings = " + savings);
        }
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
    }
}
