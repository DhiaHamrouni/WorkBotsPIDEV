package controller;
import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Objects;

import com.example.workbotspidev.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import entite.Agent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import services.AgentCRUD;
import utils.MyConnexion;

public class Authcntrl {
    @FXML
    TextField logindh;
    @FXML
    PasswordField pwddh;
    @FXML
    Label Stopright;
    @FXML
    Button createaccount;
    @FXML
    Button identify;
    String login;
    String pass;
    Stage stage;
    Parent root;



    public void switchtocreationcl(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/creationcompte_client.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void AuthBtn(ActionEvent event) throws IOException, SQLException {
        login=logindh.getText();
        pass=pwddh.getText();

        try {
            String req3 = "SELECT * FROM `users` WHERE Email='" + login + "' and Password='" + pass + "'";
            Statement st;
            Connection cnx = MyConnexion.getInstance().getCnx();
            st = cnx.createStatement();
            ResultSet result = st.executeQuery(req3);
            if (result.next()) {
                Stopright.setVisible(true);
            }
            switch (result.getString(3)){
                case ("client"):
                {
                    if (result.getString(4)=="Banned"){
                        Stopright.setVisible(true);
                    }
                    else {
                        String username = logindh.getText();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/client_interface.fxml"));
                        root = loader.load();

                        Clientcntrl scene2Controller = loader.getController();
                        //scene2Controller.getName(result1.getString(4));
                        scene2Controller.getName(username);
                        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
                }
                case ("agent"):
                {
                    if (result.getString(4)=="Banned"){
                        Stopright.setVisible(true);
                    }
                    else {

                    }
                }
                case ("admin"):
                {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/admin_interface.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    stage.setTitle("");
                    stage.setScene(scene);
                    stage.show();
                }
            }
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }


}
