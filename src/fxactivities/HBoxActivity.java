package fxexamples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxExample extends Application {
    @Override
    public void start(Stage stage) {
        HBox hbox = new HBox();
        hbox.getChildren().addAll(
          new Button("Left"),
          new Button("Middle"),
          new Button("Right")
        );

        Scene scene = new Scene(hbox);

        stage.setTitle("HBox Example");
        stage.setScene(scene);
        stage.show();
    }
}
