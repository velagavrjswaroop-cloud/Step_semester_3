package week5.practiceproblems;

public class SeatingGridOptimizer {
    private static double rowAverage(int[] row) {
        int sum = 0;
        for (int score : row) sum += score;
        return (double) sum / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            result.append("Row ").append(i).append(": ");
            if (avg < threshold) {
                result.append("Quiet Zone");
            } else {
                result.append("Buzzing Zone");
            }
            if (i < seatingScores.length - 1) result.append(" | ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
                {40, 50, 45},
                {85, 90, 95},
                {30, 20, 25}
        };
        System.out.println(classifyRows(seatingScores, 60));
        // Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone
    }
}

