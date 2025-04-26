package model.metadata;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;

/**
 * Reads metadata from image files using the Metadata Extractor library.
 * Extracts common metadata fields such as width, height, date taken,
 * camera make and model, and GPS location if available.
 * 
 * This class is used by the ImageController to display metadata in the GUI.
 */

public class MetadataReader {

    public static String readMetadata(File file) {
        StringBuilder builder = new StringBuilder();
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);

            // Initialize variables to store extracted key metadata
            String width = null;
            String height = null;
            String dateTaken = null;
            String cameraMake = null;
            String cameraModel = null;
            String location = null;

            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    String tagName = tag.getTagName();
                    String tagDesc = tag.getDescription();

                    // --- Extract specific common tags ---

                    // Width & Height
                    if (tagName.contains("Image Width") && width == null) width = tagDesc;
                    if (tagName.contains("Image Height") && height == null) height = tagDesc;

                    // Camera Make & Model
                    if (tagName.equalsIgnoreCase("Make")) cameraMake = tagDesc;
                    if (tagName.equalsIgnoreCase("Model")) cameraModel = tagDesc;

                    // Date Taken
                    if (tagName.equalsIgnoreCase("Date/Time Original")) dateTaken = tagDesc;

                    // GPS (if available)
                    if (tagName.toLowerCase().contains("latitude") || tagName.toLowerCase().contains("longitude")) {
                        location = (location == null) ? tagDesc : location + ", " + tagDesc;
                    }
                }
            }

            builder.append("Width: ").append(width != null ? width : "N/A").append("\n");
            builder.append("Height: ").append(height != null ? height : "N/A").append("\n");
            builder.append("Date Taken: ").append(dateTaken != null ? dateTaken : "N/A").append("\n");
            builder.append("Camera: ")
                   .append((cameraMake != null || cameraModel != null) 
                           ? (cameraMake + " " + cameraModel) 
                           : "N/A")
                   .append("\n");
            builder.append("Location: ").append(location != null ? location : "N/A");

        } catch (Exception e) {
            builder.append("Failed to read metadata: ").append(e.getMessage());
        }
        return builder.toString();
    }
}
