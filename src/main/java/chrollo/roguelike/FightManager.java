package chrollo.roguelike;

import javafx.scene.paint.Color;

public class FightManager {

    Deck myDeck;
    FightGrid myFightGrid;

    public FightManager(Deck myDeck, FightGrid myFightGrid) {
        this.myDeck = myDeck;
        this.myFightGrid = myFightGrid;
    }

    public void moveCardToGrid(int col, int row) {

        Character.Card selectedCard = myDeck.getSelectedCard();

        if (row != 1) {
            return;
        }

        if (selectedCard != null) {
            myDeck.getChildren().remove(selectedCard);

            selectedCard.setInDeck(false);
            selectedCard.setTranslateY(0);
            selectedCard.setStroke(Color.BLACK);

            myFightGrid.add(selectedCard, col, row);
            myDeck.setSelectedCard(null);
        }
    }
}
