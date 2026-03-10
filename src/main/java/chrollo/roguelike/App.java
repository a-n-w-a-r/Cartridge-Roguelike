package chrollo.roguelike;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    final Pane root = new Pane();

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
