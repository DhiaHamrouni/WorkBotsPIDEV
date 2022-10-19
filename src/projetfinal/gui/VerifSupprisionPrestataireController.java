/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projetfinal.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import projetfinal.services.PrestataireService;

/**
 * FXML Controller class
 *
 * @author GAMING
 */
public class VerifSupprisionPrestataireController implements Initializable {

    @FXML
    private Button btnOuiSuppPres;
    @FXML
    private Button btnNonSuppPres;
    private int id;
    /**
     * Initializes the controller class.
     */
    public void setid(int idd){
    id=idd;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void btnOuiSuppPresAction(ActionEvent event) {
        PrestataireService ps = new PrestataireService();
        ps.SupprimerPrestataire(id);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Prestataire.fxml"));
        try {
            Parent root = loader.load();
            btnOuiSuppPres.getScene().setRoot(root);
            PrestataireController pc =loader.getController();
            pc.tfResultat.setText("Prestataire supprimer");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void btnNonSuppPresAction(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Prestataire.fxml"));
        try {
            Parent root = loader.load();
            btnNonSuppPres.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
