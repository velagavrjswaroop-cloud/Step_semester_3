package week5.assignmentproblems;

public class TopPerformerTracker {
    public static String findMinMaxSpread(int[] scores) {
        int min = scores[0], max = scores[0];
        for (int score : scores) {
            if (score < min) min = score;
            if (score > max) max = score;
        }
        int spread = max - min;
        return "Min: " + min + " | Max: " + max + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(scores)); // Min: 33 | Max: 90 | Spread: 57
    }
}

