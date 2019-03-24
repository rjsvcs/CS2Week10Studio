package fxexamples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ButtonExample extends Application {
    @Override
    public void start(Stage stage) {
        Button button = new Button("Click Me!");

        Scene scene = new Scene(button);

        stage.setTitle("Button Example");
        stage.setScene(scene);
        stage.show();
    }
}
