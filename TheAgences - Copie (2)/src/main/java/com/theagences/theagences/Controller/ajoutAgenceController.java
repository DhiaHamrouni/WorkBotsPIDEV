package com.theagences.theagences.Controller;

import com.theagences.theagences.entities.AdresseDesAgences;
import com.theagences.theagences.entities.Agence;
import com.theagences.theagences.services.AdresseDesAgencesCrud;
import com.theagences.theagences.services.AgenceCrud;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ajoutAgenceController implements Initializable {
    @FXML
    private TextField region_adresse;

    @FXML
    private TextField email_agence;

    @FXML
    private TextField site_agence;

    @FXML
    private TextField num_agence;

    @FXML
    private TextField avenue_adresse;

    @FXML
    private TextField rue_adresse;

    @FXML
    private TextField postal_adresse;

    @FXML
    private Button ajout_agence ;
    @FXML
    private Button afficher ;

    @FXML
    private ListView<Agence> listAgence;
    @FXML
    private Button rechercherID ;
    @FXML
    private TextField rechercherAgence;
    @FXML
    private Button SupprimerID ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
    @FXML
    private void FxAjoutAgence(ActionEvent event){
        String Adresse_region = region_adresse.getText();
        String Agence_email= email_agence.getText();
        String Agence_site = site_agence.getText();
        String Agence_num = num_agence.getText();
        String Adresse_avenue = avenue_adresse.getText();
        String Adresse_rue = rue_adresse.getText();
        String Adresse_postal = postal_adresse.getText();


        if (((region_adresse.getText().equals("")) || (avenue_adresse.getText().equals("")) || (site_agence.getText().equals("")) || (num_agence.getText().equals("")) || (rue_adresse.getText().equals("") ||  postal_adresse.getText().equals("")))) {


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("verifier les champ vides!");
            alert.showAndWait();

        } else {
            Agence A = new Agence(Agence_email,Agence_site,Agence_num);
            AgenceCrud AA = new AgenceCrud();
            AA.ajouterAgence3(A);



            AdresseDesAgences D = new AdresseDesAgences(A.getId_agence(),Adresse_region,Adresse_avenue,Adresse_rue,Adresse_postal);
            AdresseDesAgencesCrud AD = new AdresseDesAgencesCrud ();
            AD.ajouterAdresse3(D);



        }
    }


    @FXML
    private void afficherlist(ActionEvent event){
        AgenceCrud ac = new AgenceCrud();
        listAgence.getItems().clear();
        listAgence.getItems().addAll(ac.afficherles_agences());

    }

    @FXML
    private void rechercher(ActionEvent event){
        AgenceCrud ac = new AgenceCrud();
        listAgence.getItems().clear();
        listAgence.getItems().addAll(ac.RechercherAgence(Integer.parseInt(rechercherAgence.getText())));

    }

    @FXML
   private void Supprimer(ActionEvent event){

        int selectedId=0;
        AgenceCrud ac = new AgenceCrud();
        int selectedIndex = listAgence.getSelectionModel().getSelectedIndex();
        for (int i=0;i<ac.afficherles_agences().size();i++)
        {
            if (i==selectedIndex)
            {
                selectedId=ac.afficherles_agences().get(i).getId_agence();
            }
        }
       // listAgence.getItems().remove(selectedIndex);
        //AgenceCrud ac = new AgenceCrud();
        listAgence.getItems().clear();
        //ac.SupprimerAgence(Integer.parseInt(rechercherAgence.getText()));
        ac.SupprimerAgence(selectedId);
        listAgence.getItems().addAll(ac.afficherles_agences());

    }
/**
    @FXML
    private void modifannonce(ActionEvent event) {
        int selectedId=0;
        AgenceCrud hs = new AgenceCrud();
        Agence A = new Agence(email_agence.getText(),site_agence.getText(),num_agence.getText());
        //AdresseDesAgences D= new AdresseDesAgences(region_adresse.getText(),avenue_adresse.getText(),rue_adresse.getText(),postal_adresse.getText());
        int selectedIndex = listAgence.getSelectionModel().getSelectedIndex();
        for (int i=0;i<hs.afficherles_agences().size();i++)
        {
            if (i==selectedIndex)
            {
                selectedId=hs.afficherles_agences().get(i).getId_agence();
            }
        }

        try {

            String sql = " UPDATE `agences` SET `id_agence`= ? ,`numTel_agence`=?,`email_agence`=?,`siteWeb_agence`= ? WHERE id_agence= ?\"";
            PreparedStatement pst = cnx.prepareStatement(sql);
            Annonces selectedItem = listannonces.getSelectionModel().getSelectedItem();

            pst.setString(1, A.getTitre_annonce());
            pst.setString(2, A.getAffiche_annonce());
            pst.setString(3, A.getDate_depot());
            pst.setInt(4, selectedId);

            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("annonce modifié!");
            alert.showAndWait();
            titre1.setText("");
            affiche1.setText("");
            h.setText("");


        } catch (SQLException ex) {
            System.out.println("Problem");
            System.out.println(ex.getMessage());
        }
        listannonces.getItems().clear();
        listannonces.getItems().addAll(hs.afficherannonce());

    }
**/

}
