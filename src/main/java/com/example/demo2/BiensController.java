package com.example.demo2;

import com.example.demo2.entities.Biens;
import com.example.demo2.services.Bienscrud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.example.demo2.utils.Myconnection.getMyCnx;

public class BiensController implements Initializable {
    @FXML
    ChoiceBox<String> type_bien1;
    @FXML
    Label type_bien;
    @FXML
    Label prix_dt;
    @FXML
    Label description;
    @FXML
    Label images;
    @FXML
    Label num_tel;
    @FXML
    Label adresse_mail;
    @FXML
    Label hauteur_metre;
    @FXML
    Label surface_total_metre;
    @FXML
    Label nb_chambre;
    @FXML
    Label num_etage;
    @FXML
    Label nb_etoile;
    @FXML
    Label nb_piscine;
    @FXML
    TextArea description1;
    @FXML
    TextField prix_dt1;
    @FXML
    TextField images1;
    @FXML
    TextField num_tel1;
    @FXML
    TextField adresse_mail1;
    @FXML
    TextField hauteur_metre1;
    @FXML
    TextField surface_total_metre1;
    @FXML
    TextField nb_chambre1;
    @FXML
    TextField num_etage1;
    @FXML
    TextField nb_etoile1;
    @FXML
    TextField nb_piscine1;
    @FXML
    TableView<Biens> listBiens;
    @FXML
    TableColumn<Biens, Integer> id_bien_id;
    @FXML
    TableColumn<Biens, String> type_bien_id;
    @FXML
    TableColumn<Biens, Float> prix_dt_id;
    @FXML
    TableColumn<Biens, Float> surface_total_metre_id;
    @FXML
    TableColumn<Biens, String> images_id;
    @FXML
    TableColumn<Biens, String> description_id;
    @FXML
    TableColumn<Biens, String> num_tel_id;
    @FXML
    TableColumn<Biens, String> adresse_mail_id;
    @FXML
    TableColumn<Biens, Integer> nb_chambre_id;
    @FXML
    TableColumn<Biens, Integer> num_etage_id;
    @FXML
    TableColumn<Biens, Integer> nb_etoile_id;
    @FXML
    TableColumn<Biens, Integer> nb_piscine_id;
    @FXML
    TableColumn<Biens, Float> hauteur_metre_id;
    @FXML
    TextField chercher;
    @FXML
    Button supprimerbien;
    @FXML
    Button modifierbien;
    @FXML
    Button ajouterbien;
    @FXML
    Button afficherbien;
    @FXML
    Button rechercherbien;
    @FXML
    Button recb;
    @FXML
    private TextField yu;


    public String[] type = {"maison", "appartement", "hotel", "bureau", "terrain_urbain", "terrain_agricole", "depot", "usine", "salle_de_sport", "salle_de_jeu", "boutique", "autre"};
    Bienscrud ccd = new Bienscrud();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        type_bien1.getItems().addAll(type);
        type_bien1.setOnAction(this::getlabels);

            // affichebien();

        try {
            affichebien();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }
    Connection cnx2;
    public BiensController() {
        cnx2 = getMyCnx().getConnection();
    }
    ObservableList<Biens> oblist = FXCollections.observableArrayList();

    @FXML
    private void index(javafx.scene.input.MouseEvent event) {
        Biens selectedItem = listBiens.getSelectionModel().getSelectedItem();

        yu.setText(selectedItem.getType_bien());
        prix_dt1.setText(String.valueOf(selectedItem.getPrix_dt()));
        surface_total_metre1.setText(String.valueOf(selectedItem.getSurface_total_metre()));
        description1.setText(selectedItem.getDescription());
        images1.setText(selectedItem.getImages());
        num_tel1.setText(selectedItem.getNum_tel());
        adresse_mail1.setText(selectedItem.getAdresse_mail());
        nb_chambre1.setText(String.valueOf(selectedItem.getNb_chambre()));
        num_etage.setText(String.valueOf(selectedItem.getNum_etage()));
        nb_etoile1.setText(Integer.toString(selectedItem.getNb_etoile()));
        nb_piscine1.setText(Integer.toString(selectedItem.getNb_piscine()));
        hauteur_metre1.setText(String.valueOf(selectedItem.getHauteur_metre()));
    }


