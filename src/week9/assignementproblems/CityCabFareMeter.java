package week9.assignementproblems;
import java.util.Scanner;

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double rate();

    double baseFare() {
        return Math.max(km * rate(), 100);
    }

    double fare() {
        return baseFare();
    }
}

interface NightService {
    double nightFare(double baseFare);
}

class Mini extends Cab {

    Mini(double km) {
        super(km);
    }

    double rate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {

    Sedan(double km) {
        super(km);
    }

    double rate() {
        return 14;
    }

    public double nightFare(double baseFare) {
        return baseFare * 1.20;
    }

    double fare() {
        return baseFare();
    }
}

class SUV extends Cab implements NightService {

    SUV(double km) {
        super(km);
    }

    double rate() {
        return 18;
    }

    public double nightFare(double baseFare) {
        return baseFare * 1.20;
    }

    double fare() {
        return baseFare();
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI")) {
                cab = new Mini(km);
            } else if (type.equals("SEDAN")) {
                cab = new Sedan(km);
            } else {
                cab = new SUV(km);
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.baseFare();

            if (time.equals("NIGHT")) {
                NightService nightCab = (NightService) cab;
                fare = nightCab.nightFare(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}