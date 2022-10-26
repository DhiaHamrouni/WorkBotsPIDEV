package vivalavilla.gestionetatbiens.gui;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import vivalavilla.gestionetatbiens.entities.EtatBiens;
import vivalavilla.gestionetatbiens.services.EtatbiensCRUD;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class InterfaceEtatBiensController implements Initializable {
    @FXML
    private Label labelmodifiable2;
    @FXML
    private Button FxBtnUpdate2;
    @FXML
    private TextField FxEtatBiensIdBien;
    @FXML
    private ChoiceBox<String> FxEtatBiensEtat;
    @FXML
    private TextField FxEtatBiensNombrePannes;
    @FXML
    private TextArea FxEtatBiensDescription;
    @FXML
    private Button FxBtnClear2;
    @FXML
    private Button FxBtnAjouter2;
    @FXML
    private TextField EtatBiensSearchArea;
    @FXML
    private TableView<EtatBiens> trvEtatBiens;
    @FXML
    private TableColumn<EtatBiens,String> trvEtatBiensIdBien;
    @FXML
    private TableColumn<EtatBiens,String> trvEtatBiensDescription;
    @FXML
    private TableColumn<EtatBiens,String> trvEtatBiensEtat;
    @FXML
    private TableColumn<EtatBiens,String> trvEtatBiensNombrePannes;
    @FXML
    private Button FxBtnAjouter3;
    @FXML
    private Button modifierEtatBiens;
    @FXML
    private Button Supprbtn2;
    @FXML
    private Button FxBtnPdf2;
    private String[] etats  = {"tres mal","mediocre", "moyen","bien","excellent"};
    EtatbiensCRUD eed = new EtatbiensCRUD();


    @Override
    public void initialize(URL location, ResourceBundle rb) {

        try {
            afficher2();
            FxEtatBiensEtat.getItems().addAll(etats);

            FxBtnUpdate2.setVisible(false);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    public void clearSelection2(){
        FxEtatBiensIdBien.setText("");
        FxEtatBiensDescription.setText("");
        FxEtatBiensNombrePannes.setText("");

    }
    public void afficher2(){
        trvEtatBiensIdBien.setCellValueFactory(new PropertyValueFactory<>("id_bien"));
        trvEtatBiensEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        trvEtatBiensNombrePannes.setCellValueFactory(new PropertyValueFactory<>("nombre_pannes"));
        trvEtatBiensDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        System.out.println("hi");
        //trvAjouterContratBtns.setCellValueFactory(new PropertyValueFactory<Contrat,String>("checkBox"));
        trvEtatBiens.setItems(eed.afficherEtatbiens());
        System.out.println("hi2");
        FilteredList<EtatBiens> filteredData = new FilteredList<>((eed.afficherEtatbiens()), b -> true);
        EtatBiensSearchArea.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(contrat1 -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();
                if (String.valueOf(contrat1.getId_bien()).toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (String.valueOf(contrat1.getNombre_pannes()).toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (contrat1.getEtat().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (contrat1.getDescription().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else
                    return false;
            });
        });
        SortedList<EtatBiens> sortedList = new SortedList<>(filteredData);
        sortedList.comparatorProperty().bind(trvEtatBiens.comparatorProperty());
        trvEtatBiens.setItems(sortedList);



    }
    public void FxSupprimerEtatBiens(ActionEvent event){
        EtatBiens selectedItem = trvEtatBiens.getSelectionModel().getSelectedItem();
        int idBien = selectedItem.getId_bien();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Suppression");
        alert.setContentText("Voulez vous supprimer votre etat du bien?");
        ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        //ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
        ButtonType cancelButton = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(okButton,  cancelButton);
        alert.showAndWait().ifPresent(type -> {
            if (type == ButtonType.OK) {
                eed.SupprimerEtatbiens(idBien);
                afficher2();
                clearSelection2();
            } else if (type == ButtonType.NO) {
            }
        });


    }
    public void index13(ActionEvent event){
        EtatBiens selectedItem = trvEtatBiens.getSelectionModel().getSelectedItem();
        String idBien = "";
        idBien+= selectedItem.getId_bien();
        labelmodifiable2.setText("Modifier Etat du bien");

        FxEtatBiensIdBien.setText( String.valueOf(selectedItem.getId_bien()));
        FxEtatBiensNombrePannes.setText(String.valueOf(selectedItem.getNombre_pannes()));
        FxEtatBiensDescription.setText(selectedItem.getDescription());

        FxEtatBiensIdBien.setEditable(false);
        FxBtnUpdate2.setVisible(true);

    }

    public void FxModifierEtatBiens(ActionEvent event){

        String Id_Bien = FxEtatBiensIdBien.getText();
        String etat = FxEtatBiensEtat.getValue();
        String n = FxEtatBiensNombrePannes.getText();
        int NombrePannes = Integer.parseInt(n);
        String description = FxEtatBiensDescription.getText();
        EtatBiens e = new EtatBiens(Integer.parseInt(Id_Bien),etat,NombrePannes,description);
        EtatbiensCRUD eed = new EtatbiensCRUD();
        eed.ModifierEtatbiens(e);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Etat du bien modifié avec succées!");
        alert.showAndWait();
        clearSelection2();
        labelmodifiable2.setText("Ajouter un etat du bien");
        FxBtnUpdate2.setVisible(false);
        FxEtatBiensIdBien.setEditable(true);

        try {
            afficher2();
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }

    }
    public void FxExporterPdf2(ActionEvent event){

    }
    public void FxAjouterEtatBiens(ActionEvent event){


        String Id_Bien = FxEtatBiensIdBien.getText();
        String etat = FxEtatBiensEtat.getValue();
        String n = FxEtatBiensNombrePannes.getText();
        int NombrePannes = Integer.parseInt(n);
        String description = FxEtatBiensDescription.getText();
        EtatBiens e = new EtatBiens(Integer.parseInt(Id_Bien),etat,NombrePannes,description);
        EtatbiensCRUD eed = new EtatbiensCRUD();
        eed.ajouterEtatbiens2(e);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("etat du bien ajouté avec succées!");
        alert.showAndWait();
        clearSelection2();
        afficher2();

    }


}
