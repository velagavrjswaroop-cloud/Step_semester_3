import java.util.*;
import java.time.LocalDate;

abstract class Plan {
    String name;
    LocalDate startDate;
    Plan(String name, LocalDate startDate) { this.name = name; this.startDate = startDate; }
    abstract LocalDate getRenewalDate();
}

class Basic extends Plan {
    Basic(String name, LocalDate startDate) { super(name, startDate); }
    LocalDate getRenewalDate() { return startDate.plusDays(30); }
}

class Standard extends Plan {
    Standard(String name, LocalDate startDate) { super(name, startDate); }
    LocalDate getRenewalDate() { return startDate.plusDays(90); }
}

class Premium extends Plan {
    Premium(String name, LocalDate startDate) { super(name, startDate); }
    LocalDate getRenewalDate() { return startDate.plusDays(365); }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate start = LocalDate.parse(sc.next());
            Plan p = switch(type) {
                case "BASIC" -> new Basic(name, start);
                case "STANDARD" -> new Standard(name, start);
                default -> new Premium(name, start);
            };
            System.out.printf("%s: %s%n", name, p.getRenewalDate());
        }
    }
}
