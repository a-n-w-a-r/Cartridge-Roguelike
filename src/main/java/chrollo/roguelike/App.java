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

    final Pane deckPane = new Pane();

    ArrayList<Character> deck = new ArrayList<>();

    private Parent createContent() {
        root.setPrefSize(960, 540);
        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        Character[] myDeck = {
//                new Character(100, 20, "Knight", "knight.png", Color.BEIGE),
//                new Character(50, 40, "Mage", "mage.png", Color.ORANGE),
//                new Character(80, 25, "Archer", "archer.png", Color.AQUA)
//        };

//        deck.add(new Character(100, 20, "Knight", "knight.png", Color.BEIGE));
//        deck.add(new Character(50, 40, "Mage", "mage.png", Color.ORANGE));
//        deck.add(new Character(80, 25, "Archer", "archer.png", Color.AQUA));

        Deck deckUi = new Deck();

        deckUi.setLayoutX(240); // Centering a 480 width pane in a 960 window
        deckUi.setLayoutY(290);

//        showDeck(deck, deckPane);
        root.getChildren().add(deckUi);
        Scene scene = new Scene(createContent());
        stage.setTitle("Roguelike");
        stage.setScene(scene);
        stage.show();
    }

    public void showDeck(ArrayList<Character> deck, Pane root) {

        double offset = 100;

        for (Character c : deck) {
            Character.Card showCard = new Character.Card(c);
            root.getChildren().add(showCard);

            showCard.setX(offset);
            offset+= 100;
        }
    }
}
