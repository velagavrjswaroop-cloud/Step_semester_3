public class TypingAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        try {
            if (original.length() != typed.length()) {
                throw new IllegalArgumentException("Strings must be of equal length!");
            }
            int matched = 0;
            int firstMismatch = -1;
            for (int i = 0; i < original.length(); i++) {
                if (original.charAt(i) == typed.charAt(i)) {
                    matched++;
                } else if (firstMismatch == -1) {
                    firstMismatch = i + 1; // position (1-based)
                }
            }
            double accuracy = (matched * 100.0) / original.length();
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, original.length(), accuracy);
            if (firstMismatch != -1) {
                System.out.println(" | First Mismatch at position " + firstMismatch +
                        " ('" + original.charAt(firstMismatch - 1) + "' vs '" + typed.charAt(firstMismatch - 1) + "')");
            } else {
                System.out.println(" | No Mismatches");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
    }
}
