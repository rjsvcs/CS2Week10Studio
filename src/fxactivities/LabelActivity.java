package fxactivities;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabelActivity extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("This is my label.");
        label.setFont(new Font("Courier New", 72));
        label.setPadding(new Insets(20));
        Scene scene = new Scene(label);

        stage.setTitle("A simple label");
        stage.setScene(scene);
        stage.show();
    }
}
