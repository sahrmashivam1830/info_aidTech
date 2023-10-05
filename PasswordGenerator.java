import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_+=<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the password: ");
        int length = scanner.nextInt();

        System.out.println("Choose character sets (use 'l' for lowercase, 'u' for uppercase, 'n' for numbers, 's' for special characters): ");
        System.out.print("Enter your choice: ");
        scanner.nextLine(); // Consume the newline character
        String choices = scanner.nextLine();

        String characterSet = "";
        if (choices.contains("l")) {
            characterSet += LOWERCASE_CHARS;
        }
        if (choices.contains("u")) {
            characterSet += UPPERCASE_CHARS;
        }
        if (choices.contains("n")) {
            characterSet += NUMBERS;
        }
        if (choices.contains("s")) {
            characterSet += SPECIAL_CHARS;
        }

        String generatedPassword = generatePassword(length, characterSet);
        System.out.println("Generated Password: " + generatedPassword);

        scanner.close();
    }

    public static String generatePassword(int length, String characterSet) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterSet.length());
            char randomChar = characterSet.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
