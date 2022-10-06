module com.vivalavilla.vivalavilla {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vivalavilla.vivalavilla to javafx.fxml;
    exports com.vivalavilla.vivalavilla;
}