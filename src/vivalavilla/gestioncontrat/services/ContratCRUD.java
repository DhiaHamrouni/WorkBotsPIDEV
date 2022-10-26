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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        String req="INSERT INTO `contrat` ("
                + "`reference`,`cin_client`, `nom_client`, `cin_vendeur`,"
                + " `nom_vendeur`, `nom_bien`, `prix_bien`, `nom_agent`, `date`) "
                + "VALUES ('RF-12345678','14451233','fediiii','15236315','hamads','sdfdsf',5.23,'mounir',DATE '2013-11-26')";
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
            String req2="INSERT INTO `contrat` ("
                + "`reference`,`cin_client`, `nom_client`, `cin_vendeur`,"
                + " `nom_vendeur`, `nom_bien`, `prix_bien`, `nom_agent`,`date`) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(req2);
            //pst.setInt(1, c.getId_bien_contrat());
            String ref = generateRef();
            while (verifierRef(ref)==true)
            {
                ref = generateRef();
            }
            pst.setString(1, ref);
            pst.setString(2, c.getCin_client_contrat());
            pst.setString(3, c.getNom_client_contrat());
            pst.setString(4, c.getCin_vendeur_contrat());
            pst.setString(5, c.getNom_vendeur_contrat());
            pst.setString(6, c.getNom_bien_contrat());
            pst.setString(7, c.getPrix_bien_contrat());
            pst.setString(8, c.getAgent_contrat());
            pst.setString(9, c.getDate());
            
            pst.executeUpdate();
            System.out.println("Votre contrat est ajouté!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public ObservableList<Contrat> afficherContrats(){
        List<Contrat> myList = new ArrayList<>();
        ObservableList<Contrat> oblist = FXCollections.observableArrayList();

        try {
            
            String req3 = "Select * from contrat";
            Statement st;
            st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            while(rs.next())
            {
                Contrat c = new Contrat();
                //c.setId_bien_contrat(rs.getInt(1));
                c.setReference(rs.getString(2));
                c.setCin_client_contrat(rs.getString(3));
                c.setNom_client_contrat(rs.getString(4));
                c.setCin_vendeur_contrat(rs.getString(5));
                c.setNom_vendeur_contrat(rs.getString(6));
                c.setNom_bien_contrat(rs.getString(7));
                c.setPrix_bien_contrat(rs.getString(8));
                c.setAgent_contrat(rs.getString(9));
                c.setDate(rs.getString(10));
                oblist.add(c);
                               
                myList.add(c); 
                
            }

            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return oblist;
    }
    public void SupprimerContrat(String ref){
        
        try {
            String req3= "DELETE FROM `contrat` WHERE reference= ?";
            PreparedStatement pst = cnx2.prepareStatement(req3);
            pst.setString(1, ref);
            pst.executeUpdate();
            System.out.println("Votre contrat est supprime !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void ModifierContrat(Contrat c){
        
        try {
            String req4= "UPDATE `contrat` SET `cin_client`=?,`nom_client`=?,`cin_vendeur`=?,`nom_vendeur`=?,`nom_bien`=?,`prix_bien`=?,`nom_agent`=?,`date`=? WHERE reference = ?";
            PreparedStatement pst = cnx2.prepareStatement(req4);
            //pst.setInt(1, c.getId_bien_contrat());
            pst.setString(1, c.getCin_client_contrat());
            pst.setString(2, c.getNom_client_contrat());
            pst.setString(3, c.getCin_vendeur_contrat());
            //pst.setString(4, c.getCin_vendeur_contrat());
            pst.setString(4, c.getNom_vendeur_contrat());
            pst.setString(5, c.getNom_bien_contrat());
            pst.setString(6, c.getPrix_bien_contrat());
            pst.setString(7, c.getAgent_contrat());
            pst.setString(8, c.getDate());
            pst.setString(9, c.getReference());
            pst.executeUpdate();
            System.out.println("Votre contrat est modifie !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public Contrat RechercherContrat(Contrat c){
        List<Contrat> myList = new ArrayList<>();
        Contrat c2 = new Contrat();
        c2.setReference("empty");
        try {
            
            String req3 = "Select * from contrat";
            Statement st;
            st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);

            while(rs.next())
            {
                System.out.println(rs.getString(2));
                System.out.println(" | ");
                if (rs.getString(2).equals(c.getReference()) )
                {c2.setId_bien_contrat(rs.getInt(1));
                    c2.setReference(rs.getString(2));
                    c2.setCin_client_contrat(rs.getString(3));
                    c2.setNom_client_contrat(rs.getString(4));
                    c2.setCin_vendeur_contrat(rs.getString(5));
                    c2.setNom_vendeur_contrat(rs.getString(6));
                    c2.setNom_bien_contrat(rs.getString(7));
                    c2.setPrix_bien_contrat(rs.getString(8));
                    c2.setAgent_contrat(rs.getString(9));
                    c2.setDate(rs.getString(10));
                    System.out.println("contrat trouve !!");
                    System.out.println(c2);

                
                }
                
            }
            if (c2.getId_bien_contrat()==-1)
                {
                    System.out.println("contrat n existe pas !");
                }





        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
      return c2;
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
        Paragraph para1 = new Paragraph("Reference Bien: : "+c.getReference()+"\n \n \n");
        Paragraph para7 = new Paragraph("Nom du bien: "+c.getNom_bien_contrat()+"\n \n \n");
        Paragraph para8 = new Paragraph("Prix du bien: "+c.getPrix_bien_contrat()+"\n \n \n");
        Paragraph para2 = new Paragraph("Nom du vendeur: "+c.getNom_vendeur_contrat()+"\n \n \n");
        Paragraph para3 = new Paragraph("Nom du client: "+c.getNom_client_contrat()+"\n \n \n");
        Paragraph para5 = new Paragraph("Cin du vendeur: "+c.getCin_vendeur_contrat()+"\n \n \n");
        Paragraph para6 = new Paragraph("Cin du client: "+c.getCin_client_contrat()+"\n \n \n");
        Paragraph para9 = new Paragraph("Date de vente: "+c.getDate()+"\n \n \n");

            Paragraph para4 = new Paragraph("La transaction est supervisee par notre agent: "+c.getAgent_contrat()+"\n \n \n");
        document.add(para1);
        document.add(para2);
        document.add(para3);
        document.add(para5);
        document.add(para6);
        document.add(para4);
        document.add(para7);
        document.add(para8);
        document.add(para9);
            Image img2 =Image.getInstance("D:\\pidev_assets\\signature.png");
            document.add(img2);

        
        document.close();
        }
        catch (Exception e){
        System.err.println(e);}
    
    }
    public String generateRef()
    {
        String ref = "RF-";

        int max = 9;
        int min = 0;
        int range = max - min + 1;

        // generate random numbers within 1 to 10
        for (int i = 0; i < 9; i++) {
            int rand = (int)(Math.random() * range) + min;

            // Output is different everytime this code is executed
            ref+=Integer.toString(rand);
        }
        return ref;
    }
    public List<Contrat> afficherContrats2(){
        List<Contrat> myList = new ArrayList<>();
        //ObservableList<Contrat> oblist = FXCollections.observableArrayList();

        try {

            String req3 = "Select * from contrat";
            Statement st;
            st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            while(rs.next())
            {
                Contrat c = new Contrat();
                c.setId_bien_contrat(rs.getInt(1));
                c.setCin_client_contrat(rs.getString(2));
                c.setNom_client_contrat(rs.getString(3));
                c.setCin_vendeur_contrat(rs.getString(4));
                c.setNom_vendeur_contrat(rs.getString(5));
                c.setNom_bien_contrat(rs.getString(6));
                c.setPrix_bien_contrat(rs.getString(7));
                c.setAgent_contrat(rs.getString(8));
                c.setDate(rs.getString(9));
                //oblist.add(c);

                myList.add(c);

            }


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    public boolean verifierRef(String ref)
    {
        boolean test = false;
        List<Contrat> lista= new ArrayList<>();
        ContratCRUD ccd = new ContratCRUD();
        Contrat c = new Contrat();
        lista= ccd.afficherContrats2();
        for (int i=0; i < lista.size();i++)
        {
            c = lista.get(i);
            if (c.getReference()==ref)
                test = true;
        }

        return test;
    }

    
}
