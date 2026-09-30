import java.util.*;

abstract class Question {
    String correctAnswer, studentAnswer;
    int points;
    Question(String correct, String student, int points) {
        this.correctAnswer = correct; this.studentAnswer = student; this.points = points;
    }
    abstract double getScore();
}

class MCQ extends Question {
    MCQ(String correct, String student, int points) { super(correct, student, points); }
    double getScore() { return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0; }
}

class TF extends Question {
    TF(String correct, String student, int points) { super(correct, student, points); }
    double getScore() { return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0; }
}

class Essay extends Question {
    Essay(String correct, String student, int points) { super(correct, student, points); }
    double getScore() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        for (String kw : keywords) {
            if (studentAnswer.toLowerCase().contains(kw.trim().toLowerCase())) matchCount++;
        }
        if (matchCount >= 2) return points * 0.75;
        else if (matchCount == 1) return points * 0.5;
        else return 0;
    }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            sc.nextLine(); // consume space
            String questionText = sc.nextLine(); // not used in scoring
            String correct = sc.nextLine();
            String student = sc.nextLine();
            int points = sc.nextInt(); sc.nextLine();
            Question q = switch(type) {
                case "MCQ" -> new MCQ(correct, student, points);
                case "TF" -> new TF(correct, student, points);
                default -> new Essay(correct, student, points);
            };
            double score = q.getScore();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}
