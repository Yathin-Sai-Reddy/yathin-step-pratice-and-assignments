public class ExamHallSeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No seat numbers provided.");
            return;
        }

        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            boolean alreadyProcessed = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyProcessed = true;
                    break;
                }
            }

            if (alreadyProcessed) {
                continue;
            }

            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 (With Duplicates) ---");
        int[] test1 = {101, 102, 103, 102, 105};
        System.out.print("Input: {101, 102, 103, 102, 105}\nOutput: ");
        checkDuplicateSeats(test1);

        System.out.println("\n--- Test Case 2 (No Duplicates) ---");
        int[] test2 = {101, 102, 103, 104, 105};
        System.out.print("Input: {101, 102, 103, 104, 105}\nOutput: ");
        checkDuplicateSeats(test2);
    }
}
