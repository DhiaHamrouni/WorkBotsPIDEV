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
import services.EmailSender;
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
    Label dmgcontrol;
@FXML
    TextField tfprenom;
@FXML
    Label lab1;
static String savedToken;
static String savedEmail;
EmailSender send=new EmailSender();

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

public void cofirm1(ActionEvent event) throws MessagingException,IOException {
    if((tfemail.getText()).isEmpty()){
        dmgcontrol.setText("REMPLIR LE CHAMP D'ABORD SVP");
    }
    else {
    if (isValid(tfemail.getText())){
        String token =tokenGenerator();
        savedToken=token;
        savedEmail=tfemail.getText();
        send.sendEmailWithAttachments(tfemail.getText(),"password reset","Welcome, You have asked for a password reset. Please user this code in the reset password window:"+ token,token);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/pwdreset.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
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
