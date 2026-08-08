import java.util.Locale;

public class TypingSpeedAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input strings.");
            return;
        }

        int total = original.length();
        if (total == 0) {
            System.out.println("Matched: 0/0 | Accuracy: 100.00% | No Mismatches");
            return;
        }

        int matchedCount = 0;
        int firstMismatchPos = -1;
        char origChar = '\0';
        char typedChar = '\0';

        for (int i = 0; i < total; i++) {
            char o = original.charAt(i);
            char t = (i < typed.length()) ? typed.charAt(i) : '\0';

            if (o == t) {
                matchedCount++;
            } else {
                if (firstMismatchPos == -1) {
                    firstMismatchPos = i + 1;
                    origChar = o;
                    typedChar = t;
                }
            }
        }

        double accuracy = ((double) matchedCount / total) * 100.0;

        String mismatchMessage;
        if (firstMismatchPos == -1 && typed.length() == original.length()) {
            mismatchMessage = "No Mismatches";
        } else {
            mismatchMessage = String.format("First Mismatch at position %d ('%c' vs '%c')", firstMismatchPos, origChar, typedChar);
        }

        System.out.printf(Locale.US, "Matched: %d/%d | Accuracy: %.2f%% | %s%n", matchedCount, total, accuracy, mismatchMessage);
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        String original1 = "hello world";
        String typed1 = "hello worlt";
        System.out.println("Input: original=\"" + original1 + "\", typed=\"" + typed1 + "\"");
        System.out.print("Output: ");
        checkTypingAccuracy(original1, typed1);

        System.out.println("\n--- Test Case 2 ---");
        String original2 = "coding";
        String typed2 = "coding";
        System.out.println("Input: original=\"" + original2 + "\", typed=\"" + typed2 + "\"");
        System.out.print("Output: ");
        checkTypingAccuracy(original2, typed2);
    }
}
