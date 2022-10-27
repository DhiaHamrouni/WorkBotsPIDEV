package com.example.demo2;

import com.example.demo2.entities.Annonces;
import com.example.demo2.entities.Biens;
import com.example.demo2.services.Annoncescrud;
import com.example.demo2.services.Bienscrud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import static com.example.demo2.utils.Myconnection.getMyCnx;

public class AnnoncesController implements Initializable {
    @FXML
    DatePicker MyDatePicker;
    @FXML
    Button afficherannonce;
    @FXML
    TableView<Annonces> listannonces;
    @FXML
    TableColumn<Biens, Integer> A;
    @FXML
    TableColumn<Annonces, String> titre_annonce_id;
    @FXML
    TableColumn<Annonces, String> affiche_annonce_id;
    @FXML
    TableColumn<Annonces, String> date_depot_id;
    @FXML
    Label titre;
    @FXML
    Label affiche;
    @FXML
    Label datedepot;
    @FXML
    TextField titre1;
    @FXML
    TextField affiche1;
    @FXML
    Button ajouterannonce;
    @FXML
    Button supprimerannonce;
    @FXML
    Button modifierannonce;
    @FXML
     ComboBox<Biens> bienachoisir;
    @FXML
    private TextField h;
    @FXML
    Button rechercherId;
    @FXML
    private TextField hela;
    @FXML
    Button rec;


    Connection cnx2;
    public AnnoncesController() {
        cnx2 = getMyCnx().getConnection();
    }
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
    private void rechercher(ActionEvent event) {
        Annoncescrud r = new Annoncescrud();
        listannonces.getItems().clear();
        listannonces.getItems().addAll(r.Rannonce(hela.getText()));

    }

    @FXML
    public void ajoutannonce(ActionEvent event) {
        if ((titre1.getText().equals("")) || (affiche1.getText().equals("")))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("verifier les champ vides!");
            alert.showAndWait();}
        else {
            Annonces A = new Annonces();
            Annoncescrud ac = new Annoncescrud();

           // A.setId_annonce(0);
            A.setId_bien(bienachoisir.getValue().getId_bien());
            A.setTitre_annonce(titre1.getText());
            A.setAffiche_annonce(affiche1.getText());
            String date_depot = String.valueOf(MyDatePicker.getValue());
            A.setDate_depot(date_depot);


            System.out.println(A);
            ac.ajouterannonce2(A);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("annonce ajoutée!");
            alert.showAndWait();





        }
    }

    @FXML
    void supprimeannonce(ActionEvent event) {
        Annoncescrud hs = new Annoncescrud();
        hs.supprimerannonce(listannonces.getSelectionModel().getSelectedItem());
        int selecteditem = listannonces.getSelectionModel().getSelectedIndex();
        listannonces.getItems().remove(selecteditem);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("votre annonce est supprimée avec succée!");
        alert.showAndWait();
        affiche1.setText("");
        titre1.setText("");
        h.setText("");



    }

   @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //table();
        Bienscrud br = new Bienscrud();
       bienachoisir.getItems().addAll(br.listerBiens());

       try {
           afficheannonce();
       } catch (Exception ex) {
           System.out.println(ex.getMessage());
       }
    }

    @FXML
    private void afficheannonce() {
        A.setCellValueFactory(new PropertyValueFactory<Biens,Integer>("id_bien"));
        titre_annonce_id.setCellValueFactory(new PropertyValueFactory<Annonces,String>("titre_annonce"));
        affiche_annonce_id.setCellValueFactory(new PropertyValueFactory<Annonces,String>("affiche_annonce"));
        date_depot_id.setCellValueFactory(new PropertyValueFactory<Annonces,String>("date_depot"));
        Annoncescrud ps = new Annoncescrud();
        ObservableList<Annonces> annonces = FXCollections.observableList(ps.afficherannonce());
        listannonces.setItems(annonces);
        FilteredList<Annonces> filteredData = new FilteredList<>((ps.afficherannonce()), b -> true);
        hela.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(contrat1 -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();
                if (contrat1.getAffiche_annonce().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (contrat1.getTitre_annonce().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                } else if (contrat1.getDate_depot().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;
                }  else
                    return false;
            });
        });
        SortedList<Annonces> sortedList = new SortedList<>(filteredData);
        sortedList.comparatorProperty().bind(listannonces.comparatorProperty());
        listannonces.setItems(sortedList);


    }

    @FXML
    private void index(MouseEvent event) {

        Annonces selectedItem = listannonces.getSelectionModel().getSelectedItem();
        titre1.setText(selectedItem.getTitre_annonce());
        affiche1.setText(selectedItem.getAffiche_annonce());
        h.setText(selectedItem.getDate_depot());

    }
    @FXML
    private void recvalue() {
        Annonces selectedItem = listannonces.getSelectionModel().getSelectedItem();
        titre1.setText(String.valueOf(selectedItem.getTitre_annonce()));
        affiche1.setText(selectedItem.getAffiche_annonce());
        h.setText(selectedItem.getDate_depot());

    }

    @FXML
    private void modifannonce() {
        Annonces selectedItem = null;

        int selectedId = 0;
        Annoncescrud hs = new Annoncescrud();
        Annonces A = new Annonces(titre1.getText(), affiche1.getText(), String.valueOf(MyDatePicker.getValue()));
        int selectedIndex = listannonces.getSelectionModel().getSelectedIndex();
        for (int i = 0; i < hs.afficherannonce().size(); i++) {
            if (i == selectedIndex) {
                selectedId = hs.afficherannonce().get(i).getId_annonce();
            }
        }

        try {

            String sql = " UPDATE annonces SET titre_annonce=?,affiche_annonce=?,date_depot=? WHERE id_annonce = ?";
            PreparedStatement pst = cnx2.prepareStatement(sql);
            selectedItem = listannonces.getSelectionModel().getSelectedItem();

            pst.setString(1, A.getTitre_annonce());
            pst.setString(2, A.getAffiche_annonce());
            pst.setString(3, A.getDate_depot());
            pst.setInt(4, selectedId);

            int i = pst.executeUpdate();

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









}


