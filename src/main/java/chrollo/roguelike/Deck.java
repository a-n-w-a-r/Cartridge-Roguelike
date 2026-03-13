package chrollo.roguelike;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Deck extends Pane {

    int cardWidth = 125;

    ArrayList<Character> cards = new ArrayList<>();
    ArrayList<Character.Card> originalOrder = new ArrayList<>();

    public Deck() {
        cards.add(new Character(100, 20, "Knight", "knight.png",Color.BEIGE));
        cards.add(new Character(50, 40, "Mage", "mage.png", Color.ORANGE));
        cards.add(new Character(80, 25, "Archer", "archer.png", Color.AQUA));
        cards.add(new Character(100, 20, "Knight", "knight.png",Color.BEIGE));
        cards.add(new Character(50, 40, "Mage", "mage.png", Color.ORANGE));
        cards.add(new Character(80, 25, "Archer", "archer.png", Color.AQUA));
        cards.add(new Character(100, 20, "Knight", "knight.png",Color.BEIGE));
        cards.add(new Character(50, 40, "Mage", "mage.png", Color.ORANGE));
        cards.add(new Character(80, 25, "Archer", "archer.png", Color.AQUA));

        this.setPrefSize(480, 250);
        showDeck();
    }

    public void showDeck() {

        double maxDeckWidth = this.getPrefWidth() - cardWidth;
        double overlap = maxDeckWidth / (cards.size() - 1);

        for (int i = 0; i < cards.size(); i++) {

            Character.Card newCard = new Character.Card(cards.get(i), this);
            newCard.setLayoutX(i * overlap);
            newCard.setLayoutY(25);
            originalOrder.add(newCard);
            this.getChildren().add(newCard);
        }
    }

    public void resetZindex(Character.Card card) {

        int correctZ = originalOrder.indexOf(card);
        if (correctZ != -1) {
            this.getChildren().remove(card);
            this.getChildren().add(correctZ, card);
        }
    }
}
