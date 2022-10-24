/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetfinal;

import projetfinal.entities.Prestataire;
import projetfinal.services.PrestataireService;

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
           Prestataire p = new Prestataire(2, "TGH", "Traveau Generale Hydrolique", "20411849", "mladlald@esprit.tn");
           //ps.ajouterPrestataire(p);
           //ps.afficherPrestataires();
           //ps.ModifierPrestataire(p);
            System.out.println(ps.afficherPrestataires());
    }
    
}
