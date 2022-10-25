/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetfinal;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import projetfinal.entities.Devis;
import projetfinal.entities.Prestataire;
import projetfinal.services.PrestataireService;
import projetfinal.services.devisService;

/**
 *
 * @author GAMING
 */
public class ProjetFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           PrestataireService ps = new PrestataireService();
           devisService ds = new devisService();
          // Devis d= new Devis("mahdi", 1,2 ,"fersi" , "1137946", "devis", 13/08/2022, 13/08/2022, "dadada", 13/08/2022, 500, 700, "dadadada", "eaea", "dadada");
           //Prestataire p = new Prestataire(2, "TGH", "Traveau Generale Hydrolique", "20411849", "mladlald@esprit.tn");
           //ps.ajouterPrestataire(p);
           //ps.afficherPrestataires();
           //ps.ModifierPrestataire(p);
           ds.SupprimerDevis(2);
           //ds.RechercherDevis2(2);
            //System.out.println(ps.afficherPrestataires());
    }
    
}
