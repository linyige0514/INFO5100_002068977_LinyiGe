package converter;

/**
 * Factory class for creating instances of ImageConverter.
 * Implements the Factory Design Pattern to provide the appropriate
 * converter implementation based on the desired output format.
 */

public class ConverterFactory {

    /**
     * Returns an appropriate ImageConverter implementation based on the specified format.
     * Supports "jpg", "jpeg", and "png" formats.
     *
     * @param format The target image format string (e.g., "jpg", "png"). Case-insensitive.
     * @return An instance of a class implementing the ImageConverter interface
     * for the specified format.
     * @throws IllegalArgumentException if the specified format is not supported.
     */

    public static ImageConverter getConverter(String format) {
        switch (format.toLowerCase()) {
            case "jpg":
            case "jpeg":
                return new JPGConverter();
            case "png":
                return new PNGConverter();
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }
}
