import java.util.*;

abstract class Room {
    int units;
    Room(int units) { this.units = units; }
    abstract double getBill();
}

class SingleRoom extends Room {
    SingleRoom(int units) { super(units); }
    double getBill() { return units * 8; }
}

class SharedRoom extends Room {
    int occupants;
    SharedRoom(int units, int occupants) { super(units); this.occupants = occupants; }
    double getBill() { return (units * 6.0) / occupants; }
}

class AcRoom extends Room {
    AcRoom(int units) { super(units); }
    double getBill() { return units * 10 + 200; }
}

public class HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            if (type.equals("SHARED")) {
                int units = sc.nextInt();
                int occ = sc.nextInt();
                Room r = new SharedRoom(units, occ);
                double bill = r.getBill();
                System.out.printf("%s: %.2f%n", type, bill);
                total += bill;
            } else {
                int units = sc.nextInt();
                Room r = type.equals("SINGLE") ? new SingleRoom(units) : new AcRoom(units);
                double bill = r.getBill();
                System.out.printf("%s: %.2f%n", type, bill);
                total += bill;
            }
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
