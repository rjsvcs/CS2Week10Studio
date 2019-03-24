package fxactivities;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxActivity extends Application {
    @Override
    public void start(Stage stage) {
        HBox hbox = new HBox();
        hbox.getChildren().addAll(
          new Button("Left Left Left"),
          new Button("Middle Middle\nMiddle Middle"),
          new Button("Right Right Right")
        );

        Scene scene = new Scene(hbox);

        stage.setTitle("HBox Example");
        stage.setScene(scene);
        stage.show();
    }
}
