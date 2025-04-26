package converter;

import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Concrete implementation of the ImageConverter interface for converting images to PNG format.
 * Uses the Java Image I/O API (javax.imageio) to perform the conversion.
 */

public class PNGConverter implements ImageConverter {
    @Override
    public void convert(File source, File target) {
        try {
            // Read the image from the source file into a BufferedImage object
            BufferedImage image = ImageIO.read(source);
            // Write the BufferedImage to the target file in PNG format
            ImageIO.write(image, "png", target);
        } catch (Exception e) {
            // Catch any exceptions that occur during reading or writing
            e.printStackTrace();
        }
    }
}
