package main.java.week2.Practice_Problem;

public class VowelConsonantCounter {
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        // Convert to lowercase for case-insensitive comparison
        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch == ' ') {
                continue; // ignore spaces
            }

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        String input = "Java Programming";
        countVowelsAndConsonants(input);
    }
}
