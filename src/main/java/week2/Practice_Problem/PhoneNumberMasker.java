package main.java.week2.Practice_Problem;

public class PhoneNumberMasker {
    public static String maskPhoneNumber(String phone) {
        // Validate length and digits
        if (phone.length() != 10 || !phone.matches("\\d{10}")) {
            return "Invalid phone number";
        }

        // Extract last 4 digits
        String lastFour = phone.substring(6);

        // Build masked version using StringBuilder
        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.append("-");
        masked.append(lastFour);

        return masked.toString();
    }

    public static void main(String[] args) {
        // Sample inputs
        System.out.println(maskPhoneNumber("9876543210")); // XXXXXX-3210
        System.out.println(maskPhoneNumber("98765"));      // Invalid phone number
        System.out.println(maskPhoneNumber("1234567890")); // XXXXXX-7890
    }
}
