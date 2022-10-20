/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivalavilla.gestioncontrat;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import vivalavilla.gestioncontrat.entities.Contrat;
import vivalavilla.gestioncontrat.services.ContratCRUD;
import vivalavilla.gestioncontrat.utils.MyConnexion;

/**
 *
 * @author lenovo
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        //MyConnexion mc = MyConnexion.getInstance();
        //MyConnexion mc2 = MyConnexion.getInstance();
        ContratCRUD ccd = new ContratCRUD();
        //ccd.ajouterContrat();
       //Contrat c2 = new Contrat(4,"depot large" ,"Mehdi","Hela","78542136","14258523","dhia");
       //ccd.ajouterContrat2(c2);
      Contrat c3 = new Contrat("144","fedi","174","hamedkozdoghli","villa","5000dt","amal","2001-12-30");
       //ccd.ajouterContrat2(c3);
        //ccd.SupprimerContrat(2);a
        //ccd.rapportpdfContrat(c3);
        //ccd.ModifierContrat(c3);
        //ccd.RechercherContrat(c3);
        System.out.println(ccd.afficherContrats());
         //ccd.ajouterContrat();
         Contrat cc= new Contrat(4,"hiouiiidoiffjk,","hjkj","hkk","khkh","hkkk","pmppp0","dddddd","2012-01-03");
         ccd.ajouterContrat2(c3);
         
         

        
    }
    
}
