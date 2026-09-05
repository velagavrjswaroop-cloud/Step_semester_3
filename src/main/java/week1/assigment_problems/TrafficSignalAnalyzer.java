public class TrafficSignalAnalyzer {
    public static void findLongestStreak(String signalLog) {
        try {
            int maxLength = 1, currentLength = 1;
            char maxChar = signalLog.charAt(0);
            for (int i = 1; i < signalLog.length(); i++) {
                if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                    currentLength++;
                } else {
                    currentLength = 1;
                }
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxChar = signalLog.charAt(i);
                }
            }
            System.out.println("Longest Streak: '" + maxChar + "' repeated " + maxLength + " times");
        } catch (Exception e) {
            System.out.println("Error analyzing signal: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
    }
}

