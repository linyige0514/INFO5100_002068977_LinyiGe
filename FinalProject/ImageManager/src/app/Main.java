package app;

import app.controller.ImageController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class to launch the ImageManager application.
 * This class extends javafx.application.Application and sets up the primary stage.
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) {

        // Create the main controller for the application
        ImageController controller = new ImageController();

        // Set the title of the primary stage
        stage.setTitle("Image Uploader");

        // Create and set the scene on the stage using the controller's method
        stage.setScene(controller.createScene(stage));
        
        // Display the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
