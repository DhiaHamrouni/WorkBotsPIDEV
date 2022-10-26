/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetfinal;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Date;
import java.time.LocalDate;
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
            Devis d=new Devis();
            d.setNum_devis(10);
            d.setDate(Date.valueOf(("2012-02-12")));
            d.setDate_commencement(Date.valueOf(("2012-02-13")));
            d.setValable_jusqu_à(Date.valueOf(("2012-02-13")));
            d.setMission("aaaaa");
            d.setDescription("aaaaa");
            d.setNom_client("aaaaa");
            d.setNom_commercial("aaaaa");
            d.setPrix_ht(100);
            d.setPrix_ttc(11);
            ds.ModifierDevis(d);
            
           //Prestataire p = new Prestataire(2, "TGH", "Traveau Generale Hydrolique", "20411849", "mladlald@esprit.tn");
           //ps.ajouterPrestataire(p);
           //ps.afficherPrestataires();
           //ps.ModifierPrestataire(p);
           //ds.SupprimerDevis(2);
           //ds.RechercherDevis2(7);
            //System.out.println(ps.afficherPrestataires());
    }
    
}
