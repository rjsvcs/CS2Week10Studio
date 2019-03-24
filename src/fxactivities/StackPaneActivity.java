package fxexamples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StackPaneExample extends Application {
    @Override
    public void start(Stage stage) {
        ImageView head = new ImageView("file:images/smiley/headyellow.png");
        ImageView mouth = new ImageView("file:images/smiley/mouthbasic.png");
        ImageView nose = new ImageView("file:images/smiley/nosered.png");
        ImageView eyes = new ImageView("file:images/smiley/eyesblack.png");

        StackPane pane = new StackPane();
        pane.getChildren().addAll(
                head,
                mouth,
                nose,
                eyes
        );


        stage.setTitle("Stack Pane Example");
        stage.setScene(new Scene(pane));
        stage.sizeToScene();
        stage.show();

    }
}
