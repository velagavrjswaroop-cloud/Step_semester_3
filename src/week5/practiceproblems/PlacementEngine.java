package week5.practiceproblems;

import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // Eligibility checks
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5; // threshold chosen
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 7.0 && codingScore >= 60; // borderline rule
    }

    // Composite score for ranking
    private double compositeScore() {
        return cgpa * 10 + codingScore; // weighting scheme
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore(), this.compositeScore());
    }

    @Override
    public String toString() {
        return name + " (" + compositeScore() + ")";
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = Arrays.stream(candidates)
                .filter(c -> isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore))
                .toArray(Candidate[]::new);

        Arrays.sort(shortlisted);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            sb.append((i + 1)).append(". ").append(shortlisted[i]);
            if (i < shortlisted.length - 1) sb.append(" | ");
        }
        return sb.toString();
    }
}

public class PlacementEngine {
    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(Candidate.shortlistAndRank(candidates));
        // 1. Aisha (122.0) | 2. Rohit (133.0) | 3. Karan (95.0)
    }
}

