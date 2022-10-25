/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projetfinal.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import projetfinal.services.devisService;

/**
 * FXML Controller class
 *
 * @author GAMING
 */
public class VerifSupprisionDevisController implements Initializable {
     private int num_devis;
    @FXML
    private Button btnOuiSuppDevis;
    @FXML
    private Button btnNonSuppDevis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setid(int idd){
    num_devis=idd;
    }
    @FXML
    private void btnOuiSuppDevisAction(ActionEvent event) {
        devisService ds = new devisService();
        ds.SupprimerDevis(num_devis);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Devis.fxml"));
        try {
            Parent root = loader.load();
            btnOuiSuppDevis.getScene().setRoot(root);
            DevisController dc =loader.getController();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void btnNonSuppDevisAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Devis.fxml"));
        try {
            Parent root = loader.load();
            btnNonSuppDevis.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }        
    }
    

