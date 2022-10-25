/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projetfinal.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import projetfinal.entities.Devis;
import projetfinal.services.devisService;

/**
 * FXML Controller class
 *
 * @author GAMING
 */
public class DevisController implements Initializable {

    @FXML
    private Label labelModifier;
    @FXML
    private TextField tfNomClient;
    @FXML
    private TextField tfNomCommerciall;
    @FXML
    private TextField tfMission;
    @FXML
    private Button btnAjouterDevis;
    @FXML
    private Button btnEffacer;
    @FXML
    private Button btnModifierDevis;
    @FXML
    private DatePicker dpDate;
    @FXML
    private DatePicker dpValableJusqua;
    @FXML
    private DatePicker dpDateCommencement;
    @FXML
    private TextField tfPrixHT;
    @FXML
    private TextField tfPrixTTC;
    @FXML
    private TextField tfDescription;
    @FXML
    private Button btnAfficherDevis;
    @FXML
    private TextField tfNumDevis;
    @FXML
    private TableView<Devis> tablePrestataire;
    @FXML
    private TableColumn<Devis, Integer> clm_numDevis;
    @FXML
    private TableColumn<Devis, String> clm_nomClient;
    @FXML
    private TableColumn<Devis, String> clm_nomCommercial;
    @FXML
    private TableColumn<Devis, String> clm_mission;
    @FXML
    private TableColumn<Devis, Date> clm_date;
    @FXML
    private TableColumn<Devis, Date> clm_valableJusquA;
    @FXML
    private TableColumn<Devis, Float> clm_prixTTC;
    @FXML
    private Button btnUpdateDevis;
    @FXML
    private Button btnSupprimerDevis;
    @FXML
    private TextField DevisRechercheF;
    @FXML
    private TableColumn<Devis, Float> clm_prixHT;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficherDevisAction();
        devisService ds = new devisService();
        ObservableList<Devis> deviss = FXCollections.observableList(ds.afficherDevis());
        FilteredList<Devis> filteredData = new FilteredList<>((deviss), b -> true);
        DevisRechercheF.textProperty().addListener(( observable , oldValue, newValue) -> {
            filteredData.setPredicate(d-> {
            if(newValue.isEmpty()  ||newValue == null ){
                return true;
            }
            String searchKeyword = newValue.toLowerCase();
            if(d.getNom_client().toLowerCase().indexOf(searchKeyword) > -1 ){
                return true;
            }else if (d.getNom_commercial().toLowerCase().indexOf(searchKeyword) > -1){
                return true;
            }else 
                return false;
            });
        });
        SortedList<Devis> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tablePrestataire.comparatorProperty());
        
        tablePrestataire.setItems(sortedData);        
    }    
        public int getNum_devis2() {
        return Integer.parseInt(tfNumDevis.getText()) ;
    }
    @FXML
    private void AjouterDevisAction(ActionEvent event) {

        String nom_client=tfNomClient.getText();
        String nom_commercial =tfNomCommerciall.getText();
        Date    date =Date.valueOf(((LocalDate)this.dpDate.getValue()).toString());
        Date    valable_jusqu_a =Date.valueOf(((LocalDate)this.dpValableJusqua.getValue()).toString());
        String  mission = tfMission.getText();
        Date    date_commencement = Date.valueOf(((LocalDate)this.dpDateCommencement.getValue()).toString());
        float   prix_ttc =Float.parseFloat(tfPrixTTC.getText());
        float   prix_ht =Float.parseFloat(tfPrixHT.getText());
        String  description =tfDescription.getText();
        Devis d = new Devis(nom_client, nom_commercial, date, valable_jusqu_a, mission, date_commencement, prix_ttc, prix_ht, description);
        devisService ds =new devisService();
        ds.ajouterPrestataire(d);
        AfficherDevisAction();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation d'ajout ");
        alert.setContentText("Devis ajouter avec succes");
        alert.show();
        tfNomClient.setText("");
        tfNomCommerciall.setText("");
        dpDate.setValue(null);  
        dpValableJusqua.setValue(null); 
        tfMission.setText("");
        dpDateCommencement.setValue(null);
        tfPrixTTC.setText("");
        tfPrixHT.setText("");
        tfDescription.setText("");        
    }

    @FXML
    private void EffacerAction(ActionEvent event) {
    }

    @FXML
    private void ModifierDevisAction(ActionEvent event) {
        String nom_client=tfNomClient.getText();
        String nom_commercial =tfNomCommerciall.getText();
        Date    date =Date.valueOf(((LocalDate)this.dpDate.getValue()).toString());
        Date    valable_jusqu_a =Date.valueOf(((LocalDate)this.dpValableJusqua.getValue()).toString());
        String  mission = tfMission.getText();
        Date    date_commencement = Date.valueOf(((LocalDate)this.dpDateCommencement.getValue()).toString());
        float   prix_ttc =Float.parseFloat(tfPrixTTC.getText());
        float   prix_ht =Float.parseFloat(tfPrixHT.getText());
        String  description =tfDescription.getText();
        Devis d = new Devis(nom_client, nom_commercial, date, valable_jusqu_a, mission, date_commencement, prix_ttc, prix_ht, description);
        devisService ds =new devisService();
        ds.ModifierDevis(d);
        labelModifier.setText("AJOUTER UN DEVIS ");
        btnModifierDevis.setVisible(true);
        btnAjouterDevis.setVisible(false); 
        tfNomClient.setText("");
        tfNomCommerciall.setText("");
        dpDate.setValue(null);  
        dpValableJusqua.setValue(null); 
        tfMission.setText("");
        dpDateCommencement.setValue(null);
        tfPrixTTC.setText("");
        tfPrixHT.setText("");
        tfDescription.setText("");  
    }

    @FXML
    private void AfficherDevisAction() {
                        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        clm_numDevis.setCellValueFactory(new PropertyValueFactory<Devis,Integer>("num_devis"));
        clm_nomClient.setCellValueFactory(new PropertyValueFactory<Devis,String>("nom_client"));
        clm_nomCommercial.setCellValueFactory(new PropertyValueFactory<Devis,String>("nom_commercial"));
        clm_mission.setCellValueFactory(new PropertyValueFactory<Devis,String>("mission"));
        clm_date.setCellValueFactory(new PropertyValueFactory<Devis,Date>("date"));
        clm_valableJusquA.setCellValueFactory(new PropertyValueFactory<Devis,Date>("valable_jusqu_à"));
        clm_prixTTC.setCellValueFactory(new PropertyValueFactory<Devis,Float>("prix_ttc"));
        clm_prixHT.setCellValueFactory(new PropertyValueFactory<Devis,Float>("prix_ht"));
        //add your data to the table here.
                devisService ds = new devisService();
                ObservableList<Devis> devis = FXCollections.observableList(ds.afficherDevis());
                //tablePrestataire.setItems((ObservableList<Prestataire>) ps.afficherPrestataires());
                tablePrestataire.setItems(devis);
    }

    @FXML
    private void UpdateDevisAction(ActionEvent event) {
        labelModifier.setText("MODIFIER CE  DEVIS ");
        
        btnModifierDevis.setVisible(true);
        btnAjouterDevis.setVisible(false);
        index1();
    }

    @FXML
    private void SupprimerDevisAction(ActionEvent event) {
        devisService ds = new devisService();
        int num_devis = Integer.parseInt(tfNumDevis.getText());
        if(ds.RechercherDevis2(num_devis)){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("verifSupprisionDevis.fxml"));
            try {
                Parent root = loader.load();
                VerifSupprisionDevisController vsd =loader.getController();
                vsd.setid(num_devis);
                tfNumDevis.getScene().setRoot(root);
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
    private void index1() {
        devisService ds = new devisService();         
        Devis selectedItem = tablePrestataire.getSelectionModel().getSelectedItem();
        tfNomClient.setText(String.valueOf(selectedItem.getNom_client()));
        tfNomCommerciall.setText(selectedItem.getNom_commercial());
        tfMission.setText(selectedItem.getMission());
        tfPrixTTC.setText(String.valueOf(selectedItem.getPrix_ttc()));
        tfPrixHT.setText(String.valueOf(selectedItem.getPrix_ht()));
        tfDescription.setText(selectedItem.getDescription());
        dpDate.setValue(convert(selectedItem.getDate()));
        dpValableJusqua.setValue(convert(selectedItem.getValable_jusqu_à()));
        dpDateCommencement.setValue(convert(selectedItem.getDate_commencement()));
        
    }   
    public LocalDate convert(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
}
}
