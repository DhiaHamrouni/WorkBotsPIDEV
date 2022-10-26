package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.MyConnexion;
import utils.sendEmailSMTP;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class ForgorCntrl {
@FXML
    Label lab;
@FXML
    TextField tfemail;
@FXML
    Button confirm1;
@FXML
    TextField tfcode;
@FXML
    Button confirm2;
@FXML
    Label dmgcontrol;
@FXML
    TextField tfprenom;
@FXML
    Label lab1;
    private String Token;

    public String setToken(String Token) {
        this.Token = Token;
        return Token;
    }

    public String tokenGenerator() {
        Random rnd = new Random();
        String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String token = "";
        for (int i = 0; i < 5; i++) {
            token += alphanumeric.charAt(rnd.nextInt(alphanumeric.length()));
        }
//        System.out.println(token);
        return token;
    }
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

public void cofirm1(){
    if((tfemail.getText()).isEmpty()){
        dmgcontrol.setText("REMPLIR LE CHAMP D'ABORD SVP");
    }
    else {
    if (isValid(tfemail.getText())){
        String token =tokenGenerator();
        new Thread( ()->{
            try {
                sendEmailSMTP.changePasswordEmail(tfprenom.getText(), tfemail.getText(), token);
            } catch (MessagingException ex) {
                Logger.getLogger(ForgorCntrl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
        lab.setVisible(false);
        lab1.setText("Entrer le code recu en mail");
        tfprenom.setVisible(false);
        tfemail.setVisible(false);
        tfcode.setVisible(true);



    }
    }
}
public void cofirm2(ActionEvent event) throws IOException {
    if(setToken(Token).equals(tfcode.getText())){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/pwdreset.fxml"));
        String email= tfemail.getText();
        Pwdreset scene2Controller = fxmlLoader.getController();
        scene2Controller.getemail(email);
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    else {
        dmgcontrol.setText("LE TOKEN EST INCORRECT");
    }
}
public void backtoauth(ActionEvent event) throws IOException{
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/authetification.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setTitle("");
    stage.setScene(scene);
    stage.show();
}


}
