package TextFormatter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Text Formatter Console App ===");

        while (true) {
            System.out.print("\nEnter a string to format (or 'exit' to quit): ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) break;

            System.out.print("Choose format (upper / lower / capitalize): ");
            String choice = scanner.nextLine().trim();

            Formatter formatter = FormatterFactory.getFormatter(choice);
            if (formatter == null) {
                System.out.println("❌ Invalid format type.");
                continue;
            }

            String result = formatter.format(input);
            System.out.println("Formatted Output: " + result);
        }

        System.out.println("\nThanks for using the Text Formatter App!");
    }
}