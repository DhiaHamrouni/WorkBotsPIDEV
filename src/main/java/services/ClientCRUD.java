package services;

import entite.Agent;
import entite.Client;
import utils.MyConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientCRUD {
    public static String ajouterClient(Client cl){
        try {
            String req2= "INSERT INTO `clients` (`CIN`, `Nom`, `Prenom`, `email`, `mot_de_passe`, `num_tel`,`sexe`,`date_naissance`,`adresse`) "+
                    "VALUES (?, ?, ?, ?, ?, ?,?,?,?)";
            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(req2);
            pst.setString(1, cl.getCIN());
            pst.setString(2, cl.getNom());
            pst.setString(3,cl.getPrenom());
            pst.setString(4, cl.getEmail());
            pst.setString(5,cl.getMot_de_passe());
            pst.setString(6, cl.getNum_tel());
            pst.setString(7,cl.getSexe());
            pst.setString(8,String.valueOf(cl.getDate_naissance()));
            pst.setString(9,cl.getAdresse());
            pst.executeUpdate();
            String req3= "INSERT INTO `users`(`Email`, `Password`, `Roles`, `status`) VALUES (?, ?, ?, ?)";
            PreparedStatement pst1 = new MyConnexion().getCnx().prepareStatement(req3);
            pst1.setString(1,cl.getEmail());
            pst1.setString(2,cl.getMot_de_passe());
            pst1.setString(3,"client");
            pst1.setString(4,"Unbanned");
            pst.executeUpdate();
            pst1.executeUpdate();
            return ("Votre Client est ajouté avec succée");
        } catch (SQLException ex) {
            return (ex.getMessage());
        }
    }
    public static String ModifClient(Client cl,Integer id){
        try {
            String req2= "UPDATE `clients` SET Nom=?, Prenom=?, email=?, num_tel=? , adresse=? WHERE Id="+id;
            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(req2);
            pst.setString(1, cl.getNom());
            pst.setString(2, cl.getPrenom());
            pst.setString(3,cl.getEmail());
            pst.setString(4,cl.getNum_tel());
            pst.setString(5,cl.getAdresse());
            pst.executeUpdate();
            return ("Votre Client est modifie avecc succee!");
        } catch (SQLException ex) {
            return (ex.getMessage());
        }
    }
    public static String SupprClient(Client cl){
        String chdel=String.valueOf(cl.getCIN());
        try {
            String req2= "DELETE FROM `clients` WHERE CIN = ?";
            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(req2);
            pst.setString(1, chdel);
            pst.executeUpdate();
            return ("Le Client est supprime avec succee!");
        } catch (SQLException ex) {
            return (ex.getMessage());
        }
    }
    public static List<Client> AfficherClient(){
        List<Client> myList = new ArrayList<>();
        Client cl = new Client();
        try {
            String req3 = "SELECT `CIN`, `Nom`, `Prenom`, `email`, `num_tel`, `date_naissance`,`adresse` FROM `clients`";
            Statement st;
            Connection cnx = MyConnexion.getInstance().getCnx();
            st = cnx.createStatement();
            ResultSet result = st.executeQuery(req3);
            while(result.next())
            {
                cl.setCIN(result.getString(1));
                cl.setNom(result.getString(2));
                cl.setPrenom(result.getString(3));
                cl.setEmail(result.getString(4));
                cl.setNum_tel(result.getString(5));
                cl.setDate_naissance(result.getString(6));
                cl.setAdresse(result.getString(7));

                myList.add(cl);
            }
            System.out.println(myList);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }

    public static Client AfficherClientCondition(int Id) {
        List<Client> myList = new ArrayList<>();
        Client cl = null;
        try {

            String req3 = "SELECT `CIN`, `Nom`, `Prenom`, `email`, `num_tel`, `date_naissance`,`adresse` FROM `clients`WHERE id=" + Id;
            Statement st;
            Connection cnx = MyConnexion.getInstance().getCnx();
            st = cnx.createStatement();
            ResultSet result = st.executeQuery(req3);
            if (result.next()) {
                cl = new Client();
                cl.setCIN(result.getString(1));
                cl.setNom(result.getString(2));
                cl.setPrenom(result.getString(3));
                cl.setEmail(result.getString(4));
                cl.setNum_tel(result.getString(5));
                cl.setDate_naissance(result.getString(6));
                cl.setAdresse(result.getString(7));
                return cl;
            } else {
                System.out.println("Agent n existe pas");
            }


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return cl;
    }

}
