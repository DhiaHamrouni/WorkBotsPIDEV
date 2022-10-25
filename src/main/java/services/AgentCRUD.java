package services;
import entite.Agent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MyConnexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AgentCRUD  {
    public static String ajouterAgent(Agent a){
        try {
            String req2= "INSERT INTO `agents` (`Nom`, `Prenom`, `email`, `mot_de_passe`, `num_tel`, `date_naissance`) "+
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(req2);
            pst.setString(1, a.getNom());
            pst.setString(2, a.getPrenom());
            pst.setString(3,a.getEmail());
            pst.setString(4, a.getMdp());
            pst.setString(5,a.getNumTel());
            pst.setString(6, String.valueOf(a.getDateNaissance()));
            pst.executeUpdate();
            String req3= "INSERT INTO `users`(`Email`, `Password`, `Roles`, `status`)"+
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement pst1 = new MyConnexion().getCnx().prepareStatement(req3);
            pst1.setString(1,a.getEmail());
            pst1.setString(2,a.getMdp());
            pst1.setString(3,"agent");
            pst1.setString(4,"Unbanned");
            pst1.executeUpdate();

            return ("Votre agent est ajouté avec succée");
        } catch (SQLException ex) {
            return (ex.getMessage());
        }
    }
    public static String ModifAgent(Agent a,String email){
        try {
            String req2= "UPDATE `agents` SET NOM=?, PRENOM=?, EMAIL=?, NUM_TEL=? WHERE email='"+email+"'";
            String req3= "UPDATE `users` SET 'Email'=? WHERE Email='"+email+"'";
            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(req2);
            PreparedStatement pst1 = new MyConnexion().getCnx().prepareStatement(req3);

            pst.setString(1, a.getNom());
            pst.setString(2, a.getPrenom());
            pst.setString(3,a.getEmail());
            pst.setString(4,a.getNumTel());
            pst1.setString(1,a.getEmail());
            pst.executeUpdate();
            pst1.executeUpdate();
            return ("Votre agent est modifie avecc succee!");
        } catch (SQLException ex) {
           return (ex.getMessage());
        }
    }
    public static String SupprAgent(Agent a){
        String chdel=String.valueOf(a.getEmail());
        try {
            String req2= "DELETE FROM `agents` WHERE email = ?";
            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(req2);
            pst.setString(1, chdel);
            pst.executeUpdate();
            String req3= "DELETE FROM `users` WHERE Email = ?";
            PreparedStatement pst1 = new MyConnexion().getCnx().prepareStatement(req3);
            pst1.setString(1, chdel);
            pst1.executeUpdate();
            return ("L'agent est supprime avec succee!");
        } catch (SQLException ex) {
           return (ex.getMessage());
        }
    }
    public static ObservableList<Agent> AfficherAgent(){
        ObservableList<Agent> agentlist= (FXCollections.observableArrayList()) ;
        try {
            String req3 = "SELECT `id`, `Nom`, `Prenom`, `email`, `num_tel`, `date_naissance` FROM `agents`";
            Statement st;
            Connection cnx = MyConnexion.getInstance().getCnx();
            st = cnx.createStatement();
            ResultSet result = st.executeQuery(req3);
            while(result.next())
            {
                Agent a = new Agent();
                a.setId(Integer.parseInt(result.getString(1)));
                a.setNom(result.getString(2));
                a.setPrenom(result.getString(3));
                a.setEmail(result.getString(4));
                a.setNumTel(result.getString(5));
                a.setDateNaissance(result.getString(6));
                agentlist.add(a);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return agentlist;
    }

    public static Agent AfficherAgentCondition(int Id) {
        List<Agent> myList = new ArrayList<>();
        Agent a = null;
        try {

            String req3 = "SELECT * FROM `agents` WHERE id=" + Id;
            Statement st;
            Connection cnx = MyConnexion.getInstance().getCnx();
            st = cnx.createStatement();
            ResultSet result = st.executeQuery(req3);
            if (result.next()) {
                a = new Agent();
                a.setId(Integer.parseInt(result.getString(1)));
                a.setNom(result.getString(2));
                a.setPrenom(result.getString(3));
                a.setEmail(result.getString(4));
                a.setMdp(result.getString(5));
                a.setNumTel(result.getString(6));
                a.setDateNaissance(result.getString(7));
                return a;
            } else {
                System.out.println("Agent n existe pas");
            }


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return a;
    }

}
