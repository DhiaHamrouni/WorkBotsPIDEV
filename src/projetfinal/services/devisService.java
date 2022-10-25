/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetfinal.services;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
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
            String req="INSERT INTO `devis_service`(`nom_client`, `nom_commercial`, `date`, `valable_jusqu_à`, `mission`, `date_commencement`, `prix_ttc`, `prix_ht`, `description`) VALUES  (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst =(PreparedStatement)cnx2.prepareStatement(req);
            
            pst.setString(1, d.getNom_client());
            pst.setString(2, d.getNom_commercial());
            pst.setDate(3, d.getDate());
            pst.setDate(4, d.getValable_jusqu_à());
            pst.setString(5, d.getMission());
            pst.setDate(6, d.getDate_commencement());
            pst.setFloat(7, d.getPrix_ttc());
            pst.setFloat(8, d.getPrix_ht());
            pst.setString(9, d.getDescription());
            pst.executeUpdate();
            System.out.println("devis ajouter");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }    
            public List<Devis> afficherDevis(){
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
                d.setNom_commercial(rs.getString(3));
                d.setDate(rs.getDate(4));
                d.setValable_jusqu_à(rs.getDate(5));
                d.setMission(rs.getString(6));
                d.setDate_commencement(rs.getDate(7));
                d.setPrix_ttc(rs.getFloat(8));
                d.setPrix_ht(rs.getFloat(9));
                d.setDescription(rs.getString(10));
                myList.add(d); 
            }  
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
           public void SupprimerDevis(int Num_devis){
        
        try {
            String req3= "DELETE FROM `devis_service` WHERE num_devis= ?";
            PreparedStatement pst = cnx2.prepareStatement(req3);
            pst.setInt(1, Num_devis);
            pst.executeUpdate();
            System.out.println("Votre devis est supprime !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    } 
            public void ModifierDevis(Devis d){
        
        try {
            String req4= "UPDATE `devis_service` SET `nom_client`=?,`num_devis`=?,`nom_commercial`=?,`date`=?,`valable_jusqu_à`=?,`mission`=?,`date_commencement`=?,`prix_ttc`=?,`prix_ht`=?,`description`=? WHERE num_devis = ?";
            PreparedStatement pst = cnx2.prepareStatement(req4);
            
            pst.setString(1,d.getNom_client());
            pst.setInt(2, d.getNum_devis());
            pst.setString(3, d.getNom_commercial());
            pst.setDate(4, d.getDate());
            pst.setDate(5, d.getValable_jusqu_à());
            pst.setString(6,d.getMission()); 
            pst.setDate(7, d.getDate_commencement());
            pst.setFloat(8, d.getPrix_ttc());
            pst.setFloat(9, d.getPrix_ht());
            pst.setString(10,d.getDescription());
            pst.setInt(11, d.getNum_devis());
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
                d.setNom_client(rs.getString(1));
                d.setNum_devis(rs.getInt(2));
                d.setNom_commercial(rs.getString(3));
                d.setDate(rs.getDate(4));
                d.setValable_jusqu_à(rs.getDate(5));
                d.setMission(rs.getString(6));
                d.setDate_commencement(rs.getDate(7));
                d.setPrix_ttc(rs.getFloat(8));
                d.setPrix_ht(rs.getFloat(9));
                d.setDescription(rs.getString(10));
                   
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
            public Boolean RechercherDevis2(int num_devis){
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
                if (rs.getInt(2) == num_devis)
                {
                    d2.setNom_client(rs.getString(1));
                    d2.setNum_devis(rs.getInt(2));
                    d2.setNom_commercial(rs.getString(3));
                    d2.setDate(rs.getDate(4));
                    d2.setValable_jusqu_à(rs.getDate(5));
                    d2.setMission(rs.getString(6));
                    d2.setDate_commencement(rs.getDate(7));
                    d2.setPrix_ttc(rs.getFloat(8));
                    d2.setPrix_ht(rs.getFloat(9));
                    d2.setDescription(rs.getString(10));

                    System.out.println("devis existe");
                    System.out.println(d2);
                    return true;
                
                }
                
            }
            if (d2.getNum_devis()==-1)
                {
                    System.out.println("devis n existe pas !");                    
                    return false; 
                }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }           
        public LocalDate convert(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
}           
}