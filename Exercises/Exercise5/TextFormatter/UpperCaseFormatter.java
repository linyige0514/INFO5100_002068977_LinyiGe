package TextFormatter;

public class UpperCaseFormatter implements Formatter {
    @Override
    public String format(String input) {
        return input.toUpperCase();
    }
}