package week66assignment;

class HallTicket {
    String studentName;
    int seatNumber;

    // Constructor
    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        // Create one HallTicket object for Priya
        HallTicket priya = new HallTicket("Priya", 0);

        // Assign a second variable to point at the same object
        HallTicket copy = priya;

        // Change seatNumber through the second variable
        copy.seatNumber = 45;

        // Create a third, separate HallTicket object with identical values
        HallTicket separate = new HallTicket("Priya", 45);

        // Print results
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}

