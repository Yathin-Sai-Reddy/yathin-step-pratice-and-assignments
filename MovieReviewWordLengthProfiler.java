public class MovieReviewWordLengthProfiler {

    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");
            int length = cleanWord.isEmpty() ? word.length() : cleanWord.length();

            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        String review1 = "This movie was absolutely fantastic and thrilling";
        System.out.println("Input: \"" + review1 + "\"");
        System.out.print("Output: ");
        classifyWordLengths(review1);

        System.out.println("\n--- Test Case 2 ---");
        String review2 = "A great film with wonderful acting and stunning cinematography";
        System.out.println("Input: \"" + review2 + "\"");
        System.out.print("Output: ");
        classifyWordLengths(review2);
    }
}
