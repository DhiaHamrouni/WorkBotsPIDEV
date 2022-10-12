/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivalavilla.gestioncontrat.services;

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
import vivalavilla.gestioncontrat.entities.Contrat;
import vivalavilla.gestioncontrat.utils.MyConnexion;

/**
 *
 * @author lenovo
 */
public class ContratCRUD {
    Connection cnx2;
    public ContratCRUD(){
        cnx2 = MyConnexion.getInstance().getCnx();
    }
    public void ajouterContrat(){
        String req="INSERT INTO `contrat` (`id_bien_contrat`, "
                + "`nom_bien_contrat`, `nom_client_contrat`, `nom_vendeur_contrat`,"
                + " `cin_vendeur_contrat`, `cin_client_contrat`, `agent_contrat`) "
                + "VALUES ('15', 'maison s+2', 'fedi labidi', 'will smith', '14451233', '14451236', 'mohamed ben amor')";
        try {
            Statement st = cnx2.createStatement();
            st.executeUpdate(req);
            System.out.println("Contrat ajouté avec succees!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
        }
    }
    public void ajouterContrat2(Contrat c){
        
        try {
            String req2= "INSERT INTO `contrat` (`id_bien_contrat`, "
                + "`nom_bien_contrat`, `nom_client_contrat`, `nom_vendeur_contrat`,"
                + " `cin_vendeur_contrat`, `cin_client_contrat`, `agent_contrat`) "
                + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(req2);
            pst.setInt(1, c.getId_bien_contrat());
            pst.setString(2, c.getNom_bien_contrat());
            pst.setString(3, c.getNom_client_contrat());
            pst.setString(4,c.getNom_vendeur_contrat());
            pst.setString(5, c.getCin_vendeur_contrat());
            pst.setString(6,c.getCin_client_contrat());
            pst.setString(7,c.getAgent_contrat());
            pst.executeUpdate();
            System.out.println("Votre contrat est ajouté!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public List<Contrat> afficherContrats(){
        List<Contrat> myList = new ArrayList<>();
        try {
            
            String req3 = "Select * from contrat";
            Statement st;
            st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            while(rs.next())
            {
                Contrat c = new Contrat();
                c.setId_bien_contrat(rs.getInt(1));
                c.setNom_bien_contrat(rs.getString(2));
                c.setNom_client_contrat(rs.getString(3));
                c.setNom_vendeur_contrat(rs.getString(4));
                c.setCin_vendeur_contrat(rs.getString(5));
                c.setCin_client_contrat(rs.getString(6));
                c.setAgent_contrat(rs.getString(7));
                myList.add(c); 
                
            }

            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    public void SupprimerContrat(int id){
        
        try {
            String req3= "DELETE FROM `contrat` WHERE id_bien_contrat= ?";
            PreparedStatement pst = cnx2.prepareStatement(req3);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Votre contrat est supprime !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void ModifierContrat(Contrat c){
        
        try {
            String req4= "UPDATE `contrat` SET `id_bien_contrat`=?,`nom_bien_contrat`=?,`nom_client_contrat`=?,`nom_vendeur_contrat`=?,`cin_vendeur_contrat`=?,`cin_client_contrat`=?,`agent_contrat`=? WHERE id_bien_contrat = ?";
            PreparedStatement pst = cnx2.prepareStatement(req4);
            pst.setInt(1, c.getId_bien_contrat());
            pst.setString(2, c.getNom_bien_contrat());
            pst.setString(3, c.getNom_client_contrat());
            pst.setString(4,c.getNom_vendeur_contrat());
            pst.setString(5, c.getCin_vendeur_contrat());
            pst.setString(6,c.getCin_client_contrat());
            pst.setString(7,c.getAgent_contrat());            
            pst.setInt(8, c.getId_bien_contrat());
            pst.executeUpdate();
            System.out.println("Votre contrat est modifie !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void RechercherContrat(Contrat c){
        List<Contrat> myList = new ArrayList<>();
        try {
            
            String req3 = "Select * from contrat";
            Statement st;
            st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            Contrat c2 = new Contrat();
            c2.setId_bien_contrat(-1);
            while(rs.next())
            {
                
                if (rs.getInt(1) == c.getId_bien_contrat())
                {c2.setId_bien_contrat(rs.getInt(1));
                c2.setNom_bien_contrat(rs.getString(2));
                c2.setNom_client_contrat(rs.getString(3));
                c2.setNom_vendeur_contrat(rs.getString(4));
                c2.setCin_vendeur_contrat(rs.getString(5));
                c2.setCin_client_contrat(rs.getString(6));
                c2.setAgent_contrat(rs.getString(7));
                    System.out.println("contrat trouve !!");
                    System.out.println(c2);
                
                }
                else
                {
                    System.out.println("contrat n existe pas !");
                }
            }
            

            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    public void rapportpdfContrat(Contrat c){
        try {
        String file_name="C:\\Users\\lenovo\\Desktop\\contrat.pdf"; 
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file_name));
        document.open();
        Paragraph para = new Paragraph ("   ------------------------------------------| Agence immobiliier viva la villa |-----------------------------------------");
        Image img =Image.getInstance("D:\\pidev_assets\\logo.png");
        document.add(img);
        document.add(para);
        Paragraph para1 = new Paragraph("Nom du bien: "+c.getNom_bien_contrat()+"\n \n \n");
        Paragraph para2 = new Paragraph("Nom du vendeur: "+c.getNom_vendeur_contrat()+"\n \n \n");
        Paragraph para3 = new Paragraph("Nom du client: "+c.getNom_client_contrat()+"\n \n \n");
        Paragraph para5 = new Paragraph("Cin du vendeur: "+c.getCin_vendeur_contrat()+"\n \n \n");
        Paragraph para6 = new Paragraph("Cin du client: "+c.getCin_client_contrat()+"\n \n \n");        
        Paragraph para4 = new Paragraph("La transaction est supervisee par notre agent: "+c.getAgent_contrat()+"\n \n \n");
        document.add(para1);
        document.add(para2);
        document.add(para3);
        document.add(para5);
        document.add(para6);
        document.add(para4);

        
        document.close();
        }
        catch (Exception e){
        System.err.println(e);}
    
    }
    
}
