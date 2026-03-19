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

//        deckUi.setLayoutX(240);
//        deckUi.setLayoutY(290);
        deckUi.layoutXProperty().bind(root.widthProperty().divide(2).subtract(deckUi.widthProperty().divide(2)));
        deckUi.layoutYProperty().bind(root.heightProperty().multiply(0.8).subtract(deckUi.heightProperty().divide(2)));


        FightGrid fightGrid = new FightGrid();

        fightGrid.layoutXProperty().bind(root.widthProperty().divide(2).subtract(fightGrid.widthProperty().divide(2)));
        fightGrid.layoutYProperty().bind(root.heightProperty().multiply(0.3).subtract(fightGrid.heightProperty().divide(2)));

        FightManager fightManager = new FightManager(deckUi, fightGrid);
        fightGrid.setManager(fightManager);

        root.getChildren().add(deckUi);
        root.getChildren().add(fightGrid);
        Scene scene = new Scene(createContent());
        stage.setTitle("Roguelike");
        stage.setScene(scene);
        stage.show();
    }
}
