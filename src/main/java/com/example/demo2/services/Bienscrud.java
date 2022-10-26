package com.example.demo2.services;

import com.example.demo2.entities.Biens;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo2.utils.Myconnection.getMyCnx;

public class Bienscrud {

    Connection cnx2;

    public Bienscrud() {
        cnx2 = getMyCnx().getConnection();
    }

///ajout
    public void ajouterBien(Biens B) {

        try {

            String requete2 = "INSERT INTO `biens`(`id_bien`, `type_bien`, `prix_dt`,"
                    + " `surface_total_metre`,`description`,`images`,`num_tel`,"
                    + "`adresse_mail`,`nb_chambre`,`num_etage`,`nb_etoile`,`nb_piscine`,`hauteur_metre`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setInt(1, B.getId_bien());
            pst.setString(2, B.getType_bien());
            pst.setFloat(3, B.getPrix_dt());
            pst.setFloat(4, B.getSurface_total_metre());
            pst.setString(5, B.getDescription());
            pst.setString(6, B.getImages());
            pst.setString(7, B.getNum_tel());
            pst.setString(8, B.getAdresse_mail());
            pst.setInt(9, B.getNb_chambre());
            pst.setInt(10, B.getNum_etage());
            pst.setInt(11, B.getNb_etoile());
            pst.setInt(12, B.getNb_piscine());
            pst.setFloat(13, B.getHauteur_metre());
            pst.executeUpdate();
            System.out.println("votre bien est ajouté avec succée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }

    }

    public void ajouterhotel(Biens B) {

        try {

            String requete2 = "INSERT INTO `biens`(`id_bien`, `type_bien`, `prix_dt`,"
                    + " `surface_total_metre`,`description`,`images`,`num_tel`,"
                    + "`adresse_mail`,`nb_chambre`,`nb_etoile`,`nb_piscine`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setInt(1, B.getId_bien());
            pst.setString(2, B.getType_bien());
            pst.setFloat(3, B.getPrix_dt());
            pst.setFloat(4, B.getSurface_total_metre());
            pst.setString(5, B.getDescription());
            pst.setString(6, B.getImages());
            pst.setString(7, B.getNum_tel());
            pst.setString(8, B.getAdresse_mail());
            pst.setInt(9, B.getNb_chambre());
            pst.setInt(10, B.getNb_etoile());
            pst.setInt(11, B.getNb_piscine());

            pst.executeUpdate();
            System.out.println("votre bien est ajouté avec succée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }

    }

    public void ajouterBiensimple(Biens B) {

        try {

            String requete2 = "INSERT INTO `biens`(`id_bien`, `type_bien`, `prix_dt`,"
                    + " `surface_total_metre`,`description`,`images`,`num_tel`,"
                    + "`adresse_mail`) "
                    + "VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setInt(1, B.getId_bien());
            pst.setString(2, B.getType_bien());
            pst.setFloat(3, B.getPrix_dt());
            pst.setFloat(4, B.getSurface_total_metre());
            pst.setString(5, B.getDescription());
            pst.setString(6, B.getImages());
            pst.setString(7, B.getNum_tel());
            pst.setString(8, B.getAdresse_mail());

            pst.executeUpdate();
            System.out.println("votre bien est ajouté avec succée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());

        }

    }

    public void ajouterDU(Biens B) {

        try {

            String requete2 = "INSERT INTO `biens`(`id_bien`, `type_bien`, `prix_dt`,"
                    + " `surface_total_metre`,`description`,`images`,`num_tel`,"
                    + "`adresse_mail`,`hauteur_metre`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setInt(1, B.getId_bien());
            pst.setString(2, B.getType_bien());
            pst.setFloat(3, B.getPrix_dt());
            pst.setFloat(4, B.getSurface_total_metre());
            pst.setString(5, B.getDescription());
            pst.setString(6, B.getImages());
            pst.setString(7, B.getNum_tel());
            pst.setString(8, B.getAdresse_mail());
            pst.setFloat(9, B.getHauteur_metre());
            pst.executeUpdate();
            System.out.println("votre bien est ajouté avec succée");}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());}
    }
    public void ajouterMA(Biens B) {

        try {

            String requete2 = "INSERT INTO `biens`(`id_bien`, `type_bien`, `prix_dt`,"
                    + " `surface_total_metre`,`description`,`images`,`num_tel`,"
                    + "`adresse_mail`,`nb_chambre`,`num_etage`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setInt(1, B.getId_bien());
            pst.setString(2, B.getType_bien());
            pst.setFloat(3, B.getPrix_dt());
            pst.setFloat(4, B.getSurface_total_metre());
            pst.setString(5, B.getDescription());
            pst.setString(6, B.getImages());
            pst.setString(7, B.getNum_tel());
            pst.setString(8, B.getAdresse_mail());
            pst.setInt(9, B.getNb_chambre());
            pst.setInt(10, B.getNum_etage());

            pst.executeUpdate();
            System.out.println("votre bien est ajouté avec succée");}
        catch (SQLException ex) {
            System.err.println(ex.getMessage());}
    }
///affichage
    public List<Biens> listerBiens() {
        List<Biens> myList = new ArrayList();
        try {
            String requete = "SELECT * FROM Biens";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Biens B = new Biens();
                B.setId_bien(rs.getInt("id_bien"));
                B.setType_bien(rs.getString("type_bien"));
                B.setPrix_dt(rs.getFloat("prix_dt"));
                B.setSurface_total_metre(rs.getFloat("surface_total_metre"));
                B.setDescription(rs.getString("description"));
                B.setImages(rs.getString("images"));
                B.setNum_tel(rs.getString("num_tel"));
                B.setAdresse_mail(rs.getString("adresse_mail"));
                B.setNb_chambre(rs.getInt("nb_chambre"));
                B.setNum_etage(rs.getInt("num_etage"));
                B.setNb_etoile(rs.getInt("nb_etoile"));
                B.setNb_piscine(rs.getInt("nb_piscine"));
                B.setHauteur_metre(rs.getFloat("hauteur_metre"));
                myList.add(B);}
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());}
        return myList;
    }
///supprime
    public void supprimerbien(Biens B) {
        try {
            String req = "DELETE FROM biens where id_bien='" + B.getId_bien()+ "'";
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.executeUpdate(req);
            System.out.println("bien est supprime");}
        catch (SQLException ex) {
            ex.printStackTrace();}
    }
///modif
    public void modifierbien(Biens B){ }


///recherche
public void RechercherB(Biens B){
    List<Biens> myList = new ArrayList<>();
    try {

        String req3 = "Select * from Biens";
        Statement st;
        st = cnx2.createStatement();
        ResultSet rs = st.executeQuery(req3);
        Biens e2 = new Biens();
        e2.setId_bien(-1);
        while(rs.next())
        {

            if (rs.getInt(1) == B.getId_bien())
            {
                e2.setId_bien(rs.getInt(1));
                e2.setType_bien(rs.getString(2));
                e2.setPrix_dt(rs.getFloat(3));
                e2.setSurface_total_metre(rs.getFloat(4));
                e2.setDescription(rs.getString(5));
                e2.setImages(rs.getString(6));
                e2.setNum_tel(rs.getString(7));
                e2.setAdresse_mail(rs.getString(8));
                e2.setNb_chambre(rs.getInt(9));
                e2.setNum_etage(rs.getInt(10));
                e2.setNb_etoile(rs.getInt(11));
                e2.setNb_piscine(rs.getInt(12));
                e2.setHauteur_metre(rs.getFloat(13));


                System.out.println("Bien trouve !!");
                System.out.println(e2);

            }

        }
        if (e2.getId_bien()==-1)
        {
            System.out.println("Bien n'existe pas !");
        }



    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }

}

    public ObservableList<Biens> afficherB(){
        List<Biens> myList = new ArrayList<>();
        ObservableList<Biens> oblist = FXCollections.observableArrayList();

        try {

            String req3 = "Select * from biens";
            Statement st;
            st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            while(rs.next())
            {
                Biens e2 = new Biens();
                e2.setId_bien(rs.getInt(1));
                e2.setType_bien(rs.getString(2));
                e2.setPrix_dt(rs.getFloat(3));
                e2.setSurface_total_metre(rs.getFloat(4));
                e2.setDescription(rs.getString(5));
                e2.setImages(rs.getString(6));
                e2.setNum_tel(rs.getString(7));
                e2.setAdresse_mail(rs.getString(8));
                e2.setNb_chambre(rs.getInt(9));
                e2.setNum_etage(rs.getInt(10));
                e2.setNb_etoile(rs.getInt(11));
                e2.setNb_piscine(rs.getInt(12));
                e2.setHauteur_metre(rs.getFloat(13));
                oblist.add(e2);

                myList.add(e2);

            }


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return oblist;
    }


}

