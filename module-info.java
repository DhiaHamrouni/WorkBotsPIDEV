

module com.example.newagence{
        requires javafx.controls;
        requires javafx.fxml;
        requires java.sql;
        requires javafx.graphics;

        opens com.example.newagence.controller to javafx.fxml;
        opens com.example.newagence.entities to javafx.fxml;

        exports com.example.newagence;
        exports com.example.newagence.entities;

}