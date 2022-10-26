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
    public static String ModifClient(Client cl,String email){
        try {
            String req2= "UPDATE `clients` SET CIN=?, Nom=?, Prenom=?, email=?, num_tel=? , adresse=? WHERE email='"+email+"'";
            String req3="UPDATE `users` SET email=? where email='"+email+"'";
            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(req2);
            PreparedStatement pst1 = new MyConnexion().getCnx().prepareStatement(req3);
            pst.setString(1, cl.getCIN());
            pst.setString(2, cl.getNom());
            pst.setString(3, cl.getPrenom());
            pst.setString(4,cl.getEmail());
            pst.setString(5,cl.getNum_tel());
            pst.setString(6,cl.getAdresse());
            pst1.setString(1,cl.getEmail());
            pst.executeUpdate();
            pst1.executeUpdate();
            return ("Votre Compte est modifie avecc succee!");
        } catch (SQLException ex) {
            return (ex.getMessage());
        }
    }
    public static String SupprClient(String email){
        try {
            String req2= "DELETE FROM `clients` WHERE email = ?";
            String req3="DELETE FROM `users` WHERE email = ?";
            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(req2);
            PreparedStatement pst1 = new MyConnexion().getCnx().prepareStatement(req3);
            pst.setString(1, email);
            pst1.setString(1, email);
            pst.executeUpdate();
            pst1.executeUpdate();
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
    public static Client AfficherClientCondition1(String email) {
        List<Client> myList = new ArrayList<>();
        Client cl = null;
        try {

            String req3 = "SELECT `CIN`, `Nom`, `Prenom`, `email`, `num_tel`, `adresse` FROM `clients` WHERE email='"+email+"'";
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
                cl.setAdresse(result.getString(6));
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
