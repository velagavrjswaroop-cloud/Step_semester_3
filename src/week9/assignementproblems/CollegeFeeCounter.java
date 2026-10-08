package week9.assignementproblems;
import java.util.Scanner;

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double tuitionFee();
}

interface BusUser {
    double transportFee();
}

class DayScholar extends Student implements BusUser {

    DayScholar(String name) {
        super(name);
    }

    double tuitionFee() {
        return 40000;
    }

    public double transportFee() {
        return 12000;
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    double tuitionFee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements BusUser {

    Scholar(String name) {
        super(name);
    }

    double tuitionFee() {
        return 20000;
    }

    public double transportFee() {
        return 12000;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new Scholar(name);
            }

            double fee = student.tuitionFee();

            if (student instanceof BusUser) {
                BusUser busStudent = (BusUser) student;
                fee += busStudent.transportFee();
            }

            System.out.printf("%s: %.2f%n", student.name, fee);

            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
    }
}