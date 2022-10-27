package controller;

import entite.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.ClientCRUD;

import java.io.IOException;

public class Clientcntrl {
@FXML
    TextField affclcin;
@FXML
    TextField affclprenom;
@FXML
    TextField affclnom;
@FXML
    TextField affclemail;
@FXML
    TextField affclnum;
@FXML
    TextField affcladr;
@FXML
    TextField affclcin1;
@FXML
    TextField affclprenom1;
@FXML
    TextField affclnom1;
@FXML
    TextField affclemail1;
@FXML
    TextField affclnum1;
@FXML
    TextField affcladr1;
@FXML
    AnchorPane dashboardanchor;
@FXML
    AnchorPane profileanchor;
@FXML
    AnchorPane modifanchor;
@FXML
    AnchorPane suppranchor;
@FXML
    Label dashboard_welcome;
ClientCRUD c=new ClientCRUD();
Stage stage;
@FXML
Label resultmodif;

public void getName(String username){
    dashboard_welcome.setText(username);
}

public void dashboard(){
    dashboardanchor.setVisible(true);
    profileanchor.setVisible(false);
    modifanchor.setVisible(false);
    suppranchor.setVisible(false);

}
public void afficheprofile(){
    dashboardanchor.setVisible(false);
    profileanchor.setVisible(true);
    modifanchor.setVisible(false);
    suppranchor.setVisible(false);
    Client cl=c.AfficherClientCondition1(dashboard_welcome.getText());
    affclcin.setText(cl.getCIN());
    affclprenom.setText(cl.getPrenom());
    affclnom.setText(cl.getNom());
    affclemail.setText(cl.getEmail());
    affclnum.setText(cl.getNum_tel());
    affcladr.setText(cl.getAdresse());
}
public void editprofile(){
    dashboardanchor.setVisible(false);
    profileanchor.setVisible(false);
    modifanchor.setVisible(true);
    suppranchor.setVisible(false);
    Client cl=c.AfficherClientCondition1(dashboard_welcome.getText());
    affclcin1.setText(cl.getCIN());
    affclprenom1.setText(cl.getPrenom());
    affclnom1.setText(cl.getNom());
    affclemail1.setText(cl.getEmail());
    affclnum1.setText(cl.getNum_tel());
    affcladr1.setText(cl.getAdresse());
}
public void supprcompte(){
    dashboardanchor.setVisible(false);
    profileanchor.setVisible(false);
    modifanchor.setVisible(false);
    suppranchor.setVisible(true);
}
public void logout(ActionEvent event) throws IOException{
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/user_interface.fxml"));
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


    public void modifprofile() {
        Client client1=new Client();
        client1.setCIN(affclcin1.getText());
        client1.setPrenom(affclprenom1.getText());
        client1.setNom(affclnom1.getText());
        client1.setEmail(affclemail1.getText());
        client1.setNum_tel(affclnum1.getText());
        client1.setAdresse(affcladr1.getText());
        resultmodif.setText(c.ModifClient(client1,dashboard_welcome.getText()));
        dashboard_welcome.setText(client1.getEmail());
}

    public void ouisuppr(ActionEvent event) throws IOException {
        c.SupprClient(dashboard_welcome.getText());
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/user_interface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void nonsuppr(ActionEvent event) {
        dashboardanchor.setVisible(true);
        profileanchor.setVisible(false);
        modifanchor.setVisible(false);
        suppranchor.setVisible(false);
    }
}
