/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivalavilla.gestionetatbiens.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
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
import vivalavilla.gestionetatbiens.entities.EtatBiens;
import vivalavilla.gestionetatbiens.utils.MyConnexion;

/**
 *
 * @author lenovo
 */
public class EtatbiensCRUD {
    Connection cnx2;
    public EtatbiensCRUD(){
        cnx2 = MyConnexion.getInstance().getCnx();
    }
    public void ajouterEtatbiens1(){
        String req="INSERT INTO `etat_biens`(`id`, `rating_bien`, `nombre_defaut`, `description_etat`) VALUES ('1','5stars','2','cuisine et salon')";
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
            String req2= "INSERT INTO `etat_biens` (`id`, "
                + "`rating_bien`, `nombre_defaut`, `description_etat`) "
                + "VALUES (?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(req2);
            pst.setInt(1, e.getId());
            pst.setString(2, e.getRating_bien());
            pst.setInt(3, e.getNombre_defaults());
            pst.setString(4, e.getDescription_defaults());
            pst.executeUpdate();
            System.out.println("Votre etat est ajouté!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public List<EtatBiens> afficherEtatbiens(){
        List<EtatBiens> myList = new ArrayList<>();
        try {
            
            String req3 = "Select * from etat_biens";
            Statement st;
            st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            while(rs.next())
            {
                EtatBiens e = new EtatBiens();
                e.setId(rs.getInt(1));
                e.setRating_bien(rs.getString(2));
                e.setNombre_defaults(rs.getInt(3));
                e.setDescription_defaults(rs.getString(4));
                myList.add(e); 
                
            }

            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    public void SupprimerEtatbiens(int id){
        
        try {
            String req3= "DELETE FROM `etat_biens` WHERE id= ?";
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
            String req4= "UPDATE `etat_biens` SET `id`= ? ,`rating_bien`= ? ,`nombre_defaut`= ? ,`description_etat`= ? WHERE id = ?";
            PreparedStatement pst = cnx2.prepareStatement(req4);
            pst.setInt(1, e.getId());
            pst.setString(2, e.getRating_bien());
            pst.setInt(3, e.getNombre_defaults());
            pst.setString(4,e.getDescription_defaults());           
            pst.setInt(5, e.getId());
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
                    e2.setId(rs.getInt(1));
                    e2.setRating_bien(rs.getString(2));
                    e2.setNombre_defaults(rs.getInt(3));
                    e2.setDescription_defaults(rs.getString(4));
                    
                   
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
