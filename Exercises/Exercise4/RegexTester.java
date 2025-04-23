import java.util.*;
import java.util.regex.*;

public class RegexTester {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Integer, PatternInfo> patterns = Map.of(
            1, new PatternInfo("Email address", "^[\\w.-]+@[\\w.-]+\\.\\w+$"),
            2, new PatternInfo("US Phone number (123-456-7890)", "^\\d{3}-\\d{3}-\\d{4}$"),
            3, new PatternInfo("Only letters", "^[a-zA-Z]+$"),
            4, new PatternInfo("Date (yyyy-mm-dd)", "^\\d{4}-\\d{2}-\\d{2}$"),
            5, new PatternInfo("Postal code (5 digits)", "^\\d{5}$")
        );

        System.out.println("=== Regex Tester Console App ===");

        while (true) {
            printMenu(patterns);
            System.out.print("Enter pattern number (or 0 to exit): ");
            int choice = getIntInput();

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            if (!patterns.containsKey(choice)) {
                System.out.println("❌ Invalid choice. Try again.\n");
                continue;
            }

            PatternInfo selected = patterns.get(choice);
            System.out.println("Selected Pattern: " + selected.description);
            System.out.println("Regex: " + selected.regex);
            System.out.print("Enter a string to test: ");
            String input = scanner.nextLine();

            boolean match = Pattern.matches(selected.regex, input);
            System.out.println(match ? "✅ MATCH\n" : "❌ NO MATCH\n");
        }
    }

    private static void printMenu(Map<Integer, PatternInfo> patterns) {
        System.out.println("\nAvailable Patterns:");
        for (Map.Entry<Integer, PatternInfo> entry : patterns.entrySet()) {
            System.out.printf("%d. %s\n", entry.getKey(), entry.getValue().description);
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

    // Helper class to pair pattern name and regex
    private static class PatternInfo {
        String description;
        String regex;

        PatternInfo(String description, String regex) {
            this.description = description;
            this.regex = regex;
        }
    }
}