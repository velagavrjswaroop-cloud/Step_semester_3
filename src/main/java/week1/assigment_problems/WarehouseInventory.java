public class WarehouseInventory {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        try {
            int totalA = 0, totalB = 0;
            int highest = Integer.MIN_VALUE;
            String location = "";
            for (int i = 0; i < sectionA.length; i++) {
                totalA += sectionA[i];
                if (sectionA[i] > highest) {
                    highest = sectionA[i];
                    location = "Section A, Item " + (i + 1);
                }
            }
            for (int i = 0; i < sectionB.length; i++) {
                totalB += sectionB[i];
                if (sectionB[i] > highest) {
                    highest = sectionB[i];
                    location = "Section B, Item " + (i + 1);
                }
            }
            String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
            System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB +
                    " | Status: " + status + " | Highest Quantity: " + highest + " (" + location + ")");
        } catch (Exception e) {
            System.out.println("Error in inventory analysis: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        analyzeInventory(sectionA, sectionB);
    }
}
