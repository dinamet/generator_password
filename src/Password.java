import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        StringBuilder password = new StringBuilder();

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

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeUppercase = input.next().equalsIgnoreCase("yes");

        System.out.print("Include digits? (yes/no): ");
        boolean includeDigits = input.next().equalsIgnoreCase("yes");

        System.out.print("Include symbols? (yes/no): ");
        boolean includeSymbols = input.next().equalsIgnoreCase("yes");

        StringBuilder chars = new StringBuilder();
        if (includeLowercase) chars.append(LOWERCASE);
        if (includeUppercase) chars.append(UPPERCASE);
        if (includeDigits) chars.append(DIGITS);
        if (includeSymbols) chars.append(SYMBOLS);



        password.setLength(int maxlength);



    }
}