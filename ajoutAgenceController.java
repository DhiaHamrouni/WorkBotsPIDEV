package com.example.newagence.controller;

import com.example.newagence.entities.adresse;
import com.example.newagence.entities.agence;
import com.example.newagence.services.adresseCrud;
import com.example.newagence.services.agenceCrud;
import com.example.newagence.services.rateCrud;
import com.example.newagence.utils.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class ajoutAgenceController implements Initializable {


    /************ ajout d'agence *****************/
    @FXML
    private TextField codeRegionAgence_ID;
    @FXML
    private TextField numeroTel_ID;
    @FXML
    private TextField email_ID;
    @FXML
    private TextField siteWeb_ID;

    @FXML
    private TextField codeRegionAgence_ID3;
    @FXML
    private TextField numeroTel_ID3;
    @FXML
    private TextField email_ID3;
    @FXML
    private TextField siteWeb_ID3;
    @FXML
    private TextField nomDuResponsable_ID;

    @FXML
    private TextField textChercherAgence_ID;


    @FXML
    private TextField nombreDesEmployees_ID;
    @FXML
    private TextField jourDeCreation_ID;
    @FXML
    private Button ajouter_ID;
    @FXML
    private Button supprimer_ID;

    @FXML
    private Button actualiser_ID;

    @FXML
    private Button rechercheID;
    @FXML
    private Button contactID;

    @FXML
    private Button chercherAdresseID;

    @FXML
    private Button ActualiserAdresse;

    @FXML
    private Button actualiserAgencesID;
    @FXML
    private Button toUpdateID;

    @FXML
    private Button toUpdateID2;

    @FXML
    private Button upID;

    @FXML
    private Button finalID;


/*******************************************/
    /********* ajout adresse ***********/

    @FXML
    private TextField codeRegionAdresse_ID;
    @FXML
    private TextField avenue_ID;
    @FXML
    private TextField numeroRue_ID;


    @FXML
    private TextField textChercherAdresse_ID;
    @FXML
    private TextField codePostal_ID;
    /*************Table View agence ****************/
    @FXML
    TableView<agence> tableView_ID;
    @FXML
    TableColumn<agence, String> codeRegionAgence_IDTree;
    @FXML
    TableColumn<agence, String> numeroTel_IDTree;
    @FXML
    TableColumn<agence, String> email_IDTree;
    @FXML
    TableColumn<agence, String> siteWeb_IDTree;
    @FXML
    TableColumn<agence, String> nomDuResponsable_IDTree;
    @FXML
    TableColumn<agence, String> nombreDesEmployees_IDTree;
    @FXML
    TableColumn<agence, String> jourDeCreation_IDTree;

    @FXML
    TableView<adresse> TableView2_ID;
    /******************************/
    @FXML
    TableColumn<adresse, String> codeRegionAdresse_IDTree;
    @FXML
    TableColumn<adresse, String> avenue_IDTree;
    @FXML
    TableColumn<adresse, String> numeroRue_IDTree;
    @FXML
    TableColumn<adresse, String> codePostal_IDTree;
    @FXML
    private Button listRatingAffichage;
    @FXML
    private ListView <String> listRating;





    /**************/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            afficherDirectementAgence();
            afficherDirectementAdresse();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void ajouterAgence(ActionEvent event) {

        String CodeRegionAgence = codeRegionAgence_ID.getText();
        String NumeroTel = numeroTel_ID.getText();
        String Email = email_ID.getText();
        String NomDuResponsable = nomDuResponsable_ID.getText();
        String NomResponsable = nomDuResponsable_ID.getText();
        String NombreEmployees = nombreDesEmployees_ID.getText();
        String JourCreation = jourDeCreation_ID.getText();


        agence A = new agence(CodeRegionAgence, NumeroTel, Email, NomDuResponsable, NomResponsable, NombreEmployees, JourCreation);
        agenceCrud AA = new agenceCrud();
        AA.ajouterAgence1(A);
        tableView_ID.getItems().clear();
        tableView_ID.getItems().addAll(AA.afficherles_agences());


    }
/*********** Button Supprimer ******************************/

/*
    @FXML
    private void supprimerAgence (ActionEvent event) {


            int selectedId=0;
            agenceCrud ac = new agenceCrud();
            int selectedIndex = tableView_ID.getSelectionModel().getSelectedIndex();
            for (int i=0;i<ac.Afficher_agence().size();i++)
            {
                if (i==selectedIndex)
                {
                    selectedId=ac.Afficher_agence().get(i).getIdAgence();
                }
            }
        tableView_ID.getItems().remove(selectedIndex);
            agenceCrud agenci = new agenceCrud();
             //tableView_ID.getItems().clear();
            //ac.SupprimerAgence(Integer.parseInt(rechercherAgence.getText()));
            //agenci.SupprimerAgence(selectedId);
             tableView_ID.getItems().addAll(ac.Afficher_agence());

        }*/


    /***********************AffichageDirectement ******************/


    @FXML
    private void afficherDirectementAgence() {
        codeRegionAgence_IDTree.setCellValueFactory(new PropertyValueFactory<agence, String>("codeRegionAgence"));
        numeroTel_IDTree.setCellValueFactory(new PropertyValueFactory<agence, String>("numeroTel"));
        email_IDTree.setCellValueFactory(new PropertyValueFactory<agence, String>("email"));
        siteWeb_IDTree.setCellValueFactory(new PropertyValueFactory<agence, String>("siteWeb"));
        nomDuResponsable_IDTree.setCellValueFactory(new PropertyValueFactory<agence, String>("nomDuResponsable"));
        nombreDesEmployees_IDTree.setCellValueFactory(new PropertyValueFactory<agence, String>("nombreDesEmployees"));
        jourDeCreation_IDTree.setCellValueFactory(new PropertyValueFactory<agence, String>("jourDeCreation"));
        agenceCrud ps = new agenceCrud();
        ObservableList<agence> agences = FXCollections.observableList(ps.Afficher_agence());
        tableView_ID.setItems(agences);
    }


    @FXML
    private void afficherDirectementAdresse() {
        codeRegionAdresse_IDTree.setCellValueFactory(new PropertyValueFactory<adresse, String>("codeRegionAdresse"));
        avenue_IDTree.setCellValueFactory(new PropertyValueFactory<adresse, String>("avenue"));
        numeroRue_IDTree.setCellValueFactory(new PropertyValueFactory<adresse, String>("numeroRue"));
        codePostal_IDTree.setCellValueFactory(new PropertyValueFactory<adresse, String>("codePostal"));
        adresseCrud ps = new adresseCrud();
        ObservableList<adresse> adresses = FXCollections.observableList(ps.afficherAdresse());
        TableView2_ID.setItems(adresses);
    }


    /*************Supprimer  hela *******************/
    /*@FXML
    public void supprimerAgence (ActionEvent event) {
        agenceCrud hs = new agenceCrud();
        hs.SupprimerAgence(tableView_ID.getSelectionModel().getSelectedItem());
        int selecteditem = tableView_ID.getSelectionModel().getSelectedIndex();
        tableView_ID.getItems().remove(selecteditem);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("bien est supprimée!");
        alert.showAndWait();
        codeRegionAgence_IDTree.setText("");
        numeroTel_IDTree.setText("");
        email_IDTree.setText("");
        siteWeb_IDTree.setText("");
        nomDuResponsable_IDTree.setText("");
        nombreDesEmployees_IDTree.setText("");
        jourDeCreation_IDTree.setText("");

    }*/


    /*********************** Supprimer louay ******************/

    @FXML
    private void supprimerAgence(ActionEvent event) {

        int selectedId = 0;
        agenceCrud ac = new agenceCrud();
        int selectedIndex = tableView_ID.getSelectionModel().getSelectedIndex();
        // System.out.println(ac.Afficher_agence().get(1));
        for (int i = 0; i < ac.afficherles_agences().size(); i++) {
            if (i == selectedIndex) {
                selectedId = ac.afficherles_agences().get(i).getIdAgence();
                System.out.println(selectedId);

            }
        }
        tableView_ID.getItems().remove(selectedIndex);
        //AgenceCrud ac = new AgenceCrud();
        tableView_ID.getItems().clear();
        //ac.SupprimerAgence(Integer.parseInt(rechercherAgence.getText()));
        ac.SupprimerAgence(selectedId);
        tableView_ID.getItems().addAll(ac.afficherles_agences());

    }

    /************************************************** */


    @FXML
    private void actualiser(ActionEvent event) {
        agenceCrud ac = new agenceCrud();
        tableView_ID.getItems().clear();
        tableView_ID.getItems().addAll(ac.afficherles_agences());

    }

    @FXML
    private void rechercheAction(ActionEvent event) {
        agenceCrud r = new agenceCrud();
        tableView_ID.getItems().clear();
        System.out.println(r.RechercherAgence(textChercherAgence_ID.getText()));
        tableView_ID.getItems().addAll(r.RechercherAgence(textChercherAgence_ID.getText()));

    }

    /************************************ ajouter Adresse ***********************/

    @FXML
    private void ajouterAdresse(ActionEvent event) {

        String CodeRegionAdresse = codeRegionAdresse_ID.getText();
        String Avenue = avenue_ID.getText();
        String NumeroRue = numeroRue_ID.getText();
        String CodePostal = codePostal_ID.getText();
        adresse AD = new adresse(CodeRegionAdresse, Avenue, NumeroRue, CodePostal);
        adresseCrud ADD = new adresseCrud();
        ADD.ajouterAdresse3(AD);
        TableView2_ID.getItems().clear();
        TableView2_ID.getItems().addAll(ADD.afficherAdresse());

    }

    /************************************* supprimer *********************/

    @FXML
    private void supprimerAdresse(ActionEvent event) {

        int selectedId = 0;
        adresseCrud ac = new adresseCrud();
        int selectedIndex = TableView2_ID.getSelectionModel().getSelectedIndex();
        // System.out.println(ac.Afficher_agence().get(1));
        for (int i = 0; i < ac.afficherAdresse().size(); i++) {
            if (i == selectedIndex) {
                selectedId = ac.afficherAdresse().get(i).getIdAdresse();
                System.out.println(selectedId);

            }
        }
        TableView2_ID.getItems().remove(selectedIndex);
        //AgenceCrud ac = new AgenceCrud();
        TableView2_ID.getItems().clear();
        //ac.SupprimerAgence(Integer.parseInt(rechercherAgence.getText()));
        ac.SupprimerAdresse(selectedId);
        TableView2_ID.getItems().addAll(ac.afficherAdresse());

    }

    @FXML
    private void chercherAdresseAction(ActionEvent event) {
        adresseCrud r = new adresseCrud();
        TableView2_ID.getItems().clear();
        TableView2_ID.getItems().addAll(r.RechercherAdresse(textChercherAdresse_ID.getText()));


    }

    @FXML
    private void ActualiserAdresse(ActionEvent event) {
        adresseCrud r = new adresseCrud();
        TableView2_ID.getItems().clear();
        TableView2_ID.getItems().addAll(r.afficherAdresse());

    }

    @FXML
    private void actualiserAgencesAction(ActionEvent event) {
        agenceCrud r = new agenceCrud();
        tableView_ID.getItems().clear();
        tableView_ID.getItems().addAll(r.Afficher_agence());

    }

    @FXML
    private void toUpdateAction(ActionEvent event) {

        agence selectedItem = tableView_ID.getSelectionModel().getSelectedItem();
        //tfidad.setText(String.valueOf(selectedItem.getId()));
        codeRegionAgence_ID.setText(selectedItem.getCodeRegionAgence());
        numeroTel_ID.setText(selectedItem.getNumeroTel());
        email_ID.setText(selectedItem.getEmail());
        siteWeb_ID.setText(selectedItem.getSiteWeb());
        nomDuResponsable_ID.setText(selectedItem.getNomDuResponsable());
        nombreDesEmployees_ID.setText(selectedItem.getNombreDesEmployees());
        jourDeCreation_ID.setText(selectedItem.getJourDeCreation());

    }

    @FXML
    private void toUpdateAction2(ActionEvent event) {

        adresse selectedItem = TableView2_ID.getSelectionModel().getSelectedItem();
        //tfidad.setText(String.valueOf(selectedItem.getId()));
        codeRegionAdresse_ID.setText(selectedItem.getCodeRegionAdresse());
        avenue_ID.setText(selectedItem.getAvenue());
        numeroRue_ID.setText(selectedItem.getNumeroRue());
        codePostal_ID.setText(selectedItem.getCodePostal());


    }

    @FXML
    private void upAction(ActionEvent event) {
        agence selectedItem = tableView_ID.getSelectionModel().getSelectedItem();


        agenceCrud hs = new agenceCrud();
        agence A = new agence(codeRegionAgence_ID.getText(), numeroTel_ID.getText(), email_ID.getText(), siteWeb_ID.getText(), nomDuResponsable_ID.getText(), nombreDesEmployees_ID.getText(), jourDeCreation_ID.getText());

        try {

            String sql = "UPDATE `agence` SET `codeRegionAgence`= ? ,`numeroTel`=?,`email`=?,`siteWeb`= ? ,`nomDuResponsable`= ? ,`nombreDesEmployees`=?,`jourDeCreation`=? WHERE codeRegionAgence= ?";

            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(sql);

            selectedItem = tableView_ID.getSelectionModel().getSelectedItem();

            pst.setString(1, A.getCodeRegionAgence());
            pst.setString(2, A.getNumeroTel());
            pst.setString(3, A.getEmail());
            pst.setString(4, A.getSiteWeb());
            pst.setString(5, A.getNomDuResponsable());
            pst.setString(6, A.getNombreDesEmployees());
            pst.setString(7, A.getJourDeCreation());
            pst.setString(8, selectedItem.getCodeRegionAgence());


            int i = pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("agence modifié!");
            alert.showAndWait();
            codeRegionAgence_ID.setText("");
            numeroTel_ID.setText("");
            email_ID.setText("");
            siteWeb_ID.setText("");
            nomDuResponsable_ID.setText("");
            nombreDesEmployees_ID.setText("");
            jourDeCreation_ID.setText("");


        } catch (SQLException ex) {
            System.out.println("Problem");
            System.out.println(ex.getMessage());
        }
        tableView_ID.getItems().clear();
        tableView_ID.getItems().addAll(hs.Afficher_agence());

    }


    /*@FXML
    private void upAction(ActionEvent event) {

        String CodeRegionAgence = codeRegionAgence_ID.getText();
        String NumeroTel = numeroTel_ID.getText();
        String Email = email_ID.getText();
        String NomDuResponsable = nomDuResponsable_ID.getText();
        String NomResponsable = nomDuResponsable_ID.getText();
        String NombreEmployees = nombreDesEmployees_ID.getText();
        String JourCreation = jourDeCreation_ID.getText();



        agence A = new agence(CodeRegionAgence, NumeroTel, Email, NomDuResponsable, NomResponsable, NombreEmployees, JourCreation);
        agenceCrud AA = new agenceCrud();
        AA.ajouterAgence5(A);
        tableView_ID.getItems().clear();
        tableView_ID.getItems().addAll(AA.afficherles_agences());


    }*/

    @FXML
    private void listRatingAffichageAction(ActionEvent event) throws SQLException {
    rateCrud rt = new rateCrud();
    listRating.getItems().addAll(rt.calculeRating());

    }

    @FXML
    private void finalAction(ActionEvent event) throws SQLException {

        adresse selectedItem = TableView2_ID.getSelectionModel().getSelectedItem();


        adresseCrud hs = new adresseCrud();
        adresse A = new adresse(codeRegionAdresse_ID.getText(), avenue_ID.getText(), numeroRue_ID.getText(), codePostal_ID.getText());

        try {

            String sql = "UPDATE `adresse` SET `codeRegionAdresse`= ? ,`avenue`=?,`numeroRue`=?,`codePostal`= ?  WHERE codeRegionAdresse= ?";

            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(sql);

            selectedItem = TableView2_ID.getSelectionModel().getSelectedItem();

            pst.setString(1, A.getCodeRegionAdresse());
            pst.setString(2, A.getAvenue());
            pst.setString(3, A.getNumeroRue());
            pst.setString(4, A.getCodePostal());
            pst.setString(5, selectedItem.getCodeRegionAdresse());


            int i = pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("adresse modifié!");
            alert.showAndWait();
            codeRegionAdresse_ID.setText("");
            avenue_ID.setText("");
            numeroRue_ID.setText("");
            codePostal_ID.setText("");



        } catch (SQLException ex) {
            System.out.println("Problem");
            System.out.println(ex.getMessage());
        }
        TableView2_ID.getItems().clear();
        TableView2_ID.getItems().addAll(hs.afficherAdresse());

    }
}