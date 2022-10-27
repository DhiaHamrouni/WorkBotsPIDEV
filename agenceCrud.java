package com.example.newagence.services;

import com.example.newagence.entities.agence;
import com.example.newagence.utils.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class agenceCrud {


    /* Ajouter une agence */
    public void ajouterAgence1(agence AG) {
        try {
            String requete1 = "INSERT INTO agence ( codeRegionAgence,numeroTel,email,siteWeb,nomDuResponsable,nombreDesEmployees,jourDeCreation) " + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete1);
            //pst.setInt(1, AG.getId_agence());
            pst.setString(1, AG.getCodeRegionAgence());
            pst.setString(2, AG.getNumeroTel());
            pst.setString(3, AG.getEmail());
            pst.setString(4, AG.getSiteWeb());
            pst.setString(5, AG.getNomDuResponsable());
            pst.setString(6, AG.getNombreDesEmployees());
            pst.setString(7, AG.getJourDeCreation());
            pst.executeUpdate();
            System.out.println("votre agence est ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

        /**********************************Affichage fonction **************/

            public ObservableList<agence> Afficher_agence(){
            ObservableList<agence> myList = (FXCollections.observableArrayList());

            try {

                String requete3 = "SELECT * FROM agence";
                Statement st = new MyConnection().getCnx().createStatement();
                ResultSet rs = st.executeQuery(requete3);
                while (rs.next()) {
                    agence a = new agence();
                    //a.setId_agence(rs.getInt(1));
                    a.setCodeRegionAgence(rs.getString("codeRegionAgence"));
                    a.setNumeroTel(rs.getString("numeroTel"));
                    a.setEmail(rs.getString("email"));
                    a.setSiteWeb(rs.getString("siteWeb"));
                    a.setNomDuResponsable(rs.getString("nomDuResponsable"));
                    a.setNombreDesEmployees(rs.getString("nombreDesEmployees"));
                    a.setJourDeCreation(rs.getString("jourDeCreation"));


                    myList.add(a);
                }

            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
            return myList;
        }


    public List<agence> afficherles_agences() {
        List<agence> myList = new ArrayList<agence>() {
        };
        try {

            String requete3 = "SELECT * FROM agence";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                agence a = new agence();
                a.setIdAgence(rs.getInt(1));
                a.setCodeRegionAgence(rs.getString("codeRegionAgence"));
                a.setNumeroTel(rs.getString("numeroTel"));
                a.setEmail(rs.getString("email"));
                a.setSiteWeb(rs.getString("siteWeb"));
                a.setNomDuResponsable(rs.getString("nomDuResponsable"));
                a.setNombreDesEmployees(rs.getString("nombreDesEmployees"));
                a.setJourDeCreation(rs.getString("jourDeCreation"));

                myList.add(a);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
 /****************************Supprimer agence  hela *********************************/
 public  void SupprimerAgence(int id) {
     try {
         String requete5 = "DELETE FROM agence where idAgence='" + id+ "'";

         PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete5);
        // pst.setInt(1, sup);
         pst.executeUpdate(requete5);
         System.out.println("Votre agence est supprime !!");
     } catch (SQLException ex) {
         System.err.println(ex.getMessage());
     }
 }
 /******************************** Supprimer louay **************************/
/* public static void SupprimerAgence(int id) {
     try {
         String requete5 = "DELETE FROM agence WHERE idAgence= ?";
         PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete5);
         pst.setInt(1, id);
         pst.executeUpdate(requete5);
         System.out.println("Votre agence est supprime !!");
     } catch (SQLException ex) {
         System.err.println(ex.getMessage());
     }
 }

*/


 public static List<agence> RechercherAgence( String code ){
     List<agence> myList = new ArrayList<>();
     try {

         String req6 = ("SELECT * from agence WHERE codeRegionAgence='" + code  + "'");
         Statement st;
         Connection cnx = MyConnection.getInstance().getCnx();
         st = cnx.createStatement();




         ResultSet result = st.executeQuery(req6);
         while(result.next())
         {
             agence a = new agence();
             a.setIdAgence(result.getInt(1));
             a.setCodeRegionAgence(result.getString(2));
             a.setNumeroTel(result.getString(3));
             a.setEmail(result.getString(4));
             a.setSiteWeb(result.getString(5));
             a.setNomDuResponsable(result.getString(6));
             a.setNombreDesEmployees(result.getString(7));
             a.setJourDeCreation(result.getString(8));


             myList.add(a);
             System.out.println(myList);
         }


     } catch (SQLException ex) {
         System.err.println(ex.getMessage());
     }
     return myList;
 }

    public void ModifierAgence(agence A) {

        try {
            String requete4 = "UPDATE `agence` SET `idAgence`= ? ,`codeRegionAgence`= ? ,`numeroTel`=?,`email`=?,`siteWeb`= ? ,`nomDuResponsable`= ? ,`nombreDesEmployees`=?,`jourDeCreation`=? WHERE idAgence= ?";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete4);
            pst.setInt(1, A.getIdAgence());
            pst.setString(2, A.getCodeRegionAgence());
            pst.setString(3, A.getNumeroTel());
            pst.setString(4, A.getEmail());
            pst.setString(5,A.getSiteWeb());
            pst.setString(6,A.getNomDuResponsable());
            pst.setString(7,A.getNombreDesEmployees());
            pst.setString(8,A.getJourDeCreation());
            pst.setInt(9, A.getIdAgence());
            pst.executeUpdate();
            System.out.println("Votre agence est modifie !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }


    }

    /*
    public void ajouterAgence5(agence AG) {
        try {
            String requete1 = " UPDATE agence SET codeRegionAgence=?,numeroTel=?,email=?,siteWeb=?,nomDuResponsable=?,nombreDesEmployees=?,jourDeCreation=? WHERE idAgence = ?";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete1);
            //pst.setInt(1, AG.getIdAgence());
            pst.setString(1, AG.getCodeRegionAgence());
            pst.setString(2, AG.getNumeroTel());
            pst.setString(3, AG.getEmail());
            pst.setString(4, AG.getSiteWeb());
            pst.setString(5, AG.getNomDuResponsable());
            pst.setString(6, AG.getNombreDesEmployees());
            pst.setString(7, AG.getJourDeCreation());
            pst.setInt(8, AG.getIdAgence());

            pst.executeUpdate(requete1);
            System.out.println("votre agence est ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }*/




    }


