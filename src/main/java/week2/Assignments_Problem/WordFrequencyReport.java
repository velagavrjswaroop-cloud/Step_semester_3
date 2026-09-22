import java.util.*;

public static void printFilteredWordFrequency(String feedback) {
    // Define stop words
    Set<String> stopWords = new HashSet<>(Arrays.asList(
            "the", "was", "and", "a", "is", "of", "in"
    ));

    // Normalize: lowercase and strip punctuation
    String cleaned = feedback.toLowerCase()
            .replace(".", "")
            .replace(",", "");

    // Split into words
    String[] words = cleaned.split("\\s+");

    // Count frequencies excluding stop words
    Map<String, Integer> freqMap = new HashMap<>();
    for (String word : words) {
        if (!stopWords.contains(word) && !word.isEmpty()) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
    }

    // Sort by frequency (descending)
    List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(freqMap.entrySet());
    sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

    // Print results
    for (Map.Entry<String, Integer> entry : sortedList) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}

public static void main(String[] args) {
    // Sample input
    String input = "The mentor was great, the session was great and clear.";
    printFilteredWordFrequency(input);
}
public class WordFrequencyReport {
    public static void printFilteredWordFrequency(String feedback) {
        // Define stop words
        Set<String> stopWords = new HashSet<>(Arrays.asList(
                "the", "was", "and", "a", "is", "of", "in"
        ));

        // Normalize: lowercase and strip punctuation
        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        // Split into words
        String[] words = cleaned.split("\\s+");

        // Count frequencies excluding stop words
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            if (!stopWords.contains(word) && !word.isEmpty()) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        // Sort by frequency (descending)
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(freqMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Print results
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Sample input
        String input = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(input);
    }
}
