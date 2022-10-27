package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import utils.MyConnexion;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LastReset {
    @FXML
    PasswordField tfmdp;
    @FXML
    PasswordField tfmdp1;
    @FXML
    Label eroor;
    Stage stage;

    public void confirmmdp(ActionEvent event) throws IOException, SQLException {
        if ((tfmdp.getText()).equals(tfmdp1.getText())){
            String req3="UPDATE `users` SET password=? where email='"+ForgorCntrl.savedEmail+"'";
            PreparedStatement pst1 = new MyConnexion().getCnx().prepareStatement(req3);
            pst1.setString(1,tfmdp.getText());
            pst1.executeUpdate();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/authetification.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();

        }
        else {
            eroor.setText("LES MOTS DE PASSES NE SONT PAS IDENTIQUES");
        }
    }
}
