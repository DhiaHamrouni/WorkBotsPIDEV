package controller;

import entite.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import services.ClientCRUD;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class AjoutClientCntrl {
    @FXML
    TextField cincl;
    @FXML
    TextField nomcl;
    @FXML
    TextField prenomcl;
    @FXML
    TextField numcl;
    @FXML
    TextField emailcl;
    @FXML
    PasswordField mdpcl;
    @FXML
    TextField adressecl;
    @FXML
    CheckBox checkhomme;
    @FXML
    CheckBox checkfemme;
    @FXML
    DatePicker ddncl;
    @FXML
    Label resul;
    Stage stage;
    ClientCRUD c=new ClientCRUD();
    @FXML
    private void getDate (ActionEvent event){


    }
    public String formatDate(String Date){
        SimpleDateFormat sdf = null;
        java.util.Date d = null;
        try {
            sdf = new SimpleDateFormat("yy-mm-dd");
            d = sdf.parse(Date);
            sdf.applyPattern("EEEE d MMM yyyy");

        } catch (ParseException e) {

            System.out.println(e);
        }


        return sdf.format(d);
    }
    public void retourcreationcl(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/authetification.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void confirmcreationcl(ActionEvent event) throws IOException{
        Client cl=new Client();
        cl.setCIN(cincl.getText());
        cl.setNom(nomcl.getText());
        cl.setPrenom(prenomcl.getText());
        cl.setNum_tel(numcl.getText());
        cl.setEmail(emailcl.getText());
        cl.setMot_de_passe(mdpcl.getText());
        cl.setAdresse(adressecl.getText());
        cl.setDate_naissance(String.valueOf(ddncl.getValue()));
        if (checkhomme.isSelected()){
            cl.setSexe("Homme");
        }
        if (checkfemme.isSelected()){
            cl.setSexe("Femme");
        }
        resul.setText(c.ajouterClient(cl));

    }

}
