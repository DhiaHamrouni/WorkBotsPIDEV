package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.MyConnexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Usercntrl {
    @FXML
    TextField login_user;
    @FXML
    PasswordField mdp_user;
    String login;
    String mdp;
    Stage stage;

    public void btnuser(ActionEvent event) throws IOException, SQLException {
        login=login_user.getText();
        mdp=mdp_user.getText();
        try{
            String req3 = "SELECT * FROM `users` WHERE Email='"+login+"' and Password='"+mdp+"'";
            Statement st ;
            Connection cnx = MyConnexion.getInstance().getCnx();
            st = cnx.createStatement();
            ResultSet result = st.executeQuery(req3);
            if (result.next()==false){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/authetification.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setTitle("");
                stage.setScene(scene);
                stage.show();
            }

            switch (result.getString(3)){
                case ("client"):
                {
                    if (result.getString(4)=="Banned"){
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/authetification.fxml"));
                        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
                        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        stage.setTitle("");
                        stage.setScene(scene);
                        stage.show();
                    }
                    else {
                        String username = login_user.getText();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/client_interface.fxml"));
                        Parent root = loader.load();

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
