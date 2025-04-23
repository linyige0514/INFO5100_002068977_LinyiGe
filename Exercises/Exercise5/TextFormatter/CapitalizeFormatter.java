package TextFormatter;

public class CapitalizeFormatter implements Formatter {
    @Override
    public String format(String input) {
        if (input == null || input.isEmpty()) return input;
        String[] words = input.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)))
              .append(word.substring(1).toLowerCase())
              .append(" ");
        }
        return sb.toString().trim();
    }
}