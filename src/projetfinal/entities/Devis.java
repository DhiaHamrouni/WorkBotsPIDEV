/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetfinal.entities;

import java.sql.Date;

/**
 *
 * @author GAMING
 */
public class Devis {
   private String nom_client; 
   private int num_devis;
   private int id_prestataire;
   private String nom_commercial;
   private String cin_client;
   private String titre;
   private Date date;
   private Date valable_jusqu_à;
   private String mission;
   private Date date_commencement;
   private float prix_ttc;
   private float prix_ht;
   private String duree;
   private String modelite_paiement;

    public Devis() {
    }

    public Devis(String nom_client, int num_devis, int id_prestataire, String nom_commercial, String cin_client, String titre, Date date, Date valable_jusqu_à, String mission, Date date_commencement, float prix_ttc, float prix_ht, String duree, String modelite_paiement) {
        this.nom_client = nom_client;
        this.num_devis = num_devis;
        this.id_prestataire = id_prestataire;
        this.nom_commercial = nom_commercial;
        this.cin_client = cin_client;
        this.titre = titre;
        this.date = date;
        this.valable_jusqu_à = valable_jusqu_à;
        this.mission = mission;
        this.date_commencement = date_commencement;
        this.prix_ttc = prix_ttc;
        this.prix_ht = prix_ht;
        this.duree = duree;
        this.modelite_paiement = modelite_paiement;
    }

    public String getNom_client() {
        return nom_client;
    }

    public int getNum_devis() {
        return num_devis;
    }

    public int getId_prestataire() {
        return id_prestataire;
    }

    public String getNom_commercial() {
        return nom_commercial;
    }

    public String getCin_client() {
        return cin_client;
    }

    public String getTitre() {
        return titre;
    }

    public Date getDate() {
        return date;
    }

    public Date getValable_jusqu_à() {
        return valable_jusqu_à;
    }

    public String getMission() {
        return mission;
    }

    public Date getDate_commencement() {
        return date_commencement;
    }

    public float getPrix_ttc() {
        return prix_ttc;
    }

    public float getPrix_ht() {
        return prix_ht;
    }

    public String getDuree() {
        return duree;
    }

    public String getModelite_paiement() {
        return modelite_paiement;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public void setNum_devis(int num_devis) {
        this.num_devis = num_devis;
    }

    public void setId_prestataire(int id_prestataire) {
        this.id_prestataire = id_prestataire;
    }

    public void setNom_commercial(String nom_commercial) {
        this.nom_commercial = nom_commercial;
    }

    public void setCin_client(String cin_client) {
        this.cin_client = cin_client;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setValable_jusqu_à(Date valable_jusqu_à) {
        this.valable_jusqu_à = valable_jusqu_à;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public void setDate_commencement(Date date_commencement) {
        this.date_commencement = date_commencement;
    }

    public void setPrix_ttc(float prix_ttc) {
        this.prix_ttc = prix_ttc;
    }

    public void setPrix_ht(float prix_ht) {
        this.prix_ht = prix_ht;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public void setModelite_paiement(String modelite_paiement) {
        this.modelite_paiement = modelite_paiement;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.num_devis;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Devis other = (Devis) obj;
        return this.num_devis == other.num_devis;
    }

    @Override
    public String toString() {
        return "Devis{" + "nom_client=" + nom_client + ", num_devis=" + num_devis + ", id_prestataire=" + id_prestataire + ", nom_commercial=" + nom_commercial + ", cin_client=" + cin_client + ", titre=" + titre + ", date=" + date + ", valable_jusqu_\u00e0=" + valable_jusqu_à + ", mission=" + mission + ", date_commencement=" + date_commencement + ", prix_ttc=" + prix_ttc + ", prix_ht=" + prix_ht + ", duree=" + duree + ", modelite_paiement=" + modelite_paiement + '}';
    }
   
   
}