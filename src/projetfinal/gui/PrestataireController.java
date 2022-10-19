/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projetfinal.gui;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import projetfinal.entities.Prestataire;
import projetfinal.services.PrestataireService;

/**
 * FXML Controller class
 *
 * @author GAMING
 */
public class PrestataireController implements Initializable {

    @FXML
    private TextField tfIDPrestataire;
    @FXML
    private TextField tfNomCommercial;
    @FXML
    private TextField tfDomaineService;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfNumTel;
    @FXML
    private Button btnAjouterPrestataire;
    @FXML
    private Button btnEffacer;
    @FXML
    private Button btnAfficherPrestataire;
    @FXML
    private TextField tfIdPrestataire2;
    @FXML
    private Button btnUpdatePrestataire;
    @FXML
    private Button btnSupprimerPrestataire;
    @FXML
    private TableView<Prestataire> tablePrestataire;
    @FXML
    private TableColumn<Prestataire, Integer> clmID;
    @FXML
    private TableColumn<Prestataire, String> clmNomCommercial;
    @FXML
    private TableColumn<Prestataire, String> clmDomaineService;
    @FXML
    private TableColumn<Prestataire, String> clmNumTel;
    @FXML
    private TableColumn<Prestataire, String> clmEmail;
    @FXML
    public TextArea tfResultat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
        public int getId_prestataire2() {
        return Integer.parseInt(tfIdPrestataire2.getText()) ;
    }

    @FXML
    private void AjouterPrestataireAction(ActionEvent event) {
        int id_prestataire = Integer.parseInt(tfIDPrestataire.getText());
        String nom_commercial = tfNomCommercial.getText();
        String domaine_service  = tfDomaineService.getText();
        String num_tel = tfNumTel.getText();
        String email = tfEmail.getText();
        Prestataire p = new Prestataire(id_prestataire, nom_commercial, domaine_service, num_tel, email);
        PrestataireService ps = new PrestataireService();
        ps.ajouterPrestataire(p);
        tfResultat.setText("Prestataire ajouter avec succes");
        
    }

    @FXML
    private void EffacerAction(ActionEvent event) {
        tfResultat.setText("");
    }

    @FXML
    private void AfficherPrestataireAction(ActionEvent event) {
                //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        clmID.setCellValueFactory(new PropertyValueFactory<Prestataire,Integer>("id_prestataire"));
        clmNomCommercial.setCellValueFactory(new PropertyValueFactory<Prestataire,String>("nom_commercial"));
        clmDomaineService.setCellValueFactory(new PropertyValueFactory<Prestataire,String>("domaine_service"));
        clmNumTel.setCellValueFactory(new PropertyValueFactory<Prestataire,String>("num_tel"));
        clmEmail.setCellValueFactory(new PropertyValueFactory<Prestataire,String>("email"));
        //add your data to the table here.
                PrestataireService ps = new PrestataireService();
                ObservableList<Prestataire> prestataires = FXCollections.observableList(ps.afficherPrestataires());
                //tablePrestataire.setItems((ObservableList<Prestataire>) ps.afficherPrestataires());
                tablePrestataire.setItems(prestataires);

    }

    @FXML
    private void UpdatePrestataireAction(ActionEvent event) {
        
    }

    @FXML
    private void SupprimerPrestataireAction(ActionEvent event) {
        PrestataireService ps = new PrestataireService();
        int id_prestataire = Integer.parseInt(tfIdPrestataire2.getText());
        if(ps.RechercherPrestataire2(id_prestataire)){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("verifSupprisionPrestataire.fxml"));
            try {
                Parent root = loader.load();
                VerifSupprisionPrestataireController vsp =loader.getController();
                vsp.setid(id_prestataire);
                tfIdPrestataire2.getScene().setRoot(root);
            } catch (IOException ex) {
                 System.out.println("Error:"+ex.getMessage());
            }
            
        }
                else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("ID  n existe pas !");
            alert.setContentText("Vous navez pas saisie id valide");
            alert.show();
        }
    }
    
}
