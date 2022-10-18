/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import vivalavilla.gestionetatbiens.entities.EtatBiens;
import vivalavilla.gestionetatbiens.services.EtatbiensCRUD;

/**
 *
 * @author lenovo
 */
public class test {
    public static void main(String[] args) {
    EtatbiensCRUD ecd = new EtatbiensCRUD();
    EtatBiens e1 = new EtatBiens(2,"fsssssedi",0,"faadi");
        System.out.println(e1);
        System.out.println(ecd.afficherEtatbiens());
        //ecd.ajouterEtatbiens1();
        //ecd.RechercherContrat(e1);
        ecd.ModifierEtatbiens(e1);
    }
    
}
