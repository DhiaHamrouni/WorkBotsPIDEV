/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivalavilla.gestioncontrat.entities;

import javafx.scene.control.CheckBox;

/**
 *
 * @author lenovo
 */
public class Contrat {
    private int id_bien_contrat; 
    private String nom_bien_contrat;
    private String prix_bien_contrat;
    private String nom_client_contrat;
    private String nom_vendeur_contrat;
    private String cin_vendeur_contrat;
    private String cin_client_contrat;
    private String agent_contrat;
    private String date;

    private CheckBox checkBox;

    public Contrat() {
    }

    public Contrat(int id_bien_contrat, String nom_bien_contrat, String prix_bien_contrat, String nom_client_contrat, String nom_vendeur_contrat, String cin_vendeur_contrat, String cin_client_contrat, String agent_contrat, String date) {
        this.id_bien_contrat = id_bien_contrat;
        this.nom_bien_contrat = nom_bien_contrat;
        this.prix_bien_contrat = prix_bien_contrat;
        this.nom_client_contrat = nom_client_contrat;
        this.nom_vendeur_contrat = nom_vendeur_contrat;
        this.cin_vendeur_contrat = cin_vendeur_contrat;
        this.cin_client_contrat = cin_client_contrat;
        this.agent_contrat = agent_contrat;
        this.date = date;
    }

    public Contrat(String nom_bien_contrat, String prix_bien_contrat, String nom_client_contrat, String nom_vendeur_contrat, String cin_vendeur_contrat, String cin_client_contrat, String agent_contrat, String date) {
        this.nom_bien_contrat = nom_bien_contrat;
        this.prix_bien_contrat = prix_bien_contrat;
        this.nom_client_contrat = nom_client_contrat;
        this.nom_vendeur_contrat = nom_vendeur_contrat;
        this.cin_vendeur_contrat = cin_vendeur_contrat;
        this.cin_client_contrat = cin_client_contrat;
        this.agent_contrat = agent_contrat;
        this.date = date;
    }

    public int getId_bien_contrat() {
        return id_bien_contrat;
    }

    public void setId_bien_contrat(int id_bien_contrat) {
        this.id_bien_contrat = id_bien_contrat;
    }

    public String getNom_bien_contrat() {
        return nom_bien_contrat;
    }

    public void setNom_bien_contrat(String nom_bien_contrat) {
        this.nom_bien_contrat = nom_bien_contrat;
    }

    public String getPrix_bien_contrat() {
        return prix_bien_contrat;
    }

    public void setPrix_bien_contrat(String prix_bien_contrat) {
        this.prix_bien_contrat = prix_bien_contrat;
    }

    public String getNom_client_contrat() {
        return nom_client_contrat;
    }

    public void setNom_client_contrat(String nom_client_contrat) {
        this.nom_client_contrat = nom_client_contrat;
    }

    public String getNom_vendeur_contrat() {
        return nom_vendeur_contrat;
    }

    public void setNom_vendeur_contrat(String nom_vendeur_contrat) {
        this.nom_vendeur_contrat = nom_vendeur_contrat;
    }

    public String getCin_vendeur_contrat() {
        return cin_vendeur_contrat;
    }

    public void setCin_vendeur_contrat(String cin_vendeur_contrat) {
        this.cin_vendeur_contrat = cin_vendeur_contrat;
    }

    public String getCin_client_contrat() {
        return cin_client_contrat;
    }

    public void setCin_client_contrat(String cin_client_contrat) {
        this.cin_client_contrat = cin_client_contrat;
    }

    public String getAgent_contrat() {
        return agent_contrat;
    }

    public void setAgent_contrat(String agent_contrat) {
        this.agent_contrat = agent_contrat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CheckBox getCheckBox(){
        return checkBox;
    }
    public void setcheckBox(CheckBox checkBox){
        this.checkBox = checkBox;
    }

    @Override
    public String toString() {
        return "Contrat{" + "id_bien_contrat=" + id_bien_contrat + ", nom_bien_contrat=" + nom_bien_contrat + ", prix_bien_contrat=" + prix_bien_contrat + ", nom_client_contrat=" + nom_client_contrat + ", nom_vendeur_contrat=" + nom_vendeur_contrat + ", cin_vendeur_contrat=" + cin_vendeur_contrat + ", cin_client_contrat=" + cin_client_contrat + ", agent_contrat=" + agent_contrat + ", date=" + date + '}';
    }

    
    

    
}
