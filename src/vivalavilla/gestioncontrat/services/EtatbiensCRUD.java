/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivalavilla.gestionetatbiens.services;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vivalavilla.gestionetatbiens.entities.EtatBiens;
import vivalavilla.gestioncontrat.utils.MyConnexion;

/**
 *
 * @author lenovo
 */
public class EtatbiensCRUD {
    Connection cnx2;
    public EtatbiensCRUD(){
        cnx2 = MyConnexion.getInstance().getCnx();
    }
    public void ajouterEtatbiens(){
        String req="INSERT INTO `etat_biens`(`id_bien`, `etat`, `nombre_pannes`, `description`) VALUES ('1','5stars','2','cuisine et salon')";
        try {
            Statement st = cnx2.createStatement();
            st.executeUpdate(req);
            System.out.println("Etat ajouté avec succees!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
    }
    public void ajouterEtatbiens2(EtatBiens e){
        
        try {
            String req2= "INSERT INTO `etat_biens` (`id_bien`, "
                + "`etat`, `nombre_pannes`, `description`) "
                + "VALUES (?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(req2);
            pst.setInt(1, e.getId_bien());
            pst.setString(2, e.getEtat());
            pst.setInt(3, e.getNombre_pannes());
            pst.setString(4, e.getDescription());
            pst.executeUpdate();
            System.out.println("Votre etat est ajouté!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public ObservableList<EtatBiens> afficherEtatbiens(){
        ObservableList<EtatBiens> oblist2 = FXCollections.observableArrayList();

        List<EtatBiens> myList = new ArrayList<>();
        try {
            
            String req3 = "Select * from etat_biens";
            Statement st;
            st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            while(rs.next())
            {
                EtatBiens e = new EtatBiens();
                e.setId_bien(rs.getInt(2));
                e.setEtat(rs.getString(3));
                e.setNombre_pannes(rs.getInt(4));
                e.setDescription(rs.getString(5));
                myList.add(e);
                oblist2.add(e);
                
            }

            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return oblist2;
    }
    public void SupprimerEtatbiens(int id){
        
        try {
            String req3= "DELETE FROM `etat_biens` WHERE id_bien= ?";
            PreparedStatement pst = cnx2.prepareStatement(req3);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Votre etat est supprime !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void ModifierEtatbiens(EtatBiens e){
        
        try {
            String req4= "UPDATE `etat_biens` SET `etat`= ? ,`nombre_pannes`= ? ,`description`= ? WHERE id_bien = ?";
            PreparedStatement pst = cnx2.prepareStatement(req4);
            //pst.setInt(1, e.getId_bien());
            pst.setString(1, e.getEtat());
            pst.setInt(2, e.getNombre_pannes());
            pst.setString(3,e.getDescription());
            pst.setInt(4, e.getId_bien());
            pst.executeUpdate();
            System.out.println("Votre etat est modifie !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void RechercherContrat(EtatBiens e){
        List<EtatBiens> myList = new ArrayList<>();
        try {
            
            String req3 = "Select * from contrat";
            Statement st;
            st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            EtatBiens e2 = new EtatBiens();
            e2.setId(-1);
            while(rs.next())
            {
                
                if (rs.getInt(1) == e.getId())
                {
                    e2.setId_bien(rs.getInt(1));
                    e2.setEtat(rs.getString(2));
                    e2.setNombre_pannes(rs.getInt(3));
                    e2.setDescription(rs.getString(4));
                    
                   
                    System.out.println("etat trouve !!");
                    System.out.println(e2);
                
                }
                
            }
            if (e2.getId()==-1)
                {
                    System.out.println("etat n existe pas !");
                }
            

            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    
}
