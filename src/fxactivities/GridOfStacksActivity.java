package fxactivities;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GridOfStacksActivity extends Application {
    /**
     * Used to pick a random value from a selection of images.
     */
    private static final Random RNG = new Random();

    /**
     * The path to the images.
     */
    private static final String PATH = "file:media/images/emojis/";

    /**
     * Available head images.
     */
    private static final String[] HEADS = {
            "headblue.png", "headgreen.png", "headred.png", "headyellow.png"
    };

    /**
     * Available nose images.
     */
    private static final String[] NOSES = {
            "noseblue.png", "nosegreen.png", "noseorange.png", "nosered.png"
    };

    /**
     * Available eye images.
     */
    private static final String[] EYES = {
            "eyesblack.png", "eyesblue.png", "eyesbrown.png", "eyesgreen.png"
    };


    /**
     * Available eyebrow images.
     */
    private static final String[] BROWS = {
            "browsbasic.png", "browsangry.png", "browshuh.png",
            "browsworried.png"
    };

    /**
     * Available mouth images.
     */
    private static final String[] MOUTHS = {
            "mouthbasic.png", "mouthdelerious.png", "mouthhm.png",
            "mouthohno.png"
    };

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();

        for(int row=0; row<6; row++) {
            for(int col=0; col<6; col++) {
                ImageView head = makeRandomImage(HEADS);
                ImageView nose = makeRandomImage(NOSES);
                ImageView eyes = makeRandomImage(EYES);
                ImageView brows = makeRandomImage(BROWS);
                ImageView mouth = makeRandomImage(MOUTHS);

                StackPane stack = new StackPane();
                stack.getChildren().addAll(head, nose, eyes, brows, mouth);
                gridPane.add(stack, row, col);
            }
        }

        stage.setTitle("GridPane of StackPanes Example");
        stage.setScene(new Scene(gridPane));
        stage.show();
    }

    /**
     * Returns a new {@link ImageView} that chooses a random image from the
     * provided array of possibilities.
     *
     * @param selection The selection of image names.
     * @return A new ImageView that uses a randomly selected image.
     */
    private static ImageView makeRandomImage(String[] selection) {
        int index = RNG.nextInt(selection.length);
        return new ImageView(PATH + selection[index]);
    }
}
