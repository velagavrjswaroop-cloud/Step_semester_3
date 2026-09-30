import java.util.*;

abstract class Employee {
    String name;
    double salary;
    Employee(String name, double salary) { this.name = name; this.salary = salary; }
    abstract double getBonus();
}

class FullTime extends Employee {
    FullTime(String name, double salary) { super(name, salary); }
    double getBonus() { return salary * 0.1; }
}

class PartTime extends Employee {
    PartTime(String name, double salary) { super(name, salary); }
    double getBonus() { return salary * 0.05; }
}

class Intern extends Employee {
    Intern(String name, double salary) { super(name, salary); }
    double getBonus() { return 2000; }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double sal = sc.nextDouble();
            Employee e = switch(type) {
                case "FULLTIME" -> new FullTime(name, sal);
                case "PARTTIME" -> new PartTime(name, sal);
                default -> new Intern(name, sal);
            };
            double bonus = e.getBonus();
            System.out.printf("%s: %.2f%n", name, bonus);
            total += bonus;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
