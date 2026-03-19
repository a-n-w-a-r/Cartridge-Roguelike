package chrollo.roguelike;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.UUID;

public class Character {
    private String MyUUID;
    int maxHealth;
    int damage;
    String name;
    String spritePath;
    Color color;

    public Character (int maxHealth, int damage, String name, String spritePath, Color color) {
        this.MyUUID = UUID.randomUUID().toString();
        this.maxHealth = maxHealth;
        this.damage = damage;
        this.name = name;
        this.spritePath = spritePath;
        this.color = color;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public String getSpritePath() {
        return spritePath;
    }

    public String getUniqueID() {return MyUUID;}


    public static class Card extends Rectangle {
        static double height = 125;
        static double width = 125;

        int x;
        int y;

        Character c;
        Deck parentDeck;

        boolean inDeck;

        public Card(Character c, Deck parentDeck) {
            super(width, height);
            this.setFill(c.color);
            this.setStroke(Color.BLACK);
            this.setStrokeWidth(3);
            this.c = c;
            this.parentDeck = parentDeck;
            this.inDeck = true;

            hoverListener();
            clickListener();
        }

        public void setInDeck(boolean bool) {
            this.inDeck = bool;
        }

        private void hoverListener() {

            TranslateTransition moveUp = new TranslateTransition(Duration.millis(200), this);
            moveUp.setFromY(0);
            moveUp.setToY(-10);

            TranslateTransition moveDown = new TranslateTransition(Duration.millis(200), this);
            moveDown.setFromY(-10);
            moveDown.setToY(0);

            this.setOnMouseEntered(event -> {
                if (!inDeck) {
                    return;
                }
                moveDown.stop();
                this.toFront();
                moveUp.playFromStart();
//                System.out.println("mouse is hovered over: ");
            });

            this.setOnMouseExited(event -> {
                if (!inDeck) {
                    return;
                }
                moveUp.stop();
                parentDeck.resetZindex(this);
                moveDown.playFromStart();
//                System.out.println("mouse is not hovered over: ");
            });
        }

        private void clickListener() {
            this.setOnMouseClicked(event -> {
                if (!inDeck){
                    return;
                }
                String id = this.c.getUniqueID();
                parentDeck.setSelectedCard(this);
            });
        }
    }
}
