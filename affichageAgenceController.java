package com.example.newagence.controller;

import com.example.newagence.entities.adresse;
import com.example.newagence.entities.agence;
import com.example.newagence.entities.rate;
import com.example.newagence.services.adresseCrud;
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class affichageAgenceController implements Initializable {

    @FXML
    ChoiceBox <Integer> checkBoxID;

    @FXML
    TableColumn<adresse, String> codeRegionAdresse_IDTree2;
    @FXML
    TableColumn<adresse, String> avenue_IDTree2;
    @FXML
    TableColumn<adresse, String> numeroRue_IDTree2;
    @FXML
    TableColumn<adresse, String> codePostal_IDTree2;

    @FXML
    private Button contactID;




    @FXML
    private TextField  infoAgence;


    @FXML
    private TextField  codeRegionAgence_ID3;
    @FXML
    private TextField  numeroTel_ID3;
    @FXML
    private TextField  email_ID3;
    @FXML
    private TextField  siteWeb_ID3;


    @FXML
    private Button infoAgenceButton;
    @FXML
    private Button addRate;

    @FXML
    TableView<adresse> TableView4_ID;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        afficherDirectementAdresse4();
        //checkBoxID.getItems().addAll(this.type);
        checkBoxID.getItems().addAll(1,2,3,4,5);



    }

    //public String[] type = {1,2,3,5};


    @FXML
    private void afficherDirectementAdresse4() {
        codeRegionAdresse_IDTree2.setCellValueFactory(new PropertyValueFactory<adresse, String>("codeRegionAdresse"));
        avenue_IDTree2.setCellValueFactory(new PropertyValueFactory<adresse, String>("avenue"));
        numeroRue_IDTree2.setCellValueFactory(new PropertyValueFactory<adresse, String>("numeroRue"));
        codePostal_IDTree2.setCellValueFactory(new PropertyValueFactory<adresse, String>("codePostal"));
        adresseCrud ps = new adresseCrud();
        ObservableList<adresse> adresses = FXCollections.observableList(ps.afficherAdresse());
        TableView4_ID.setItems(adresses);
    }

    @FXML
    private void infoAgencefonction (){
        String code = infoAgence.getText();
        //System.out.println( code);
        adresseCrud ps = new adresseCrud();
        boolean codeexist = ps.checkIfExists(code);

        //System.out.println( number);



    }


    @FXML
    private void addRateAction(){
        String code = infoAgence.getText();
        Integer number = checkBoxID.getValue();
        rate r = new rate(code,number);
        rateCrud rt = new rateCrud();
        rt.ajouterRate(r);

    }


    @FXML
    private void contactIDaction(ActionEvent event) throws SQLException {
        adresse selectedItem = TableView4_ID.getSelectionModel().getSelectedItem();
        String req ="SELECT * FROM agence WHERE codeRegionAgence='"+selectedItem.getCodeRegionAdresse()+"'";
        Statement st;
        Connection cnx = MyConnection.getInstance().getCnx();
        st = cnx.createStatement();
        ResultSet result = st.executeQuery(req);
        //System.out.println(selectedItem.getCodeRegionAdresse());

        agence a = new agence();
        while(result.next())
        {
            a.setIdAgence(result.getInt(1));
            a.setCodeRegionAgence(result.getString(2));
            a.setNumeroTel(result.getString(3));
            a.setEmail(result.getString(4));
            a.setSiteWeb(result.getString(5));
            a.setNomDuResponsable(result.getString(6));
            a.setNombreDesEmployees(result.getString(7));
            a.setJourDeCreation(result.getString(8));
            System.out.println(a);


        }
        //tfidad.setText(String.valueOf(selectedItem.getId()));
        codeRegionAgence_ID3.setText(a.getCodeRegionAgence());
        numeroTel_ID3.setText(a.getNumeroTel());
        email_ID3.setText(a.getEmail());
        siteWeb_ID3.setText(a.getSiteWeb());
    }
}