    @FXML
    private void affichebien () {
        id_bien_id.setCellValueFactory(new PropertyValueFactory<Biens,Integer>("id_bien"));
        type_bien_id.setCellValueFactory(new PropertyValueFactory<Biens,String>("type_bien"));
        prix_dt_id.setCellValueFactory(new PropertyValueFactory<Biens,Float>("prix_dt"));
        surface_total_metre_id.setCellValueFactory(new PropertyValueFactory<Biens,Float>("surface_total_metre"));
        description_id.setCellValueFactory(new PropertyValueFactory<Biens,String>("description"));
        images_id.setCellValueFactory(new PropertyValueFactory<Biens,String>("images"));
        num_tel_id.setCellValueFactory(new PropertyValueFactory<Biens,String>("num_tel"));
        adresse_mail_id.setCellValueFactory(new PropertyValueFactory<Biens,String>("adresse_mail"));
        nb_chambre_id.setCellValueFactory(new PropertyValueFactory<Biens,Integer>("nb_chambre"));
        num_etage_id.setCellValueFactory(new PropertyValueFactory<Biens,Integer>("num_etage"));
        nb_etoile_id.setCellValueFactory(new PropertyValueFactory<Biens,Integer>("nb_etoile"));
        nb_piscine_id.setCellValueFactory(new PropertyValueFactory<Biens,Integer>("nb_piscine"));
        hauteur_metre_id.setCellValueFactory(new PropertyValueFactory<Biens,Float>("hauteur_metre"));
        Bienscrud ps = new Bienscrud();
        ObservableList<Biens> biens = FXCollections.observableList(ps.listerBiens());
        listBiens.setItems(biens);
        listBiens.getItems().clear();
        listBiens.getItems().addAll(ps.listerBiens());


    }
    @FXML
    private void recherchebien(ActionEvent event) {
         /* String id_bien = id_bien_id.getText();
        Bienscrud ccd = new Bienscrud();
        Biens c = new Biens();
        Biens c2 = new Biens();
        c.setId_bien(Integer.parseInt(id_bien));
        ccd.RechercherB(c);
        id_bien_id.setText(String.valueOf(c2.getId_bien()));
        type_bien_id.setText(c2.getType_bien());
        prix_dt_id.setCellValueFactory(new PropertyValueFactory<Biens,Float>("prix_dt"));
        surface_total_metre_id.setCellValueFactory(new PropertyValueFactory<Biens,Float>("surface_total_metre"));
        description_id.setCellValueFactory(new PropertyValueFactory<Biens,String>("description"));;
        images_id.setCellValueFactory(new PropertyValueFactory<Biens,String>("images"));
        num_tel_id.setCellValueFactory(new PropertyValueFactory<Biens,String>("num_tel"));
        adresse_mail_id.setCellValueFactory(new PropertyValueFactory<Biens,String>("adresse_mail"));
        nb_chambre_id.setCellValueFactory(new PropertyValueFactory<Biens,Integer>("nb_chambre"));
        num_etage_id.setCellValueFactory(new PropertyValueFactory<Biens,Integer>("num_etage"));
        nb_etoile_id.setCellValueFactory(new PropertyValueFactory<Biens,Integer>("nb_etoile"));
        nb_piscine_id.setCellValueFactory(new PropertyValueFactory<Biens,Integer>("nb_piscine"));
        hauteur_metre_id.setCellValueFactory(new PropertyValueFactory<Biens,Float>("hauteur_metre"));*/
    }
    @FXML
    public void ajoutbien(ActionEvent event) {
        String ch = type_bien1.getValue();



        if (ch == "maison" || ch == "appartement") {
            String type_bien = type_bien1.getValue();
            Float prix_dt = Float.valueOf(prix_dt1.getText());
            Float surface_total_metre = Float.valueOf(surface_total_metre1.getText());
            String description = description1.getText();
            String images = images1.getText();
            String num_tel = num_tel1.getText();
            String adresse_mail = adresse_mail1.getText();
            int nb_chambre = Integer.parseInt(nb_chambre1.getText());
            int num_etage = Integer.parseInt(num_etage1.getText());
            Biens B = new Biens(type_bien, prix_dt, surface_total_metre,
                    description, images, num_tel, adresse_mail, nb_chambre, num_etage);
            Bienscrud bc = new Bienscrud();
            bc.ajouterMA(B);
        }
        if (ch == "bureau" || ch == "boutique" || ch == "salle_de_jeu" || ch == "salle_de_sport" || ch == "autre" || ch == "terrain_urbain" || ch == "terrain_agricole") {
            String type_bien = type_bien1.getValue();
            Float prix_dt = Float.valueOf(prix_dt1.getText());
            Float surface_total_metre = Float.valueOf(surface_total_metre1.getText());
            String description = description1.getText();
            String images = images1.getText();
            String num_tel = num_tel1.getText();
            String adresse_mail = adresse_mail1.getText();
            Biens B = new Biens(type_bien, prix_dt, surface_total_metre,description, images, num_tel, adresse_mail);
            Bienscrud bc = new Bienscrud();
            bc.ajouterBiensimple(B);
        }
        if (ch == "hotel") {
            String type_bien = type_bien1.getValue();
            Float prix_dt = Float.valueOf(prix_dt1.getText());
            Float surface_total_metre = Float.valueOf(surface_total_metre1.getText());
            String description = description1.getText();
            String images = images1.getText();
            String num_tel = num_tel1.getText();
            String adresse_mail = adresse_mail1.getText();
            int nb_chambre = Integer.parseInt(nb_chambre1.getText());
            int nb_etoile = Integer.parseInt(nb_etoile1.getText());
            int nb_piscine = Integer.parseInt(nb_piscine1.getText());
            Biens B = new Biens(type_bien, prix_dt, surface_total_metre,
                    description, images, num_tel, adresse_mail, nb_chambre, nb_etoile, nb_piscine);
            Bienscrud bc = new Bienscrud();
            bc.ajouterhotel(B);
        }

        if (ch == "depot" || ch == "usine") {
            String type_bien = type_bien1.getValue();
            Float prix_dt = Float.valueOf(prix_dt1.getText());
            Float surface_total_metre = Float.valueOf(surface_total_metre1.getText());
            String description = description1.getText();
            String images = images1.getText();
            String num_tel = num_tel1.getText();
            String adresse_mail = adresse_mail1.getText();
            Float hauteur_metre = Float.valueOf(hauteur_metre1.getText());
            Biens B = new Biens(type_bien, prix_dt, surface_total_metre,description, images, num_tel, adresse_mail, hauteur_metre);
            Bienscrud bc = new Bienscrud();
            bc.ajouterDU(B);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("bien ajoutée!");
        alert.showAndWait();
    }

    @FXML
    public void recvalueb() {
        Biens selectedItem = listBiens.getSelectionModel().getSelectedItem();
        yu.setText(selectedItem.getType_bien());
        prix_dt1.setText(String.valueOf(selectedItem.getPrix_dt()));
        surface_total_metre1.setText(String.valueOf(selectedItem.getSurface_total_metre()));
        description1.setText(selectedItem.getDescription());
        images1.setText(selectedItem.getImages());
        num_tel1.setText(selectedItem.getNum_tel());
        adresse_mail1.setText(selectedItem.getAdresse_mail());
        nb_chambre1.setText(String.valueOf(selectedItem.getNb_chambre()));
        num_etage1.setText(String.valueOf(selectedItem.getNum_etage()));
        nb_etoile1.setText(String.valueOf(selectedItem.getNb_etoile()));
        nb_piscine1.setText(String.valueOf(selectedItem.getNb_piscine()));
        hauteur_metre1.setText(String.valueOf(selectedItem.getHauteur_metre()));




    }


    @FXML
    public void modifbien() {
        Biens selectedItem = null;

        int selectedId=0;
        Bienscrud ps = new Bienscrud();
        Biens B = new Biens(yu.getText(),Float.valueOf( prix_dt1.getText()), Float.valueOf(surface_total_metre1.getText()),description1.getText(),images1.getText(),num_tel1.getText(),adresse_mail1.getText(),Integer.valueOf(nb_chambre1.getText()),Integer.valueOf(num_etage1.getText()),Integer.valueOf(nb_etoile1.getText()),Integer.valueOf(nb_piscine1.getText()),Float.valueOf(hauteur_metre1.getText()));
        int selectedIndex = listBiens.getSelectionModel().getSelectedIndex();
        for (int i = 0; i < ps.listerBiens().size(); i++) {
            if (i == selectedIndex) {
                selectedId = ps.listerBiens().get(i).getId_bien();
            }
        }
            try {
                String req4= "UPDATE biens SET type_bien=?, prix_dt=?,surface_total_metre=?,description=?,images=?,num_tel=?, adresse_mail=?,nb_chambre=?,num_etage=?,nb_etoile=?,nb_piscine=?,hauteur_metre=? WHERE id_bien = ?";
                PreparedStatement pst = cnx2.prepareStatement(req4);
                selectedItem = listBiens.getSelectionModel().getSelectedItem();

                pst.setString(1,B.getType_bien());
                pst.setFloat(2,B.getPrix_dt());
                pst.setFloat(3,B.getSurface_total_metre());
                pst.setString(4,B.getDescription());
                pst.setString(5,B.getImages());
                pst.setString(6,B.getNum_tel());
                pst.setString(7,B.getAdresse_mail());
                pst.setInt(8,B.getNb_chambre());
                pst.setInt(9,B.getNum_etage());
                pst.setInt(10,B.getNb_etoile());
                pst.setInt(11,B.getNb_piscine());
                pst.setFloat(12,B.getHauteur_metre());
                pst.setInt(13, selectedId);

                int i =  pst.executeUpdate();

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("bien modifié!");
                    alert.showAndWait();
                    yu.setText("");
                    prix_dt1.setText("");
                    surface_total_metre1.setText("");
                    description1.setText("");
                    images1.setText("");
                    num_tel1.setText("");
                    adresse_mail1.setText("");
                    nb_chambre1.setText("");
                    num_etage1.setText("");
                    nb_etoile1.setText("");
                    nb_piscine1.setText("");
                    hauteur_metre1.setText("");


                }
        catch (SQLException ex) {
                    System.err.println(ex.getMessage());
            }
                    listBiens.getItems().clear();
                    listBiens.getItems().addAll(ps.listerBiens());


    }
    @FXML
    public void supprimebien(ActionEvent event) {
        Bienscrud hs = new Bienscrud();
        hs.supprimerbien(listBiens.getSelectionModel().getSelectedItem());
        int selecteditem = listBiens.getSelectionModel().getSelectedIndex();
        listBiens.getItems().remove(selecteditem);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("bien est supprimée!");
        alert.showAndWait();
        prix_dt1.setText("");
        description1.setText("");
        images1.setText("");
        nb_chambre1.setText("");
        num_etage1.setText("");
        nb_etoile1.setText("");
        nb_piscine1.setText("");
        hauteur_metre1.setText("");
        surface_total_metre1.setText("");
        num_tel1.setText("");
        adresse_mail1.setText("");
    }
    //visibilité des attributs
    public void getlabels(ActionEvent event) {
        String ch = type_bien1.getValue();
        if (ch == "bureau" || ch == "boutique" || ch == "salle_de_jeu" || ch == "salle_de_sport" || ch == "autre" || ch == "terrain_urbain" || ch == "terrain_agricole") {
            nb_chambre.setVisible(false);
            nb_chambre1.setVisible(false);
            num_etage.setVisible(false);
            num_etage1.setVisible(false);
            nb_piscine.setVisible(false);
            nb_piscine1.setVisible(false);
            hauteur_metre.setVisible(false);
            hauteur_metre1.setVisible(false);
            nb_etoile.setVisible(false);
            nb_etoile1.setVisible(false);
        }
        if (ch == "maison") {
            nb_chambre.setVisible(true);
            nb_chambre1.setVisible(true);
            num_etage.setVisible(true);
            num_etage1.setVisible(true);
            nb_piscine.setVisible(false);
            nb_piscine1.setVisible(false);
            hauteur_metre.setVisible(false);
            hauteur_metre1.setVisible(false);
            nb_etoile.setVisible(false);
            nb_etoile1.setVisible(false);
        }
        if (ch == "appartement") {
            nb_chambre.setVisible(true);
            nb_chambre1.setVisible(true);
            num_etage.setVisible(true);
            num_etage1.setVisible(true);
            nb_piscine.setVisible(false);
            nb_piscine1.setVisible(false);
            hauteur_metre.setVisible(false);
            hauteur_metre1.setVisible(false);
            nb_etoile.setVisible(false);
            nb_etoile1.setVisible(false);
        }
        if (ch == "hotel") {
            nb_chambre.setVisible(true);
            nb_chambre1.setVisible(true);
            num_etage.setVisible(false);
            num_etage1.setVisible(false);
            nb_etoile.setVisible(true);
            nb_etoile1.setVisible(true);
            nb_piscine.setVisible(true);
            nb_piscine1.setVisible(true);
            hauteur_metre.setVisible(false);
            hauteur_metre1.setVisible(false);
        }
        if (ch == "depot") {
            nb_chambre.setVisible(false);
            nb_chambre1.setVisible(false);
            num_etage.setVisible(false);
            num_etage1.setVisible(false);
            hauteur_metre.setVisible(true);
            hauteur_metre1.setVisible(true);
            nb_etoile.setVisible(false);
            nb_etoile1.setVisible(false);
            nb_piscine.setVisible(false);
            nb_piscine1.setVisible(false);
        }
        if (ch == "usine") {
            nb_chambre.setVisible(false);
            nb_chambre1.setVisible(false);
            num_etage.setVisible(false);
            num_etage1.setVisible(false);
            hauteur_metre.setVisible(true);
            hauteur_metre1.setVisible(true);
            nb_etoile.setVisible(false);
            nb_etoile1.setVisible(false);
            nb_piscine.setVisible(false);
            nb_piscine1.setVisible(false);
        }
        if (ch == "restaurant") {
            nb_chambre.setVisible(false);
            nb_chambre1.setVisible(false);
            num_etage.setVisible(false);
            num_etage1.setVisible(false);
            hauteur_metre.setVisible(false);
            hauteur_metre1.setVisible(false);
            nb_etoile.setVisible(false);
            nb_etoile1.setVisible(false);
            nb_piscine.setVisible(false);
            nb_piscine1.setVisible(false);
        }
    }

}

