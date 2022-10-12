/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivalavilla.gestioncontrat;

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
    public static void main(String[] args) {
        // TODO code application logic here
        //MyConnexion mc = MyConnexion.getInstance();
        //MyConnexion mc2 = MyConnexion.getInstance();
        ContratCRUD ccd = new ContratCRUD();
        //ccd.ajouterContrat();
       //Contrat c2 = new Contrat(4,"depot large" ,"Mehdi","Hela","78542136","14258523","dhia");
       //ccd.ajouterContrat2(c2);
       Contrat c3 = new Contrat(12,"Maison","ghassen","fedi","10236547","45521402","dhia");
        //ccd.SupprimerContrat(2);a
        ccd.rapportpdfContrat(c3);
        //ccd.ModifierContrat(c2);
        //ccd.RechercherContrat(c2);
        //System.out.println(ccd.afficherContrats());
        
    }
    
}
