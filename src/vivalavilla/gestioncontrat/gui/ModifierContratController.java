package vivalavilla.gestioncontrat.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import vivalavilla.gestioncontrat.entities.Contrat;
import vivalavilla.gestioncontrat.services.ContratCRUD;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class ModifierContratController implements Initializable {
    @FXML
    private TextField searchId;
    @FXML
    private TextField modifNomBien;
    @FXML
    private TextField modifPrixBien;
    @FXML
    private TextField modifNomClient;
    @FXML
    private TextField modifCinClient;
    @FXML
    private TextField modifNomVendeur;
    @FXML
    private TextField modifCinVendeur;
    @FXML
    private TextField modifAgent;
    @FXML
    private DatePicker modifDate;
    @FXML
    private void getDate(ActionEvent event) {


    }

    public String formatDate(String Date) {
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


    @FXML
    private Button modifSearchBtn;
    @FXML
    private Button modifbtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void FxChercherContrat(ActionEvent event) {
        String id = searchId.getText();
        ContratCRUD ccd = new ContratCRUD();
        Contrat c = new Contrat();
        Contrat c2 = new Contrat();
        c.setId_bien_contrat(Integer.parseInt(id));
        c2=ccd.RechercherContrat(c);
        if (c2.getId_bien_contrat()==-1)
        { System.out.println("non trouvee");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Contrat non trouvé!");
        alert.showAndWait();}
        else {
        modifNomBien.setText(c2.getNom_bien_contrat());
        modifPrixBien.setText(c2.getPrix_bien_contrat());
        modifCinClient.setText(c2.getCin_client_contrat());
        modifNomClient.setText(c2.getNom_client_contrat());
        modifCinVendeur.setText(c2.getCin_vendeur_contrat());
        modifNomVendeur.setText(c2.getNom_vendeur_contrat());
        modifAgent.setText(c2.getAgent_contrat());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Contrat trouvé!");
            alert.showAndWait();
    }}

    public void FModifereContrat2(ActionEvent event) {
        Integer id = Integer.parseInt(searchId.getText());
        String NomBien = modifNomBien.getText();
        String PrixBien = modifPrixBien.getText();
        String CinVendeur = modifCinVendeur.getText();
        //String Dateajout = FxAjouterDate.getText();
        String Dateajout = String.valueOf(modifDate.getValue());
        String NomClient = modifNomClient.getText();
        String CinClient = modifCinClient.getText();
        String Agent = modifAgent.getText();
        String NomVendeur = modifNomVendeur.getText();
        Contrat c = new Contrat(id,NomBien, PrixBien, NomClient, NomVendeur, CinVendeur, CinClient, Agent, Dateajout);
        System.out.println(c);
        ContratCRUD ccdAjouter = new ContratCRUD();

        ccdAjouter.ModifierContrat(c);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Contrat modifié!");
        alert.showAndWait();
    }
}
