package chrollo.roguelike;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.w3c.dom.css.Rect;

public class FightGrid extends GridPane {

    int cols = 4;
    int rows = 2;
    int SLOT_SIZE = 125;

    public FightGrid() {
        this.setHgap(15);
        this.setVgap(30);
//        this.setAlignment(Pos.CENTER);
//        this.setPrefSize(480, 220);
        createSlots();
    }

    public void createSlots() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Rectangle slot = new Rectangle(SLOT_SIZE, SLOT_SIZE);
                slot.setFill(Color.TRANSPARENT);
                slot.setStroke(Color.web("#555555")); // Dark gray border
                this.add(slot, col, row);
            }
        }
    }
}
