package fxactivities;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StackPaneActivity extends Application {
    /**
     * The path to the images.
     */
    private static final String PATH = "file:media/images/emojis/";

    @Override
    public void start(Stage stage) {
        ImageView head = new ImageView(PATH + "headyellow.png");
        ImageView mouth = new ImageView(PATH + "mouthbasic.png");
        ImageView nose = new ImageView(PATH + "nosered.png");
        ImageView eyes = new ImageView(PATH + "eyesblack.png");
        ImageView brows = new ImageView(PATH + "browsbasic.png");

        StackPane pane = new StackPane();
        pane.getChildren().addAll(
                head,
                mouth,
                nose,
                eyes,
                brows
        );

        stage.setTitle("Stack Pane Example");
        stage.setScene(new Scene(pane));
        stage.sizeToScene();
        stage.show();

    }
}
