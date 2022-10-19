package controller;

import entite.Agent;
import entite.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.AgentCRUD;
import utils.MyConnexion;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import static services.AgentCRUD.*;
import static services.ClientCRUD.AfficherClientCondition;

public class Adminctrl implements Initializable{
    AgentCRUD a=new AgentCRUD();
    @FXML
   TextField adminnom;
    @FXML
    TextField adminprenom;
    @FXML
    TextField adminemail;
    @FXML
    PasswordField adminmdp;
    @FXML
    TextField adminnumtel;
    @FXML
    DatePicker adminddn;
    @FXML
    private void getDate (ActionEvent event){


    }
    public String formatDate(String Date){
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
    TextArea result;
    @FXML
    private TableView<Agent> tvbox;
    @FXML
    TableColumn<Agent,String> colid;
    @FXML
    TableColumn<Agent,String> colnom;
    @FXML
    TableColumn<Agent,String> colprenom;
    @FXML
    TableColumn<Agent,String> colemail;
    @FXML
    TableColumn<Agent,String> colnumtel;
    @FXML
    TableColumn<Agent, String> colddn;
    @FXML
    Label nomlab;
    @FXML
    Label prenomlab;
    @FXML
    Label numtellab;
    @FXML
    Label emaillab;
    @FXML
    Label eror;
    @FXML
    TextField supprId;
    @FXML
    TextField supprnom;
    @FXML
    TextField supprprenom;
    @FXML
    TextField supprnumtel;
    @FXML
    TextField suppremail;
    @FXML
    Label usure;
    @FXML
    Button ouidel;
    @FXML
    Button nondel;
    @FXML
    ImageView check;
    @FXML
    ImageView cross;
    @FXML
    TextField afficheid;
    @FXML
    TextField affichenom;
    @FXML
    TextField afficheprenom;
    @FXML
    TextField affichenumtel;
    @FXML
    TextField affichemail;
    @FXML
    TextField updatenom;
    @FXML
    TextField updateprenom;
    @FXML
    TextField updatenumtel;
    @FXML
    TextField updatemail ;
    @FXML
    Button buttonmodifagent;
    @FXML
    Label confirmationmodif;
    @FXML
    TextField SearchBar;
    Date date;
    Stage stage;
    @FXML
    Button buttontest;
    @FXML
    CheckBox checkboxclient;
    @FXML
    CheckBox checkboxagent;
    @FXML
    ImageView banned;
    static Agent agent;
    static Client client;
   ObservableList<Agent> agentlist= (FXCollections.observableArrayList(AfficherAgent())) ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showagents();
            AgentCRUD a=new AgentCRUD();
            FilteredList<Agent> filteredData = new FilteredList<>((a.AfficherAgent()), b -> true);
            SearchBar.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(agent1 -> {
                    if (newValue.isEmpty() || newValue == null) {
                        return true;
                    }
                    String searchKeyword = newValue.toLowerCase();
                    if (String.valueOf(agent1.getId()).toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (agent1.getNom().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (agent1.getPrenom().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    }   else if (agent1.getEmail().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (agent1.getNumTel().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else if (agent1.getDateNaissance().toLowerCase().indexOf(searchKeyword) > -1) {
                        return true;
                    } else
                        return false;
                });
            });
            SortedList<Agent> sortedList = new SortedList<>(filteredData);
            sortedList.comparatorProperty().bind(tvbox.comparatorProperty());
            tvbox.setItems(sortedList);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
    public void showagents()
    {
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colprenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colnumtel.setCellValueFactory(new PropertyValueFactory<>("NumTel"));
        colddn.setCellValueFactory(new PropertyValueFactory<>("dateNaissance"));
        tvbox.setItems(a.AfficherAgent());
    }

    public void addemployee() throws SQLException {
        Agent a=new Agent();
        a.setNom(adminnom.getText());
        a.setPrenom(adminprenom.getText());
        a.setEmail(adminemail.getText());
        a.setMdp(adminmdp.getText());
        a.setNumTel(adminnumtel.getText());
        a.setDateNaissance(String.valueOf(adminddn.getValue()));
        result.setText(ajouterAgent(a));
    }
    public void clearfields(){
        adminnom.setText("");
        adminprenom.setText("");
        adminemail.setText("");
        adminmdp.setText("");
        adminddn.setChronology(null);
        adminnumtel.setText("");
    }
    public void display(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/showagent.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    public void onquitad(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/authetification.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    public void update(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/updateagent.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    public void delete(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/suppragent.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    public void rusure(){
        if (supprId.getText().isEmpty()){
            eror.setVisible(true);
            eror.setText("VEUILLEZ REMPLIR LE CHAMP ID AVANT DE CLIQUER SUR 'SUPPRIMER'");
        }
        else {
            agent=AfficherAgentCondition(Integer.parseInt(supprId.getText()));
            if (agent==null) {
                eror.setVisible(true);
                eror.setText("Agent n'existe pas");
            }
            else {
            eror.setVisible(false);
            nomlab.setVisible(true);
            prenomlab.setVisible(true);
            numtellab.setVisible(true);
            emaillab.setVisible(true);
            supprnom.setVisible(true);
            supprprenom.setVisible(true);
            supprnumtel.setVisible(true);
            suppremail.setVisible(true);
            usure.setVisible(true);
            ouidel.setVisible(true);
            nondel.setVisible(true);
            check.setVisible(true);
            cross.setVisible(true);
            supprnom.setText(agent.getNom());
            supprprenom.setText(agent.getPrenom());
            supprnumtel.setText(agent.getNumTel());
            suppremail.setText(agent.getEmail());
            }

        }


    }
    public void affichemaj(){
        if (afficheid.getText().isEmpty()){
            eror.setVisible(true);
            eror.setText("VEUILLEZ REMPLIR LE CHAMP ID AVANT DE CLIQUER SUR 'SUPPRIMER'");
        }
        else {
            agent=AfficherAgentCondition(Integer.parseInt(afficheid.getText()));
            if (agent==null) {
                eror.setVisible(true);
                eror.setText("Agent n'existe pas");
            }
            else {
                eror.setVisible(false);
                nomlab.setVisible(true);
                prenomlab.setVisible(true);
                numtellab.setVisible(true);
                emaillab.setVisible(true);
                updatenom.setVisible(true);
                updateprenom.setVisible(true);
                updatenumtel.setVisible(true);
                updatemail.setVisible(true);
                updatenom.setText(agent.getNom());
                updateprenom.setText(agent.getPrenom());
                updatenumtel.setText(agent.getNumTel());
                updatemail.setText(agent.getEmail());
                buttonmodifagent.setVisible(true);
            }

        }


    }
    public void onmodif(){
        Agent a=new Agent();
        int id= Integer.parseInt(afficheid.getText());
        a.setNom(updatenom.getText());
        a.setPrenom(updateprenom.getText());
        a.setEmail(updatemail.getText());
        a.setNumTel(updatenumtel.getText());
        confirmationmodif.setText(ModifAgent(a,id));
    }
    public void ouisuppr(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/admin_interface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
        result.setText(SupprAgent(agent));
    }
    public void nonsuppr(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/admin_interface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    public void affiche(){
        agent=AfficherAgentCondition(Integer.parseInt(afficheid.getText()));
        if (agent==null) {
            eror.setVisible(true);
            eror.setText("Agent n'existe pas");
        }
        else {
            eror.setVisible(false);
            nomlab.setVisible(true);
            prenomlab.setVisible(true);
            numtellab.setVisible(true);
            emaillab.setVisible(true);
            affichenom.setVisible(true);
            afficheprenom.setVisible(true);
            affichenumtel.setVisible(true);
            affichemail.setVisible(true);
            affichenom.setText(agent.getNom());
            afficheprenom.setText(agent.getPrenom());
            affichenumtel.setText(agent.getNumTel());
            affichemail.setText(agent.getEmail());
        }


    }
    public void gobackaffichage(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/admin_interface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    public void retourdelete(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/admin_interface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    public void BanHammer(ActionEvent event)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/yourebanned.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
    public void check1(ActionEvent event) {
        if (checkboxagent.isSelected()) {
            checkboxagent.setSelected(false);
            if (supprId.getText().isEmpty()) {
                eror.setVisible(true);
                eror.setText("VEUILLEZ REMPLIR LE CHAMP ");
            } else {
                client = AfficherClientCondition(Integer.parseInt(supprId.getText()));
                if (client == null) {
                    eror.setVisible(true);
                    eror.setText("Client n'existe pas");
                } else {
                    eror.setVisible(false);
                    nomlab.setVisible(true);
                    prenomlab.setVisible(true);
                    numtellab.setVisible(true);
                    emaillab.setVisible(true);
                    supprnom.setVisible(true);
                    supprprenom.setVisible(true);
                    supprnumtel.setVisible(true);
                    suppremail.setVisible(true);
                    usure.setVisible(true);
                    ouidel.setVisible(true);
                    nondel.setVisible(true);
                    check.setVisible(true);
                    cross.setVisible(true);
                    supprnom.setText(client.getNom());
                    supprprenom.setText(client.getPrenom());
                    supprnumtel.setText(client.getNum_tel());
                    suppremail.setText(client.getEmail());
                }

            }

        }
        else {
            if (supprId.getText().isEmpty()) {
                eror.setVisible(true);
                eror.setText("VEUILLEZ REMPLIR LE CHAMP ");
            } else {
                client = AfficherClientCondition(Integer.parseInt(supprId.getText()));
                if (client == null) {
                    eror.setVisible(true);
                    eror.setText("Client n'existe pas");
                } else {
                    eror.setVisible(false);
                    nomlab.setVisible(true);
                    prenomlab.setVisible(true);
                    numtellab.setVisible(true);
                    emaillab.setVisible(true);
                    supprnom.setVisible(true);
                    supprprenom.setVisible(true);
                    supprnumtel.setVisible(true);
                    suppremail.setVisible(true);
                    usure.setVisible(true);
                    ouidel.setVisible(true);
                    nondel.setVisible(true);
                    check.setVisible(true);
                    cross.setVisible(true);
                    supprnom.setText(client.getNom());
                    supprprenom.setText(client.getPrenom());
                    supprnumtel.setText(client.getNum_tel());
                    suppremail.setText(client.getEmail());
                }

            }
        }
    }
    public void check2(ActionEvent event){
        if (checkboxclient.isSelected()) {
            checkboxclient.setSelected(false);
            if (supprId.getText().isEmpty()) {
                eror.setVisible(true);
                eror.setText("VEUILLEZ REMPLIR LE CHAMP ");
            } else {
                agent = AfficherAgentCondition(Integer.parseInt(supprId.getText()));
                if (client == null) {
                    eror.setVisible(true);
                    eror.setText("Agent n'existe pas");
                } else {
                    eror.setVisible(false);
                    nomlab.setVisible(true);
                    prenomlab.setVisible(true);
                    numtellab.setVisible(true);
                    emaillab.setVisible(true);
                    supprnom.setVisible(true);
                    supprprenom.setVisible(true);
                    supprnumtel.setVisible(true);
                    suppremail.setVisible(true);
                    usure.setVisible(true);
                    ouidel.setVisible(true);
                    nondel.setVisible(true);
                    check.setVisible(true);
                    cross.setVisible(true);
                    supprnom.setText(agent.getNom());
                    supprprenom.setText(agent.getPrenom());
                    supprnumtel.setText(agent.getNumTel());
                    suppremail.setText(agent.getEmail());
                }

            }

        }
        else {
            if (supprId.getText().isEmpty()) {
                eror.setVisible(true);
                eror.setText("VEUILLEZ REMPLIR LE CHAMP ");
            } else {
                agent = AfficherAgentCondition(Integer.parseInt(supprId.getText()));
                if (agent == null) {
                    eror.setVisible(true);
                    eror.setText("Agent n'existe pas");
                } else {
                    eror.setVisible(false);
                    nomlab.setVisible(true);
                    prenomlab.setVisible(true);
                    numtellab.setVisible(true);
                    emaillab.setVisible(true);
                    supprnom.setVisible(true);
                    supprprenom.setVisible(true);
                    supprnumtel.setVisible(true);
                    suppremail.setVisible(true);
                    usure.setVisible(true);
                    ouidel.setVisible(true);
                    nondel.setVisible(true);
                    check.setVisible(true);
                    cross.setVisible(true);
                    supprnom.setText(agent.getNom());
                    supprprenom.setText(agent.getPrenom());
                    supprnumtel.setText(agent.getNumTel());
                    suppremail.setText(agent.getEmail());
                }
            }

        }
    }
    public void ouiban(){
        banned.setVisible(true);
        try {
            String req2= "UPDATE `users` SET `status`='banned' WHERE Email='"+suppremail.getText()+"'";
            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(req2);
            pst.executeUpdate();
        } catch (SQLException ex) {
        }
    }
    public void nonban(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/workbotspidev/admin_interface.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();

    }
}

