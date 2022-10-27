package com.example.newagence.services;

import com.example.newagence.entities.rate;
import com.example.newagence.utils.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class rateCrud {

    public void ajouterRate (rate RT) {
        try {
            String requete2 = "INSERT INTO rate ( adresse,rating) " + "VALUES (?,?)";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete2);
            //pst.setInt(1, AG.getId_agence());
            pst.setString(1, RT.getAdresse());
            pst.setInt(2, RT.getRating());

            pst.executeUpdate();
            System.out.println("votre rate est ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public List<String> calculeRating () throws SQLException {
        List<String> myList1 = new ArrayList<String>();
        String req6 = ("SELECT adresse,AVG(rating) from rate GROUP BY adresse");
        Statement st;
        Connection cnx = MyConnection.getInstance().getCnx();
        st = cnx.createStatement();

        ResultSet result = st.executeQuery(req6);
        while(result.next())
        {
            myList1.add("Agence "+result.getString(1)+" a le score "+result.getFloat(2));
        }
        System.out.println(myList1);
        return myList1;
    }


}