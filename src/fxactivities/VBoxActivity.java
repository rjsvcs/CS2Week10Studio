package fxexamples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxExample extends Application {
    @Override
    public void start(Stage stage) {
        VBox vbox = new VBox();
        vbox.getChildren().addAll(
          new Button("Top"),
          new Button("Center"),
          new Button("Bottom")
        );

        Scene scene = new Scene(vbox);

        stage.setTitle("VBox Example");
        stage.setScene(scene);
        stage.show();
    }
}
