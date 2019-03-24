package fxexamples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class GridPaneExample extends Application {
    private static final Random RNG = new Random();

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();

        for(int row=0; row<5; row++) {
            for(int col=0; col<5; col++) {
                Label label = makeLabel(row, col);
                gridPane.add(label, col, row);
            }
        }

        stage.setTitle("GridPane Example");
        stage.setScene(new Scene(gridPane));
        stage.show();
    }

    private static Label makeLabel(int row, int col) {
        Label label = new Label("R" + row + ",C" + col);
        label.setFont(new Font("Courier New", 18));
        label.setPadding(new Insets(10));

        double red = RNG.nextDouble();
        double green = RNG.nextDouble();
        double blue = RNG.nextDouble();
        Color color = Color.color(red, green, blue);

        label.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY,
                Insets.EMPTY)));
        return label;
    }
}
