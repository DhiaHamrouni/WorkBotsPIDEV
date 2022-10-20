module com.theagences.theagences {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;

    opens com.theagences.theagences.Controller to javafx.fxml;
    exports com.theagences.theagences;

}