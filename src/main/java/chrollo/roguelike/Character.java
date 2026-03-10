package chrollo.roguelike;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Character {

    int maxHealth;
    int damage;
    String name;
    String spritePath;
    Color color;

    public Character (int maxHealth, int damage, String name, String spritePath, Color color) {
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

    public static class Card extends Rectangle {
        static double height = 200;
        static double width = 200;

        int x;
        int y;

        Character c;

        public Card(Character c) {
            super(width, height);
            this.setFill(c.color);
            this.setStroke(Color.BLACK);
            this.c = c;

            hoverListener();
        }

        private void hoverListener() {

            TranslateTransition moveUp = new TranslateTransition(Duration.millis(200), this);
            moveUp.setFromY(0);
            moveUp.setToY(-10);

            TranslateTransition moveDown = new TranslateTransition(Duration.millis(200), this);
            moveDown.setFromY(-10);
            moveDown.setToY(0);

            this.setOnMouseEntered(event -> {
                moveDown.stop();
                this.toFront();
                moveUp.playFromStart();
//                System.out.println("mouse is hovered over: ");
            });

            this.setOnMouseExited(event -> {
                moveUp.stop();
                moveDown.playFromStart();
//                System.out.println("mouse is not hovered over: ");
            });
        }
    }
}
