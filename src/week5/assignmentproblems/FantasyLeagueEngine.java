package week5.assignmentproblems;

import java.util.Arrays;

class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Draft rules
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10; // experienced players
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured; // newer players must be fit
    }

    // Ranking by batting average (fantasy points proxy)
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    @Override
    public String toString() {
        return name;
    }

    public static String draftAndRank(Player[] players) {
        Player[] draftable = Arrays.stream(players)
                .filter(p -> isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured))
                .toArray(Player[]::new);

        Arrays.sort(draftable);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            sb.append((i + 1)).append(". ").append(draftable[i]);
            if (i < draftable.length - 1) sb.append(" | ");
        }
        return sb.toString();
    }
}

public class FantasyLeagueEngine {
    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };
        System.out.println(Player.draftAndRank(players));
        // 1. Rahul | 2. Virat | 3. Dev
    }
}

