package fxexamples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BorderPaneExample extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane pane = new BorderPane();
        pane.setTop(makeLabel("Top", Color.PINK));
        pane.setCenter(makeLabel("Center", Color.WHITE));
        pane.setLeft(makeLabel("Left", Color.YELLOW));
        pane.setRight(makeLabel("Right", Color.LIGHTGREEN));
        pane.setBottom(makeLabel("Bottom", Color.LIGHTBLUE));

        Scene scene = new Scene(pane);

        stage.setTitle("Border Pane Example");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Creates a label with a colored background so that it stands out from
     * the other labels.
     *
     * @param text The text to display on the label.
     * @param background The background {@link Color} to use on the label.
     * @return
     */
    private static Label makeLabel(String text, Color background) {
        Label label = new Label(text);
        label.setPadding(new Insets(20));
        label.setBackground(new Background(new BackgroundFill(background,
                CornerRadii.EMPTY, Insets.EMPTY)));
        return label;
    }
}
