package app.controller;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import model.metadata.MetadataReader;
import converter.ImageConverter;
import converter.ConverterFactory;

import java.io.File;

/**
 * Controller for the ImageManager application's main scene.
 * Handles user interactions from the GUI, updates the view,
 * and coordinates between the view, model (metadata), and converter components.
 */

public class ImageController {
    // --- Private UI Elements and State ---
    
    private VBox root;
    private TextArea metadataTextArea;
    private ComboBox<String> formatSelector;
    private Button saveButton;
    private File currentFile;

    /**
     * Creates and configures the main Scene for the ImageManager application.
     * Sets up UI elements, layout, event handlers, and styles.
     */
    public Scene createScene(Stage stage) {
        // --- UI Element Initialization ---
        
        // Upload Button
        Button uploadButton = new Button("Upload Image");

        // Thumbnail view
        ImageView imageView = new ImageView();
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(false);

        // Metadata display
        metadataTextArea = new TextArea();
        metadataTextArea.setPrefRowCount(10);
        metadataTextArea.setWrapText(true);
        metadataTextArea.setPromptText("Metadata will appear here...");

        // Format selection and Save button
        formatSelector = new ComboBox<>();
        formatSelector.getItems().addAll("jpg", "png");
        formatSelector.setValue("png");

        saveButton = new Button("Save Image");
        saveButton.setDisable(true);

        // Layout
        HBox imageRow = new HBox(10, uploadButton, imageView);
        HBox convertRow = new HBox(10, formatSelector, saveButton);

        VBox.setMargin(imageRow, new Insets(10));
        VBox.setMargin(convertRow, new Insets(10));
        VBox.setMargin(metadataTextArea, new Insets(10));

        root = new VBox(10, imageRow, convertRow, metadataTextArea);

        // Upload Button handler
        uploadButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Choose an Image File");
                File file = fileChooser.showOpenDialog(stage);

                if (file != null) {
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);

                    currentFile = file;
                    saveButton.setDisable(false);

                    // Extract metadata and display
                    String metadata = MetadataReader.readMetadata(file);
                    metadataTextArea.setText("Metadata:\n" + metadata);
                }
            }
        });

        // Save Button handler
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (currentFile != null) {
                    String format = formatSelector.getValue();
                    FileChooser saveChooser = new FileChooser();
                    saveChooser.setTitle("Save Converted Image");
                    saveChooser.setInitialFileName("converted-image." + format);
                    File targetFile = saveChooser.showSaveDialog(stage);
                    if (targetFile != null) {
                        ImageConverter converter = ConverterFactory.getConverter(format);
                        converter.convert(currentFile, targetFile);
                    }
                }
            }
        });

        // Create the scene
        Scene scene = new Scene(root, 600, 500);
        scene.getStylesheets().add(getClass().getResource("/resources/styles.css").toExternalForm());
        return scene;
    }
}

