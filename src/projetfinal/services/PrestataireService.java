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
import projetfinal.entities.Prestataire;
import projetfinal.utils.MyConnexion;

/**
 *
 * @author GAMING
 */
public class PrestataireService {
    
        Connection cnx2;
    public PrestataireService(){
        cnx2 = MyConnexion.getInstance().getCnx();
    }
    public void ajouterPrestataire(Prestataire p){
        try{
            String req="INSERT INTO `prestataire_service`(`id_prestataire`, `nom_commercial`, `domaine_service`, `num_tel`, `email`) VALUES (?,?,?,?,?)";
            PreparedStatement pst =(PreparedStatement)cnx2.prepareStatement(req);
            pst.setInt(1, p.getId_prestataire());
            pst.setString(2, p.getNom_commercial());
            pst.setString(3, p.getDomaine_service());
            pst.setString(4, p.getNum_tel());
            pst.setString(5, p.getEmail());
            pst.executeUpdate();
            System.out.println("prestataire ajouter");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }
        public List<Prestataire> afficherPrestataires(){
        List<Prestataire> myList = new ArrayList<>();
        try {
            
            String req3 = "SELECT * FROM `prestataire_service`";
            Statement st;
            st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            while(rs.next())
            {
                Prestataire p = new Prestataire();
                p.setId_prestataire(rs.getInt(1));
                p.setNom_commercial(rs.getString(2));
                p.setDomaine_service(rs.getString(3));
                p.setNum_tel(rs.getString(4));
                p.setEmail(rs.getString(5));
                myList.add(p); 
            }  
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
       public void SupprimerPrestataire(int Id_prestataire){
        
        try {
            String req3= "DELETE FROM `prestataire_service` WHERE Id_prestataire= ?";
            PreparedStatement pst = cnx2.prepareStatement(req3);
            pst.setInt(1, Id_prestataire);
            pst.executeUpdate();
            System.out.println("Votre prestataire est supprime !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    } 
        public void ModifierPrestataire(Prestataire p){
        
        try {
            String req4= "UPDATE `prestataire_service` SET `id_prestataire`=?,`nom_commercial`=?,`domaine_service`=?,`num_tel`=?,`email`=? WHERE Id_prestataire = ?";
            PreparedStatement pst = cnx2.prepareStatement(req4);
            pst.setInt(1, p.getId_prestataire());
            pst.setString(2,p.getNom_commercial());
            pst.setString(3, p.getDomaine_service());
            pst.setString(4,p.getNum_tel());  
            pst.setString(5,p.getEmail()); 
            pst.setInt(6, p.getId_prestataire());
            pst.executeUpdate();
            System.out.println("Votre prestataire est modifie !!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
            public void RechercherPrestataire(Prestataire p){
        List<Prestataire> myList = new ArrayList<>();
        try {
            
            String req3 = "SELECT * FROM `prestataire_service`";
            Statement st;
            st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            Prestataire p2 = new Prestataire();
            p2.setId_prestataire(-1);
            while(rs.next())
            {
                
                if (rs.getInt(1) == p.getId_prestataire())
                {
                    p2.setId_prestataire(rs.getInt(1));

                    
                   
                    System.out.println("prestataire trouve !!");
                    System.out.println(p2);
                
                }
                
            }
            if (p2.getId_prestataire()==-1)
                {
                    System.out.println("prestataire n existe pas !");
                }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
        public Boolean RechercherPrestataire2(int Id_prestataire){
        List<Prestataire> myList = new ArrayList<>();
        try {
            
            String req3 = "SELECT * FROM `prestataire_service`";
            Statement st;
            st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req3);
            Prestataire p2 = new Prestataire();
            p2.setId_prestataire(-1);
            while(rs.next())
            {
                
                if (rs.getInt(1) == Id_prestataire)
                {
                    p2.setId_prestataire(rs.getInt(1));

                    
                    System.out.println("prestataire existe");
                    System.out.println(p2);
                    return true;
                
                }
                
            }
            if (p2.getId_prestataire()==-1)
                {
                    System.out.println("prestataire n existe pas !");                    
                    return false; 
                }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
}