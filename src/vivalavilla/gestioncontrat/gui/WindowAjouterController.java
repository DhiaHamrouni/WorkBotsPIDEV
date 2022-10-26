package vivalavilla.gestioncontrat.gui;

import com.cathive.fonts.fontawesome.FontAwesomeIcon;
import com.cathive.fonts.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import vivalavilla.gestioncontrat.entities.Contrat;
import vivalavilla.gestioncontrat.services.ContratCRUD;


//import java.awt.*;
//import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WindowAjouterController implements Initializable {
    @FXML
    DatePicker FxAjouterDate;

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
    private TextField FxAjouterNomBien;


    @FXML
    private TextField FxAjouterNomVendeur;
    @FXML
    private Label labelmodifiable;

    @FXML
    private TextField FxAjouterCinVendeur;

    @FXML
    private TextField FxAjouterPrix;
    @FXML
    private TextField FxAjouterNomClient;
    @FXML
    private TextField FxAjouterCinClient;
    @FXML
    private TextField FxAjouterAgent;
    @FXML
    private Button FxBtnAjouter;
    // TREEVIEW COMPONENETS/
    @FXML
    private TextField ContratSearchArea;


    @FXML
    Button Supprbtn;
    @FXML
    Button FxBtnClear;
    @FXML
    Button FxBtnUpdate;
    @FXML
    Button modifierContrat;
    @FXML
    private TableView<Contrat> trvContrat;
    @FXML
    TableColumn<Contrat, String> trvAjouterContratPrixBien;
    @FXML
    TableColumn<Contrat, String> trvAjouterContratNomBien;
    @FXML
    TableColumn<Contrat, String> trvAjouterContratId;
    @FXML
    TableColumn<Contrat, String> trvAjouterContratNomClient;
    @FXML
    TableColumn<Contrat, String> trvAjouterContratCinClient;
    @FXML
    TableColumn<Contrat, String> trvAjouterContratNomVendeur;
    @FXML
    TableColumn<Contrat, String> trvAjouterContratBtns;

    @FXML
    TableColumn<Contrat, String> trvAjouterContratCinVendeur;
    @FXML
    TableColumn<Contrat, String> trvAjouterContratDate;
    @FXML
    TableColumn<Contrat, String> trvAjouterContratAgent;




    //////////////////////
    ContratCRUD ccd = new ContratCRUD();
    Connection cnx;
    ObservableList<Contrat> oblist = FXCollections.observableArrayList();


    @FXML
    private void FxAjouterContrat(ActionEvent event) {
        String NomBien = FxAjouterNomBien.getText();
        String PrixBien = FxAjouterPrix.getText();
        String CinVendeur = FxAjouterCinVendeur.getText();
        //String Dateajout = FxAjouterDate.getText();
        String Dateajout = String.valueOf(FxAjouterDate.getValue());
        String NomClient = FxAjouterNomClient.getText();
        String CinClient = FxAjouterCinClient.getText();
        String Agent = FxAjouterAgent.getText();
        String NomVendeur = FxAjouterNomVendeur.getText();
        System.out.println("kjdfklsj"+NomBien);
        System.out.println("ljljl"+PrixBien);
        while ((NomBien=="") || (PrixBien)==null|| (CinVendeur==null) || (Dateajout==null)|| (NomClient==null) || (CinClient==null) || (Agent==null
        || (NomVendeur==null) ))
        {

             NomBien = FxAjouterNomBien.getText();
             PrixBien = FxAjouterPrix.getText();
             CinVendeur = FxAjouterCinVendeur.getText();
            //String Dateajout = FxAjouterDate.getText();
             Dateajout = String.valueOf(FxAjouterDate.getValue());
             NomClient = FxAjouterNomClient.getText();
             CinClient = FxAjouterCinClient.getText();
             Agent = FxAjouterAgent.getText();
             NomVendeur = FxAjouterNomVendeur.getText();

        }
        Contrat c = new Contrat(NomBien, PrixBien, NomClient, NomVendeur, CinVendeur, CinClient, Agent, Dateajout);
        ContratCRUD ccdAjouter = new ContratCRUD();
        ccdAjouter.ajouterContrat2(c);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("contrat ajouté avec succées!");
        alert.showAndWait();
        clearSelection();
        try {
            afficher();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    private void clearSelection(){
         FxAjouterNomBien.setText("");
        FxAjouterPrix.setText("");
        FxAjouterCinVendeur.setText("");
        //FxAjouterDate.setValue();
         FxAjouterNomClient.setText("");
        FxAjouterCinClient.setText("");
        FxAjouterAgent.setText("");
        FxAjouterNomVendeur.setText("");
        FxAjouterDate.setValue(null);
    }

    public void index12() {
        //PrestataireService ps = new PrestataireService();
        Contrat selectedItem = trvContrat.getSelectionModel().getSelectedItem();
        String ref = "";
        ref+= selectedItem.getReference();
        labelmodifiable.setText(ref);
        FxAjouterDate.setPromptText(String.valueOf(selectedItem.getDate()));
        FxAjouterNomBien.setText(selectedItem.getNom_bien_contrat());
        FxAjouterPrix.setText(selectedItem.getPrix_bien_contrat());
        FxAjouterCinVendeur.setText(selectedItem.getCin_vendeur_contrat());
        //FxAjouterDate.setValue();
        FxAjouterNomClient.setText(selectedItem.getNom_client_contrat());
        FxAjouterCinClient.setText(selectedItem.getCin_client_contrat());
        FxAjouterAgent.setText(selectedItem.getAgent_contrat());
        FxAjouterNomVendeur.setText(selectedItem.getNom_vendeur_contrat());
        FxBtnUpdate.setVisible(true);

    }

    @FXML
    private void FxSupprimerContrat(ActionEvent event){
        Contrat selectedItem = trvContrat.getSelectionModel().getSelectedItem();
        String ref = "";
        ref+= selectedItem.getReference();
        ContratCRUD ccd= new ContratCRUD();
        ccd.SupprimerContrat(ref);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("contrat supprime avec succées!");
        alert.showAndWait();
        try {
            afficher();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            afficher();
            FxBtnUpdate.setVisible(false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void afficher() throws SQLException {


        trvAjouterContratId.setCellValueFactory(new PropertyValueFactory<>("reference"));
        trvAjouterContratNomBien.setCellValueFactory(new PropertyValueFactory<>("nom_bien_contrat"));
        trvAjouterContratPrixBien.setCellValueFactory(new PropertyValueFactory<>("prix_bien_contrat"));
        trvAjouterContratCinClient.setCellValueFactory(new PropertyValueFactory<>("cin_client_contrat"));
        trvAjouterContratNomClient.setCellValueFactory(new PropertyValueFactory<>("nom_client_contrat"));
        trvAjouterContratCinVendeur.setCellValueFactory(new PropertyValueFactory<>("cin_vendeur_contrat"));
        trvAjouterContratAgent.setCellValueFactory(new PropertyValueFactory<>("agent_contrat"));
        trvAjouterContratDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        trvAjouterContratNomVendeur.setCellValueFactory(new PropertyValueFactory<>("nom_vendeur_contrat"));
        //trvAjouterContratBtns.setCellValueFactory(new PropertyValueFactory<Contrat,String>("checkBox"));
        trvContrat.setItems(ccd.afficherContrats());
        FilteredList<Contrat> filteredData = new FilteredList<>((ccd.afficherContrats()), b -> true);
        ContratSearchArea.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(contrat1 -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();
                if (contrat1.getNom_bien_contrat().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (contrat1.getPrix_bien_contrat().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (contrat1.getCin_client_contrat().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (contrat1.getReference().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (contrat1.getNom_client_contrat().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (contrat1.getCin_vendeur_contrat().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (contrat1.getNom_vendeur_contrat().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (contrat1.getDate().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (contrat1.getAgent_contrat().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else
                    return false;
            });
        });
        SortedList<Contrat> sortedList = new SortedList<>(filteredData);
        sortedList.comparatorProperty().bind(trvContrat.comparatorProperty());
        trvContrat.setItems(sortedList);

        /////////////////////////////////////////////


    }

    public void FxModifierContrat(ActionEvent event) {
        String NomBien = FxAjouterNomBien.getText();
        String PrixBien = FxAjouterPrix.getText();
        String CinVendeur = FxAjouterCinVendeur.getText();
        //String Dateajout = FxAjouterDate.getText();
        String Dateajout = String.valueOf(FxAjouterDate.getValue());
        String NomClient = FxAjouterNomClient.getText();
        String CinClient = FxAjouterCinClient.getText();
        String Agent = FxAjouterAgent.getText();
        String NomVendeur = FxAjouterNomVendeur.getText();
        String ref = labelmodifiable.getText();
        System.out.println(ref);
        Contrat c = new Contrat(NomBien, PrixBien, NomClient, NomVendeur, CinVendeur, CinClient, Agent, Dateajout, ref);
        ContratCRUD ccd = new ContratCRUD();
        ccd.ModifierContrat(c);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("contrat modifié avec succées!");
        alert.showAndWait();
        clearSelection();
        labelmodifiable.setText("Ajouter un contrat");
        FxBtnUpdate.setVisible(false);
        try {
            afficher();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static Stage stage;

    public void FxExporterPdf(ActionEvent event) {
        //Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signature.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Signer votre Contrat");
        stage.setScene(scene);
        stage.show();



    }
}



