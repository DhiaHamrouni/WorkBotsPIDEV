package com.theagences.theagences.services;

import com.theagences.theagences.entities.Agence;
import com.theagences.theagences.utils.MyConnection;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgenceCrud {

    public void ajouterAgence2(Agence AG) {
        try {
            String requete2 = "INSERT INTO les_agences (numTel_agence ,email_agence ,siteWeb_agence ) " + "VALUES (?, ? ,? )";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete2);
            //pst.setInt(1, AG.getId_agence());
            pst.setString(1, AG.getNumTel_agence());
            pst.setString(2, AG.getEmail_agence());
            pst.setString(3, AG.getSiteWeb_agence());
            pst.executeUpdate();
            System.out.println("votre agence est ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public void ajouterAgence3(Agence AG) {
        try {
            String requete2 = "INSERT INTO agences (numTel_agence ,email_agence ,siteWeb_agence) " + "VALUES (?, ? ,?)";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete2);
            //pst.setInt(1, AG.getId_agence());
            pst.setString(1, AG.getNumTel_agence());
            pst.setString(2, AG.getEmail_agence());
            pst.setString(3, AG.getSiteWeb_agence());
            pst.executeUpdate();
            System.out.println("votre agence est ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }


    public List<Agence> afficherles_agences() {
        List<Agence> myList = new ArrayList<Agence>() {
        };
        try {

            String requete3 = "SELECT * FROM agences";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                Agence a = new Agence();
                a.setId_agence(rs.getInt(1));
                a.setNumTel_agence(rs.getString("numTel_agence"));
                a.setEmail_agence(rs.getString("email_agence"));
                a.setSiteWeb_agence(rs.getString("siteWeb_agence"));


                myList.add(a);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }

    public void ModifierAgence(Agence A) {

        try {
            String requete4 = "UPDATE `agences` SET `id_agence`= ? ,`numTel_agence`=?,`email_agence`=?,`siteWeb_agence`= ? WHERE id_agence= ?";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete4);
            pst.setInt(1, A.getId_agence());
            pst.setString(2, A.getNumTel_agence());
            pst.setString(3, A.getEmail_agence());
            pst.setString(4, A.getSiteWeb_agence());
            pst.setInt(5, A.getId_agence());



            pst.executeUpdate();
            System.out.println("Votre contrat est modifie !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }


    }

    public static void SupprimerAgence(int id) {
        try {
            String requete5 = "DELETE FROM agences WHERE id_agence= ?";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete5);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Votre agence est supprime !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public static List<Agence> RechercherAgence( Integer id_agence ){
        List<Agence> myList = new ArrayList<>();
        try {

            String req6 = ("SELECT * from agences WHERE id_agence='" + id_agence  + "'");
            Statement st;
            Connection cnx = MyConnection.getInstance().getCnx();
            st = cnx.createStatement();




            ResultSet result = st.executeQuery(req6);
            while(result.next())
            {
                Agence a = new Agence();
                a.setId_agence(result.getInt(1));
                a.setNumTel_agence(result.getString(2));
                a.setEmail_agence(result.getString(3));
                a.setSiteWeb_agence(result.getString(4));

                myList.add(a);
                System.out.println(myList);
            }


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }

}
