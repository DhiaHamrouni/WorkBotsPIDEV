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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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
    TextField adminmdp1;
    @FXML
    CheckBox checker;
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
    TextField SearchBar;
    Date date;
    Stage stage;
    @FXML
    CheckBox checkboxclient;
    @FXML
    CheckBox checkboxagent;
    @FXML
    ImageView banned;
    static Agent agent;
    static Client client;
    @FXML
    TextField tfidad;
    @FXML
    TextField tfnomad;
    @FXML
    TextField tfprenomad;
    @FXML
    TextField tfemailad;
    @FXML
    TextField tfnumtelad;
    @FXML
    TextField tfddnad;
    @FXML
    Button supration;
    @FXML
    Button modifation;
    @FXML
    Button bannation;
    @FXML
    Button supration1;
    @FXML
    Button supration2;
    @FXML
    Button supration11;
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showagents();
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
        FilteredList<Agent> filteredData = new FilteredList<>((a.AfficherAgent()), b -> true);
        SearchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(agent1 -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();
                if (String.valueOf(agent1.getId()).toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (agent1.getNom().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (agent1.getPrenom().toLowerCase().contains(searchKeyword)) {
                    return true;
                }   else if (agent1.getEmail().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (agent1.getNumTel().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else if (agent1.getDateNaissance().toLowerCase().contains(searchKeyword)) {
                    return true;
                } else
                    return false;
            });
        });
        SortedList<Agent> sortedList = new SortedList<>(filteredData);
        sortedList.comparatorProperty().bind(tvbox.comparatorProperty());
        tvbox.setItems(sortedList);
    }

    public void addemployee() throws SQLException {
        Agent a=new Agent();
        a.setNom(adminnom.getText());
        a.setPrenom(adminprenom.getText());
        a.setEmail(adminemail.getText());
        a.setMdp(adminmdp.getText());
        a.setNumTel(adminnumtel.getText());
        a.setDateNaissance(String.valueOf(adminddn.getValue()));
        if (isValid(adminemail.getText())) {
            result.setText(ajouterAgent(a));
        }
        else {
            result.setText("Email n est pas saisie correctement");
        }
        showagents();
    }
    public void clearfields(){
        adminnom.setText("");
        adminprenom.setText("");
        adminemail.setText("");
        adminmdp.setText("");
        adminddn.setChronology(null);
        adminnumtel.setText("");
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
        Agent selectedItem = tvbox.getSelectionModel().getSelectedItem();
        tfidad.setText(String.valueOf(selectedItem.getId()));
        tfprenomad.setText(selectedItem.getPrenom());
        tfnomad.setText(selectedItem.getNom());
        tfemailad.setText(selectedItem.getEmail());
        tfnumtelad.setText(selectedItem.getNumTel());
        tfddnad.setText(selectedItem.getDateNaissance());
        supration.setVisible(false);
        modifation.setVisible(false);
        bannation.setVisible(false);
        supration11.setVisible(true);
        supration2.setVisible(true);
    }
    public void delete() {
            Agent selectedItem = tvbox.getSelectionModel().getSelectedItem();
            tfidad.setText(String.valueOf(selectedItem.getId()));
            tfprenomad.setText(selectedItem.getPrenom());
            tfnomad.setText(selectedItem.getNom());
            tfemailad.setText(selectedItem.getEmail());
            tfnumtelad.setText(selectedItem.getNumTel());
            tfddnad.setText(selectedItem.getDateNaissance());
            supration.setVisible(false);
            modifation.setVisible(false);
            bannation.setVisible(false);
            supration1.setVisible(true);
            supration2.setVisible(true);

     }


     public void delete1(){
        Agent agent1=new Agent();
        agent1.setId(Integer.parseInt(tfidad.getText()));
        agent1.setPrenom(tfprenomad.getText());
        agent1.setNom(tfnomad.getText());
        agent1.setEmail(tfemailad.getText());
        agent1.setNumTel(tfnumtelad.getText());
        agent1.setDateNaissance(tfddnad.getText());
        a.SupprAgent(agent1);
        showagents();
        tfidad.setText("");
        tfprenomad.setText("");
        tfnomad.setText("");
        tfemailad.setText("");
        tfnumtelad.setText("");
        tfddnad.setText("");
         supration.setVisible(true);
         modifation.setVisible(true);
         bannation.setVisible(true);
         supration1.setVisible(false);
         supration2.setVisible(false);
     }
    public void delete2(){
        tfidad.setText("");
        tfprenomad.setText("");
        tfnomad.setText("");
        tfemailad.setText("");
        tfnumtelad.setText("");
        tfddnad.setText("");
        supration.setVisible(true);
        modifation.setVisible(true);
        bannation.setVisible(true);
        supration1.setVisible(false);
        supration2.setVisible(false);
        supration11.setVisible(false);
    }

    public void modif1(){
        Agent agent2=new Agent();
        agent2.setId(Integer.parseInt(tfidad.getText()));
        agent2.setPrenom(tfprenomad.getText());
        agent2.setNom(tfnomad.getText());
        agent2.setEmail(tfemailad.getText());
        agent2.setNumTel(tfnumtelad.getText());
        agent2.setDateNaissance(tfddnad.getText());
        a.ModifAgent(agent2,agent2.getEmail());
        showagents();
        tfidad.setText("");
        tfprenomad.setText("");
        tfnomad.setText("");
        tfemailad.setText("");
        tfnumtelad.setText("");
        tfddnad.setText("");
        supration.setVisible(true);
        modifation.setVisible(true);
        bannation.setVisible(true);
        supration11.setVisible(false);
        supration2.setVisible(false);
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
    public void refreshpls(){
        showagents();
    }
    public void checkyoself(){
        if (checker.isSelected()){
            adminmdp1.setVisible(true);
            adminmdp1.setText(adminmdp.getText());
        }
        else {
            adminmdp.setText(adminmdp1.getText());
            adminmdp1.setVisible(false);
        }
    }
}

