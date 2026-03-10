module chrollo.roguelike {
    requires javafx.controls;
    requires javafx.fxml;


    opens chrollo.roguelike to javafx.fxml;
    exports chrollo.roguelike;
}