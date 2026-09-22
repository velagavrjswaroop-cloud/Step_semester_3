package main.java.week2.Assignments_Problem;

public class WordReversalEncoder {
    public static String reverseEachWord(String sentence) {
        // Split sentence into words
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        // Process each word
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder reversed = new StringBuilder();

            // Reverse manually using a loop
            for (int j = word.length() - 1; j >= 0; j--) {
                reversed.append(word.charAt(j));
            }

            // Append reversed word to result
            result.append(reversed);

            // Add space between words (not after last word)
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Sample input
        String input = "hello club";
        System.out.println(reverseEachWord(input)); // olleh bulc

        // Another test
        System.out.println(reverseEachWord("java programming fun"));
        // Output: avaj gnimmargorp nuf
    }
}
