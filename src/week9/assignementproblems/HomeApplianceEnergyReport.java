package week9.assignementproblems;
import java.util.Scanner;

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double power();

    double units() {
        return power() * hours / 1000;
    }

    double cost() {
        return units() * 8;
    }
}

interface SaverMode {
    double saverUnits();
}

class Fridge extends Appliance {

    Fridge(double hours) {
        super(hours);
    }

    double power() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {

    AC(double hours) {
        super(hours);
    }

    double power() {
        return 1500;
    }

    public double saverUnits() {
        return units() * 0.75;
    }
}

class TV extends Appliance {

    TV(double hours) {
        super(hours);
    }

    double power() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {

    Washer(double hours) {
        super(hours);
    }

    double power() {
        return 500;
    }

    public double saverUnits() {
        return units() * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {
                String next = sc.next();

                if (next.equals("SAVER")) {
                    saver = true;
                }
            }

            Appliance appliance;

            if (type.equals("FRIDGE")) {
                appliance = new Fridge(hours);
            } else if (type.equals("AC")) {
                appliance = new AC(hours);
            } else if (type.equals("TV")) {
                appliance = new TV(hours);
            } else {
                appliance = new Washer(hours);
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units;

            if (saver) {
                SaverMode saverAppliance = (SaverMode) appliance;
                units = saverAppliance.saverUnits();
            } else {
                units = appliance.units();
            }

            double cost = units * 8;

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}