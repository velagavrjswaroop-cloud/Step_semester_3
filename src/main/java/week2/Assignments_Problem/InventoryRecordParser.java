package main.java.week2.Assignments_Problem;

public class InventoryRecordParser {
    public static void parseInventoryRecord(String csvLine) {
        // Split by comma
        String[] fields = csvLine.split(",");

        // Validate number of fields
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        // Trim spaces for clean output
        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        // Print formatted record
        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        // Sample inputs
        String input1 = "Wireless Mouse,WM-2201,150";
        String input2 = "Wireless Mouse,150"; // Invalid case

        parseInventoryRecord(input1);
        parseInventoryRecord(input2);
    }
}
