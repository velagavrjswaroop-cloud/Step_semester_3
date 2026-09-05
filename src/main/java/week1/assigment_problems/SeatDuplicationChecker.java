public class SeatDuplicationChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        try {
            boolean duplicateFound = false;
            for (int i = 0; i < seatNumbers.length; i++) {
                for (int j = i + 1; j < seatNumbers.length; j++) {
                    if (seatNumbers[i] == seatNumbers[j]) {
                        System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                        duplicateFound = true;
                    }
                }
            }
            if (!duplicateFound) {
                System.out.println("No Duplicate Seats Found");
            }
        } catch (RuntimeException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        int[] seats = {101, 102, 103, 102, 105};
        checkDuplicateSeats(seats);
    }
}
