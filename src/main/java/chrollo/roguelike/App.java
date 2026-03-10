package chrollo.roguelike;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class App extends Application {

    final Pane root = new Pane();

    ArrayList<Character> deck = new ArrayList<>();

    private Parent createContent() {
        root.setPrefSize(960, 540);
        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {

        Deck deckUi = new Deck();

        deckUi.setLayoutX(240);
        deckUi.setLayoutY(290);

        root.getChildren().add(deckUi);
        Scene scene = new Scene(createContent());
        stage.setTitle("Roguelike");
        stage.setScene(scene);
        stage.show();
    }
}
