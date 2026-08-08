public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null || sectionA.length == 0 || sectionB.length == 0) {
            System.out.println("Invalid inventory data.");
            return;
        }

        int totalA = 0;
        int totalB = 0;

        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "";
        int highestItemIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItemIndex = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItemIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, highestQuantity, highestSection, highestItemIndex);
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 (Balanced) ---");
        int[] sectionA1 = {20, 15, 30};
        int[] sectionB1 = {25, 10, 30};
        System.out.println("Input: sectionA={20,15,30}, sectionB={25,10,30}");
        System.out.print("Output: ");
        analyzeInventory(sectionA1, sectionB1);

        System.out.println("\n--- Test Case 2 (Not Balanced) ---");
        int[] sectionA2 = {10, 20, 15};
        int[] sectionB2 = {10, 25, 40};
        System.out.println("Input: sectionA={10,20,15}, sectionB={10,25,40}");
        System.out.print("Output: ");
        analyzeInventory(sectionA2, sectionB2);
    }
}
