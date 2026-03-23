package chrollo.roguelike;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Deck extends Pane {

    int cardWidth = 125;

    ArrayList<Character> cards = new ArrayList<>();
    ArrayList<Character.Card> originalOrder = new ArrayList<>();

    private String selectedCardId;
    private Character.Card selectedCard;

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

        this.getChildren().clear();
        originalOrder.clear();

        for (Character data : cards) {

            if (data.inDeck) {
                Character.Card newCard = new Character.Card(data, this);
                this.getChildren().add(newCard);
            }
        }
        deckLayout();
    }

    public void deckLayout() {
        int remainingCards = this.getChildren().size();

        if (remainingCards == 0) {
            return;
        }

        double maxDeckWidth = this.getPrefWidth() - cardWidth;
        double overlap = (remainingCards > 1) ? maxDeckWidth / (remainingCards - 1) : 0;

        originalOrder.clear();

        int cardIndex = 0;
        for (Node child : this.getChildren()) {
            if (child instanceof Character.Card card) {
                card.setLayoutX(cardIndex * overlap);
                card.setLayoutY(25);

                originalOrder.add(card);
                cardIndex++;
            }
        }
    }

    public void resetZindex(Character.Card card) {

        int correctZ = originalOrder.indexOf(card);
        if (correctZ != -1) {
            this.getChildren().remove(card);
            this.getChildren().add(correctZ, card);
        }
    }

    public void setSelectedCard(Character.Card selectedCard) {

        if (this.selectedCard != null) {
            this.selectedCard.setStroke(Color.BLACK);
        }
        if (selectedCard != null) {
            this.selectedCard = selectedCard;
            this.selectedCard.setStroke(Color.GOLD);
        }
    }

    public Character.Card getSelectedCard() {
        return selectedCard;
        }
}
