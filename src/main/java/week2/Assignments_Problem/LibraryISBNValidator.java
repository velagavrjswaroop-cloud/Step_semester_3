package main.java.week2.Assignments_Problem;

public class LibraryISBNValidator {
    public static String normalizeCode(String raw) {
        // Trim spaces
        raw = raw.trim();

        // If length < 3, can't normalize properly
        if (raw.length() < 3) {
            return raw;
        }

        // Uppercase first 3 characters (publisher code)
        String pubCode = raw.substring(0, 3).toUpperCase();
        String rest = raw.substring(3);

        return pubCode + rest;
    }

    // Step 2: Validate and format
    public static String validateAndFormat(String code) {
        // Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Validate first 3 letters (publisher code)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Validate remaining 10 digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }

        // Extract parts
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);       // 4 digits
        String catalog = code.substring(7);       // 6 digits

        // Build formatted display
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] ");
        sb.append("YEAR: ").append(year);
        sb.append(" | CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        // Sample inputs
        String raw1 = " pen2026004251 ";
        String raw2 = "12N2026004251";

        String code1 = normalizeCode(raw1);
        String code2 = normalizeCode(raw2);

        System.out.println(validateAndFormat(code1)); // [PEN] YEAR: 2026 | CATALOG: 004251
        System.out.println(validateAndFormat(code2)); // Invalid: publisher code must be 3 letters
    }
}
