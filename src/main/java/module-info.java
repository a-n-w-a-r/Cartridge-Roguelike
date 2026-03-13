module chrollo.roguelike {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.xml.dom;


    opens chrollo.roguelike to javafx.fxml;
    exports chrollo.roguelike;
}