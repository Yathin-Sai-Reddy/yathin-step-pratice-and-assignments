import java.util.Scanner;

public class MaskedPhoneNumberFormatter {
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder maskedNumber = new StringBuilder("XXXXXX");
        maskedNumber.insert(maskedNumber.length(), "-");
        maskedNumber.append(phone.substring(6));
        return maskedNumber.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter phone number: ");
        System.out.println(maskPhoneNumber(scanner.nextLine()));
    }
}