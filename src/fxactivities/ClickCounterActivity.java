package fxactivities;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClickCounter extends Application {
    private int clickCount;

    @Override
    public void start(Stage stage) throws Exception {
        clickCount = 0;

        VBox vbox = new VBox();
        vbox.alignmentProperty().setValue(Pos.CENTER);

        Label counter = new Label(Integer.toString(clickCount));
        counter.setFont(new Font("Courier New", 72));

        Button clicker = new Button("Click Me!");
        clicker.setOnAction(e -> {
            clickCount++;
            counter.setText(Integer.toString(clickCount));
        });

        vbox.getChildren().addAll(
          counter,
          clicker
        );

        stage.setTitle("Click Counter");
        stage.setScene(new Scene(vbox));
        stage.show();
    }
}
