package com.example.demo2.services;

import com.example.demo2.entities.Annonces;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo2.utils.Myconnection.getMyCnx;

public class Annoncescrud {

    Connection cnx2;
    public Annoncescrud(){
        cnx2= getMyCnx().getConnection();
    }

    public void ajouterannonce2(Annonces B) {
        String requete2 = "INSERT INTO `annonces`(`id_bien`, `titre_annonce`, `affiche_annonce`, `date_depot`)"
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = cnx2.prepareStatement(requete2);

            pst.setInt(1, B.getId_bien());

            pst.setString(2, B.getTitre_annonce());

            pst.setString(3, B.getAffiche_annonce());

            pst.setString(4, B.getDate_depot());

            pst.executeUpdate();
            System.out.println("votre annonce est ajouté avec succée");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

  /*  public static   List<Annonces> RechercheA( String titre_annonce ){
        List<Annonces> myList = new ArrayList<>();
        try {

            String req6 = ("SELECT * from annonces WHERE titre_annonce='" + titre_annonce  + "'");

            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req6);




            ResultSet result = st.executeQuery(req6);
            while(result.next())
            {
                Annonces a = new Annonces();
                a.setId_annonce(rs.getInt(1));
                a.setId_bien(rs.getInt(2));
                a.setTitre_annonce(rs.getString(3));
                a.setAffiche_annonce(rs.getString(4));
                a.setDate_depot(rs.getString(5));
                System.out.println("annonce trouvé");


                myList.add(a);
                System.out.println(myList);
            }


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }*/



    public List<Annonces> afficherannonce() {
        List<Annonces> myList = new ArrayList<>();
        String requete3 = " SELECT * FROM annonces";
        try {
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                myList.add(new Annonces(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    public void supprimerannonce(Annonces A) {
        try {
            String req = "DELETE FROM annonces where id_annonce='" + A.getId_annonce()+ "'";
            Statement st = cnx2.createStatement();
            st.executeUpdate(req);
            System.out.println("bien est supprime");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
/*
     public void Modifierannonce(Annonces A){

        try {
            String req4= "UPDATE annonces SET  id_bien=?,titre_annonce=?,affiche_annonce=?,date_depot=? WHERE id_annonce = ?";
            PreparedStatement pst = cnx.prepareStatement(req4);

            pst.setInt(1,A.getId_bien());
            pst.setString(2,A.getTitre_annonce());
            pst.setString(3,A.getAffiche_annonce());
            pst.setString(4, A.getDate_depot());
            pst.setInt(5, A.getId_annonce());

            pst.executeUpdate();
            System.out.println("Votre annonce est modifié avec succée !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }*/


    public List<Annonces> Rannonce(String titre_annonce) {

        List<Annonces> annonces = new ArrayList<>();
        String req = "SELECT * FROM annonces WHERE titre_annonce = " + titre_annonce ;
        try {

            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req);


            while (rs.next()) {
                Annonces a = new Annonces();
                a.setId_annonce(rs.getInt(1));
                a.setId_bien(rs.getInt(2));
                a.setTitre_annonce(rs.getString(3));
                a.setAffiche_annonce(rs.getString(4));
                a.setDate_depot(rs.getString(5));
                System.out.println("annonce trouvé");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return annonces;
    }
    public  List<Annonces> RechercheA( String titre_annonce ){
        List<Annonces> myList = new ArrayList<>();
        try {

            String req6 = ("SELECT * from annonces WHERE titre_annonce='" + titre_annonce  + "'");

            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req6);




            ResultSet result = st.executeQuery(req6);
            while(result.next())
            {
                Annonces a = new Annonces();
                a.setId_annonce(rs.getInt(1));
                a.setId_bien(rs.getInt(2));
                a.setTitre_annonce(rs.getString(3));
                a.setAffiche_annonce(rs.getString(4));
                a.setDate_depot(rs.getString(5));
                System.out.println("annonce trouvé");


                myList.add(a);
                System.out.println(myList);
            }


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }


}
