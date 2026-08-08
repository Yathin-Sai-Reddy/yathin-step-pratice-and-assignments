public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal data provided.");
            return;
        }

        char maxColor = signalLog.charAt(0);
        int maxLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);
            if (c == currentColor) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxColor = currentColor;
                }
                currentColor = c;
                currentLength = 1;
            }
        }

        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxColor = currentColor;
        }

        System.out.println("Longest Streak: '" + maxColor + "' repeated " + maxLength + " times");
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        String log1 = "RRGGGYRR";
        System.out.println("Input: \"" + log1 + "\"");
        System.out.print("Output: ");
        findLongestStreak(log1);

        System.out.println("\n--- Test Case 2 ---");
        String log2 = "RRRRYYGG";
        System.out.println("Input: \"" + log2 + "\"");
        System.out.print("Output: ");
        findLongestStreak(log2);
    }
}
