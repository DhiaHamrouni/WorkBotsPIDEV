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
   private String nom_commercial;
   private Date date;
   private Date valable_jusqu_à;
   private String mission;
   private Date date_commencement;
   private float prix_ttc;
   private float prix_ht;
   private String description;

    public Devis() {
    }

    public Devis(String nom_client, String nom_commercial, Date date, Date valable_jusqu_à, String mission, Date date_commencement, float prix_ttc, float prix_ht, String description) {
        this.nom_client = nom_client;
        this.nom_commercial = nom_commercial;
        this.date = date;
        this.valable_jusqu_à = valable_jusqu_à;
        this.mission = mission;
        this.date_commencement = date_commencement;
        this.prix_ttc = prix_ttc;
        this.prix_ht = prix_ht;
        this.description = description;
    }





    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getNom_client() {
        return nom_client;
    }

    public int getNum_devis() {
        return num_devis;
    }


    public String getNom_commercial() {
        return nom_commercial;
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


    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public void setNum_devis(int num_devis) {
        this.num_devis = num_devis;
    }


    public void setNom_commercial(String nom_commercial) {
        this.nom_commercial = nom_commercial;
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
        return "Devis{" + "nom_client=" + nom_client + ", num_devis=" + num_devis + ", nom_commercial=" + nom_commercial + ", date=" + date + ", valable_jusqu_\u00e0=" + valable_jusqu_à + ", mission=" + mission + ", date_commencement=" + date_commencement + ", prix_ttc=" + prix_ttc + ", prix_ht=" + prix_ht + ", description=" + description + '}';
    }

}