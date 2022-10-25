package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    TextField affclddn;
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
    TextField affclddn1;
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
Stage stage;

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
}
public void editprofile(){
    dashboardanchor.setVisible(false);
    profileanchor.setVisible(false);
    modifanchor.setVisible(true);
    suppranchor.setVisible(false);
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


    public void modifprofile(ActionEvent event) {
    }

    public void changemdpcli(ActionEvent event) {
    }

    public void ouisuppr(ActionEvent event) {
    }

    public void nonsuppr(ActionEvent event) {
    }
}
