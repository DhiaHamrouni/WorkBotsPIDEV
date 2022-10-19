/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetfinal.services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projetfinal.entities.Devis;
import projetfinal.utils.MyConnexion;

/**
 *
 * @author GAMING
 */
public class devisService {
    
            Connection cnx2;
    public devisService(){
        cnx2 = MyConnexion.getInstance().getCnx();
    }
    public void ajouterPrestataire(Devis d){
        try{
            String req="INSERT INTO `devis_service`(`nom_client`, `num_devis`, `id_prestataire`, `nom_commercial`, `cin_client`, `titre`, `date`, `valable_jusqu_à`, `mission`, `date_commencement`, `prix_ttc`, `prix_ht`, `duree`, `modelite_paiement`) VALUES  (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst =(PreparedStatement)cnx2.prepareStatement(req);
            
            pst.setString(1, d.getNom_client());
            pst.setInt(2, d.getNum_devis());
            pst.setInt(3, d.getId_prestataire());
            pst.setString(4, d.getNom_commercial());
            pst.setString(5, d.getCin_client());
            pst.setString(6, d.getTitre());
            pst.setDate(7, d.getDate());
            pst.setDate(8, d.getValable_jusqu_à());
            pst.setString(9, d.getMission());
            pst.setDate(10, d.getDate_commencement());
            pst.setFloat(11, d.getPrix_ttc());
            pst.setFloat(12, d.getPrix_ht());
            pst.setString(13, d.getDuree());
            pst.setString(13, d.getModelite_paiement()); 
            pst.executeUpdate();
            System.out.println("devis ajouter");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }    
            public List<Devis> afficherPrestataires(){
        List<Devis> myList = new ArrayList<>();
        try {
            
            String req3 = "SELECT * FROM `devis_service`";
            Statement st;
            st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            while(rs.next())
            {
                Devis d = new Devis();
                d.setNom_client(rs.getString(1));
                d.setNum_devis(rs.getInt(2));
                d.setId_prestataire(rs.getInt(3));
                d.setNom_commercial(rs.getString(4));
                d.setCin_client(rs.getString(5));
                d.setTitre(rs.getString(6));
                d.setDate(rs.getDate(7));
                d.setValable_jusqu_à(rs.getDate(8));
                d.setMission(rs.getString(9));
                d.setDate_commencement(rs.getDate(10));
                d.setPrix_ttc(rs.getFloat(11));
                d.setPrix_ht(rs.getFloat(12));
                d.setDuree(rs.getString(13));
                d.setModelite_paiement(rs.getString(14));
                myList.add(d); 
            }  
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
           public void SupprimerDevis(int Num_devis){
        
        try {
            String req3= "DELETE FROM `devis_service` WHERE Num_devis= ?";
            PreparedStatement pst = cnx2.prepareStatement(req3);
            pst.setInt(2, Num_devis);
            pst.executeUpdate();
            System.out.println("Votre devis est supprime !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    } 
            public void ModifierDevis(Devis d){
        
        try {
            String req4= "UPDATE `devis_service` SET `nom_client`=?,`num_devis`=?,`id_prestataire`=?,`nom_commercial`=?,`cin_client`=?,`titre`=?,`date`=?,`valable_jusqu_à`=?,`mission`=?,`date_commencement`=?,`prix_ttc`=?,`prix_ht`=?,`duree`=?,`modelite_paiement`=? WHERE Num_devis = ?";
            PreparedStatement pst = cnx2.prepareStatement(req4);
            
            pst.setString(1,d.getNom_client());
            pst.setInt(2, d.getNum_devis());
            pst.setInt(3, d.getId_prestataire());
            pst.setString(4, d.getNom_commercial());
            pst.setString(5,d.getCin_client());  
            pst.setString(6,d.getTitre()); 
            pst.setDate(7, d.getDate());
            pst.setDate(8, d.getValable_jusqu_à());
            pst.setString(9,d.getMission()); 
            pst.setDate(10, d.getDate_commencement());
            pst.setFloat(11, d.getPrix_ttc());
            pst.setFloat(12, d.getPrix_ht());
            pst.setString(13,d.getDuree());
            pst.setString(14,d.getModelite_paiement());
            pst.setInt(15, d.getNum_devis());
            pst.executeUpdate();
            System.out.println("Votre devis est modifie !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }       
               public void RechercherDevis(Devis d){
        List<Devis> myList = new ArrayList<>();
        try {
            
            String req3 = "SELECT * FROM `devis_service`";
            Statement st;
            st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            Devis d2 = new Devis();
            d2.setNum_devis(-1);
            while(rs.next())
            {
                
                if (rs.getInt(1) == d.getNum_devis())
                {
                    d2.setNom_client(rs.getString(1));
                    d2.setNum_devis(rs.getInt(2));
                    d2.setId_prestataire(rs.getInt(3));
                    d2.setNom_commercial(rs.getString(4));
                    d2.setCin_client(rs.getString(5));
                    d2.setTitre(rs.getString(6));
                    d2.setDate(rs.getDate(7));
                    d2.setValable_jusqu_à(rs.getDate(8));
                    d2.setMission(rs.getString(9));
                    d2.setDate_commencement(rs.getDate(10));
                    d2.setPrix_ttc(rs.getFloat(11));
                    d2.setPrix_ht(rs.getFloat(12));
                    d2.setDuree(rs.getString(13));
                    d2.setModelite_paiement(rs.getString(14));
                 
                   
                    System.out.println("devis trouve !!");
                    System.out.println(d2);
                
                }
                
            }
            if (d2.getNum_devis()==-1)
                {
                    System.out.println("devis n existe pas !");
                }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    } 
}