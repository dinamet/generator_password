import java.util.Scanner;
import java.util.Random;

public class Password {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // many characters for password
        final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
        final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String DIGITS = "0123456789";
        final String SYMBOLS = "!@#$%^&*()-_=+[]{}|;:,.<>?/";

        // password length request
        System.out.print("Enter the minimum length of password:");
        int minlength = input.nextInt();
        System.out.print("Enter the maximum length of password:");
        int maxlength = input.nextInt();

        // input to include different types of characters
        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = input.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = input.next().equalsIgnoreCase("yes");

        System.out.print("Include digits? (yes/no): ");
        boolean includeDigits = input.next().equalsIgnoreCase("yes");

        System.out.print("Include symbols? (yes/no): ");
        boolean includeSymbols = input.next().equalsIgnoreCase("yes");

        // set of symbols for password
        StringBuilder chars = new StringBuilder();
        if (includeLowercase) chars.append(LOWERCASE);
        if (includeUppercase) chars.append(UPPERCASE);
        if (includeDigits) chars.append(DIGITS);
        if (includeSymbols) chars.append(SYMBOLS);

        // generate random length of password
        int passwordLength = random.nextInt(maxlength-minlength+1) + minlength;
        StringBuilder password = new StringBuilder();

        // generate password
        for (int i=0; i<passwordLength; i++){
            int index = random.nextInt(chars.length());
            password.append(chars.charAt(index));
        }

        System.out.println();
        System.out.println("Generated password: " + password);

        // estimation of password complexity
        int strength = getPasswordStrength(password.toString());
        System.out.println("Password strength: " + getStrengthLabel(strength));

    }

    public static int getPasswordStrength(String password) {
        int score = 0;

        // length of password
        if (password.length() >= 12) {
            score+=2; // long password = 2 points
        } else if (password.length() >= 8) {
            score+=1; // medium length password = 1 points
        } else {
            score+=0; // short password = 0 points
        }

        // presence of lowercase letters
        if (password.matches(".*[a-z].*")) {
            score+=1;
        }

        // presence of uppercase letters
        if (password.matches(".*[A-Z].*")) {
            score+=1;
        }

        // presence of digits
        if (password.matches(".*[0-9].*")) {
            score+=1;
        }

        // presence of symbols
        if (password.matches(".*[!@#$%^&*()\\-_=+\\[\\]{}|;:,.<>?/].*")) {
            score+=1;
        }

        // unique symbols
        if (password.matches(".*[a-zA-Z0-9].*") && password.matches(".*[!@#$%^&*()-_=+\\[\\]{}|;:,.<>?/].*")) {
            score+=1; // Если используются как буквы, так и символы
        }

        return score;
    }

    // strength of password
    public static String getStrengthLabel(int score) {
        switch (score) {
            case 6:
                return "Very Strong";
            case 5:
                return "Strong";
            case 4:
                return "Medium";
            case 3:
                return "Weak";
            default:
                return "Very Weak";
        }
    }
}
