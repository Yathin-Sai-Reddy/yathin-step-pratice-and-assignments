import java.util.Locale;
import java.util.Scanner;

public class BankTransactionReferenceValidator {
    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }

        String reference = raw.trim();
        if (reference.length() < 3) {
            return reference.toUpperCase(Locale.ROOT);
        }
        return reference.substring(0, 3).toUpperCase(Locale.ROOT) + reference.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: reference must contain exactly 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < reference.length(); i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: reference body must contain only digits";
            }
        }

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(reference, 0, 3).append("] DATE: ")
                .append(reference, 3, 5).append("/")
                .append(reference, 5, 7).append("/")
                .append(reference, 7, 9).append(" | SEQ: ")
                .append(reference, 9, 14);
        return formatted.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter transaction reference: ");
        String normalized = normalizeReference(scanner.nextLine());
        System.out.println(validateAndFormat(normalized));
    }
}