package com.example.newagence.services;

import com.example.newagence.entities.adresse;
import com.example.newagence.entities.agence;
import com.example.newagence.utils.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class adresseCrud {
    public void ajouterAdresse3(adresse AG) {
        try {
            String requete2 = "INSERT INTO adresse ( codeRegionAdresse,avenue,numeroRue,codePostal) " + "VALUES (?,?,?,?)";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete2);
            //pst.setInt(1, AG.getId_agence());
            pst.setString(1, AG.getCodeRegionAdresse());
            pst.setString(2, AG.getAvenue());
            pst.setString(3, AG.getNumeroRue());
            pst.setString(4, AG.getCodePostal());
            pst.executeUpdate();
            System.out.println("votre adresse est ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }



    public  void SupprimerAdresse(int id) {
        try {
            String requete5 = "DELETE FROM adresse where idAdresse='" + id+ "'";

            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete5);
            // pst.setInt(1, sup);
            pst.executeUpdate(requete5);
            System.out.println("Votre adresse est supprime !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }



    public List<adresse> afficherAdresse() {
        List<adresse> myList = new ArrayList<adresse>() {
        };
        try {

            String requete3 = "SELECT * FROM adresse";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                adresse a = new adresse();
                a.setIdAdresse(rs.getInt(1));
                a.setCodeRegionAdresse(rs.getString("codeRegionAdresse"));
                a.setAvenue(rs.getString("avenue"));
                a.setNumeroRue(rs.getString("numeroRue"));
                a.setCodePostal(rs.getString("codePostal"));


                myList.add(a);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }


    public static List<adresse> RechercherAdresse( String code ){
        List<adresse> myList = new ArrayList<>();
        try {

            String req6 = ("SELECT * from adresse WHERE codeRegionAdresse='" + code  + "'");
            Statement st;
            Connection cnx = MyConnection.getInstance().getCnx();
            st = cnx.createStatement();




            ResultSet result = st.executeQuery(req6);
            while(result.next())
            {
                adresse a = new adresse();
                a.setIdAdresse(result.getInt(1));
                a.setCodeRegionAdresse(result.getString(2));
                a.setAvenue(result.getString(3));
                a.setNumeroRue(result.getString(4));
                a.setCodePostal(result.getString(5));

                myList.add(a);
                System.out.println(myList);
            }


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }

    public boolean checkIfExists(String code) {

        String req7 = ("SELECT codeRegionAdresse from adresse WHERE codeRegionAdresse='" + code  + "'");
        Statement st;
        Connection cnx = MyConnection.getInstance().getCnx();
        try {
            st = cnx.createStatement();
            ResultSet result = st.executeQuery(req7);
            if(result.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return false;
    }





}
