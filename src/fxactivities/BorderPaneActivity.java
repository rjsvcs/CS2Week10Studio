package fxactivities;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BorderPaneActivity extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane pane = new BorderPane();

        pane.setLeft(makeLabel("Thunder", Color.PINK));
        pane.setRight(makeLabel("Mr. J", Color.LIGHTBLUE));
        pane.setCenter(makeLabel("Buttercup", Color.LIGHTGREEN));
        pane.setTop(makeLabel("Lightning", Color.YELLOW));
        pane.setBottom(makeLabel("Cutie", Color.PEACHPUFF));

        stage.setTitle("BorderPane Activity");
        stage.setScene(new Scene(pane));
        stage.show();
    }

    private static Label makeLabel(String text, Color background) {
        Label label = new Label(text);
        label.setFont(new Font("Arial", 75));
        label.setPadding(new Insets(20));
        label.setBackground(new Background(new BackgroundFill(background,
                CornerRadii.EMPTY, Insets.EMPTY)));
        return label;
    }
}
