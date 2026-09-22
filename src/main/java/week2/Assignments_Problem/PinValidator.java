package main.java.week2.Assignments_Problem;

public class PinValidator {
    public static void checkPinLength(String pin) {
        // Check length using length()
        if (pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        }
    }

    public static void main(String[] args) {
        // Sample inputs
        checkPinLength("482");   // Invalid PIN — must be exactly 4 digits.
        checkPinLength("4820");  // PIN length OK.
        checkPinLength("12345"); // Invalid PIN — must be exactly 4 digits.
    }
}
