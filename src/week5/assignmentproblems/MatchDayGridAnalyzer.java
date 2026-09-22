package week5.assignmentproblems;

public class MatchDayGridAnalyzer {
    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int runs : row) sum += runs;
        return (double) sum / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            result.append("Match ").append(i).append(": ");
            if (avg >= threshold) {
                result.append("Power Surge");
            } else {
                result.append("Normal");
            }
            if (i < runsPerOver.length - 1) result.append(" | ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };
        System.out.println(classifyMatches(runsPerOver, 8));
        // Match 0: Normal | Match 1: Power Surge | Match 2: Normal
    }
}
