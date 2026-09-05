public class ReviewWordProfiler {
    public static void classifyWordLengths(String review) {
        try {
            String[] words = review.split(" ");
            int shortCount = 0, mediumCount = 0, longCount = 0;

            for (String word : words) {
                int length = word.length();
                if (length >= 1 && length <= 4) {
                    shortCount++;
                } else if (length >= 5 && length <= 8) {
                    mediumCount++;
                } else {
                    longCount++;
                }
            }
            System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
        } catch (Exception e) {
            System.out.println("Error profiling review: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
