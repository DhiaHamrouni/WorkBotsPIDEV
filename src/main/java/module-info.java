module com.example.workbotspidev {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.workbotspidev to javafx.fxml;
    opens controller to javafx.fxml;
    opens entite to javafx.fxml;
    exports com.example.workbotspidev;
    exports controller;
    exports entite;
}