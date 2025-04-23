package TextFormatter;

public class FormatterFactory {
    public static Formatter getFormatter(String type) {
        switch (type.toLowerCase()) {
            case "upper":
                return new UpperCaseFormatter();
            case "lower":
                return new LowerCaseFormatter();
            case "capitalize":
                return new CapitalizeFormatter();
            default:
                return null;
        }
    }
}