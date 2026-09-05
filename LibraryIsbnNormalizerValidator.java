import java.util.Locale;
import java.util.Scanner;

public class LibraryIsbnNormalizerValidator {
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }

        String code = raw.trim();
        if (code.length() < 3) {
            return code.toUpperCase(Locale.ROOT);
        }
        return code.substring(0, 3).toUpperCase(Locale.ROOT) + code.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: code must contain exactly 13 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: code body must contain only digits";
            }
        }

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(code, 0, 3).append("] YEAR: ")
                .append(code, 3, 7).append(" | CATALOG: ")
                .append(code, 7, 13);
        return formatted.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ISBN-style code: ");
        String normalizedCode = normalizeCode(scanner.nextLine());
        System.out.println(validateAndFormat(normalizedCode));
    }
}