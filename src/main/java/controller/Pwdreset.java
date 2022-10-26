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
import utils.MyConnexion;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Pwdreset {
@FXML
PasswordField newmdp;
@FXML
    PasswordField newmdpconf;
@FXML
    Label seterror;
String mail;

    public void getemail(String email){
        mail=email;
    }
public void confirmpwreset(ActionEvent event) throws SQLException, IOException {
    if((newmdp.getText()).equals(newmdpconf.getText())){
        String req3="UPDATE `users` SET Password=? where email='"+mail+"'";
        PreparedStatement pst1 = new MyConnexion().getCnx().prepareStatement(req3);
        pst1.setString(1,newmdpconf.getText());
        pst1.executeUpdate();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/authetification.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    else {
        seterror.setText("LES MOTS DE PASSES NE CORRESPONDENT PAS");
    }
}
}
