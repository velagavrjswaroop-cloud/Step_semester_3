package main.java.week2.Practice_Problem;

public class StudentRecordParser {
    public static void parseStudentRecord(String csvLine) {
        // Split by comma
        String[] fields = csvLine.split(",");

        // Validate number of fields
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        // Trim spaces for clean output
        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String department = fields[2].trim();

        // Print formatted record
        System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + department);
    }

    public static void main(String[] args) {
        // Sample input
        String input1 = "Rahul,101,Computer Science";
        String input2 = "Anitha,102"; // Invalid case

        parseStudentRecord(input1);
        parseStudentRecord(input2);
    }
}
