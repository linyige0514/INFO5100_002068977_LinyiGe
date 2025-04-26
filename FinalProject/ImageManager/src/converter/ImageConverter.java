package converter;

import java.io.File;

/**
 * Defines the contract for classes that can convert image files from one format to another.
 * Implementations of this interface are responsible for the actual conversion logic.
 */

public interface ImageConverter {
    void convert(File source, File target);
}
