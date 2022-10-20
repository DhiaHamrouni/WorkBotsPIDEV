package vivalavilla.gestioncontrat.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vivalavilla.gestioncontrat.services.ContratCRUD;

import java.net.URL;
import java.util.ResourceBundle;

public class SupprimerContratController implements Initializable {
    @FXML
    private TextField suppid;
    @FXML
    private Button suppbtn;
    @FXML
    private Button suppbtnoui;
    @FXML
    private Button suppbtnnon;
    @FXML
    private Label labelsupp;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        suppbtnnon.setVisible(false);
        suppbtnoui.setVisible(false);



    }
    @FXML
    private void FxContratSupprimer(ActionEvent event)
    {
        labelsupp.setText("Are you sure?");
        suppbtnoui.setVisible(true);
        suppbtnnon.setVisible(true);

    }

    public void blocksuppression(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) suppbtnnon.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void confirmsuppression(ActionEvent event) {
        String id = suppid.getText();
        ContratCRUD ccd = new ContratCRUD();
        ccd.SupprimerContrat(Integer.parseInt(id));
    }
}

       /* String id =suppid.getText();
        ContratCRUD ccd = new ContratCRUD();
        ccd.SupprimerContrat(Integer.parseInt(id));*/



