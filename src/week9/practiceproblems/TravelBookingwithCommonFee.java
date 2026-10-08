package week9.practiceproblems;

import java.util.*;

abstract class Booking {
    double distance;

    static final double BOOKING_FEE = 50;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double baseFare();

    double totalFare() {
        return baseFare() + BOOKING_FEE;
    }
}

class Bus extends Booking {

    Bus(double distance) {
        super(distance);
    }

    double baseFare() {
        return 2 * distance;
    }
}

class Train extends Booking {

    Train(double distance) {
        super(distance);
    }

    double baseFare() {
        return 1.5 * distance;
    }
}

class Flight extends Booking {

    Flight(double distance) {
        super(distance);
    }

    double baseFare() {
        return 2500 + 4 * distance;
    }
}

public class TravelBookingwithCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            Booking b;

            if (mode.equals("BUS")) {
                b = new Bus(distance);
            }
            else if (mode.equals("TRAIN")) {
                b = new Train(distance);
            }
            else {
                b = new Flight(distance);
            }

            System.out.printf("%s: %.2f%n", mode, b.totalFare());
        }
    }
}
