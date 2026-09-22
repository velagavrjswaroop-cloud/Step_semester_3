package main.java.week2.Practice_Problem;

public class TransactionReference {
    public static String normalizeReference(String raw) {
        // Trim spaces
        raw = raw.trim();

        // If length < 3, can't normalize properly
        if (raw.length() < 3) {
            return raw;
        }

        // Uppercase first 3 characters (bank code)
        String bankCode = raw.substring(0, 3).toUpperCase();
        String rest = raw.substring(3);

        return bankCode + rest;
    }

    // Step 2: Validate and format
    public static String validateAndFormat(String reference) {
        // Check length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Validate first 3 letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Validate remaining 11 digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }

        // Extract parts
        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);   // ddMMyy
        String seq = reference.substring(9);       // 5 digits

        // Format date as dd/MM/yy
        String formattedDate = date.substring(0, 2) + "/" +
                date.substring(2, 4) + "/" +
                date.substring(4, 6);

        // Build formatted display
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] ");
        sb.append("DATE: ").append(formattedDate);
        sb.append(" | SEQ: ").append(seq);

        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample inputs
        String raw1 = " hdf03022600042 ";
        String raw2 = "12F03022600042";

        String ref1 = normalizeReference(raw1);
        String ref2 = normalizeReference(raw2);

        System.out.println(validateAndFormat(ref1)); // [HDF] DATE: 03/02/26 | SEQ: 00042
        System.out.println(validateAndFormat(ref2)); // Invalid: bank code must be 3 letters
    }
}
