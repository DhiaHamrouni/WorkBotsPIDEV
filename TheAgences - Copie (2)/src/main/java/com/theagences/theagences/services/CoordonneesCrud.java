package com.theagences.theagences.services;


import com.theagences.theagences.entities.coordonnees;
import com.theagences.theagences.utils.MyConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CoordonneesCrud {


    public void ajouterCoordonnees2(coordonnees c) {
        try {
            String requete2 = "INSERT INTO les_coordonnes (latitude ,longitude) " + "VALUES (?,?)";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete2);
            pst.setFloat(1, c.getLatitude());
            pst.setFloat(2, c.getLongitude());




            pst.executeUpdate();
            System.out.println("votre agence est ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }


    public List<coordonnees> afficherCoordonnees() {
        List<coordonnees> myList = new ArrayList<>();
        try {

            String requete3 = "SELECT * FROM les_coordonnes";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                coordonnees a = new coordonnees();
                a.setId_coordonnees(rs.getInt("id_coordonnees"));
                a.setLatitude(rs.getFloat("latitude"));
                a.setLongitude(rs.getFloat("longitude"));



                myList.add(a);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }

    public void ModifierAgence(coordonnees D) {

        try {

            String requete3 = "UPDATE `Les_coordonnes` SET `id_coordonnees`= ? ,`latitude`=?,`longitude`=?, WHERE id_coordonnees= ?";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete3);
            pst.setInt(1, D.getId_coordonnees());
            pst.setFloat(2, D.getLongitude());
            pst.setFloat(3, D.getLongitude());
            pst.setInt(4, D.getId_coordonnees());


            pst.executeUpdate();
            System.out.println("Votre Adresse est modifie !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void SupprimerAgence(int id_coordonnees) {
        try {
            String requete5 = "DELETE FROM Les_coordonnes WHERE id_coordonnees= ?";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete5);
            pst.setInt(1, id_coordonnees);
            pst.executeUpdate();
            System.out.println("Votre coordonnees est supprime !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}