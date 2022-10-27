package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.EmailSender;
import utils.MyConnexion;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pwdreset {
    @FXML
    TextField emailtf;
    @FXML
    TextField tokentf;
    @FXML
    Label eror;
    public void confirmtoken(ActionEvent event) throws SQLException, IOException {
        if((ForgorCntrl.savedToken).equals(tokentf.getText())){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/last_reset.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();
        }
        else {
                eror.setText("TOKEN N EST PAS CORRECT");
        }
    }
}
