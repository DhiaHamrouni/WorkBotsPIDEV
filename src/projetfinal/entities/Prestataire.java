/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetfinal.entities;

/**
 *
 * @author GAMING
 */
public class Prestataire {
    private int id_prestataire ;
    private String nom_commercial;
    private String domaine_service;
    private String num_tel;
    private String email;

    public Prestataire() {
    }

    public Prestataire(int id_prestataire, String nom_commercial, String domaine_service, String num_tel, String email) {
        this.id_prestataire = id_prestataire;
        this.nom_commercial = nom_commercial;
        this.domaine_service = domaine_service;
        this.num_tel = num_tel;
        this.email = email;
    }

    public int getId_prestataire() {
        return id_prestataire;
    }

    public String getNom_commercial() {
        return nom_commercial;
    }

    public String getDomaine_service() {
        return domaine_service;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setId_prestataire(int id_prestataire) {
        this.id_prestataire = id_prestataire;
    }

    public void setNom_commercial(String nom_commercial) {
        this.nom_commercial = nom_commercial;
    }

    public void setDomaine_service(String domaine_service) {
        this.domaine_service = domaine_service;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id_prestataire;
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
        final Prestataire other = (Prestataire) obj;
        return this.id_prestataire == other.id_prestataire;
    }

    @Override
    public String toString() {
        return "Prestataire{" + "id_prestataire=" + id_prestataire + ", nom_commercial=" + nom_commercial + ", domaine_service=" + domaine_service + ", num_tel=" + num_tel + ", email=" + email + '}';
    }
    
}