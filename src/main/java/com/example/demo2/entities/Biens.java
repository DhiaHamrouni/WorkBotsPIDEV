package com.example.demo2.entities;

/**
 *
 * @author Dell
 */
import javafx.collections.ObservableList;

import java.util.Objects;

public class Biens {

    private int id_bien;
    private String type_bien;

    private float prix_dt;
    private float surface_total_metre;
    private String description;
    private String images;
    private String num_tel;
    private String adresse_mail;
    private int nb_chambre;
    private int num_etage;
    private int nb_etoile;

    private int nb_piscine;
    private float hauteur_metre;

    public Biens(ObservableList<String> type_bien, Float prix_dt, Float surface_total_metre, String description, String images, String num_tel, String adresse_mail, int nb_chambre, int num_etage) {
    }

    public Biens(String type_bien, Float prix_dt, Float surface_total_metre, String description, String images, String num_tel, String adresse_mail) {
    }

    //getter and setter
    public int getId_bien() {
        return id_bien;
    }

    public void setId_bien(int id_bien) {
        this.id_bien = id_bien;
    }

    public String getType_bien() {
        return String.valueOf(type_bien);
    }

    public void setType_bien(String type_bien) {
        this.type_bien = type_bien;
    }

    public float getPrix_dt() {
        return prix_dt;
    }

    public void setPrix_dt(float prix_dt) {
        this.prix_dt = prix_dt;
    }

    public float getSurface_total_metre() {
        return surface_total_metre;
    }

    public void setSurface_total_metre(float surface_total_metre) {
        this.surface_total_metre = surface_total_metre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public String getAdresse_mail() {
        return adresse_mail;
    }

    public void setAdresse_mail(String adresse_mail) {
        this.adresse_mail = adresse_mail;
    }

    public int getNb_chambre() {
        return nb_chambre;
    }

    public void setNb_chambre(int nb_chambre) {
        this.nb_chambre = nb_chambre;
    }

    public int getNum_etage() {
        return num_etage;
    }

    public void setNum_etage(int num_etage) {
        this.num_etage = num_etage;
    }

    public int getNb_etoile() {
        return nb_etoile;
    }

    public void setNb_etoile(int nb_etoile) {
        this.nb_etoile = nb_etoile;
    }

    public int getNb_piscine() {
        return nb_piscine;
    }

    public void setNb_piscine(int nb_piscine) {
        this.nb_piscine = nb_piscine;
    }

    public float getHauteur_metre() {
        return hauteur_metre;
    }

    public void setHauteur_metre(float hauteur_metre) {
        this.hauteur_metre = hauteur_metre;
    }

    //equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Biens biens = (Biens) o;
        return id_bien == biens.id_bien && Float.compare(biens.prix_dt, prix_dt) == 0 && Float.compare(biens.surface_total_metre, surface_total_metre) == 0 && nb_chambre == biens.nb_chambre && num_etage == biens.num_etage && nb_etoile == biens.nb_etoile && nb_piscine == biens.nb_piscine && Float.compare(biens.hauteur_metre, hauteur_metre) == 0 && Objects.equals(type_bien, biens.type_bien) && Objects.equals(description, biens.description) && Objects.equals(images, biens.images) && Objects.equals(num_tel, biens.num_tel) && Objects.equals(adresse_mail, biens.adresse_mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_bien, type_bien, prix_dt, surface_total_metre, description, images, num_tel, adresse_mail, nb_chambre, num_etage, nb_etoile, nb_piscine, hauteur_metre);
    }

    //toString
    @Override
    public String toString() {
        return "Biens{"
                + "id_bien=" + id_bien
                + ", type_bien='" + type_bien + '\''
                + ", prix_dt=" + prix_dt
                + ", surface_total_metre=" + surface_total_metre
                + ", description='" + description + '\''
                + ", images='" + images + '\''
                + ", num_tel='" + num_tel + '\''
                + ", adresse_mail='" + adresse_mail + '\''
                + ", nb_chambre=" + nb_chambre
                + ", num_etage=" + num_etage
                + ", nb_etoile=" + nb_etoile
                + ", nb_piscine=" + nb_piscine
                + ", hauteur_metre=" + hauteur_metre
                + '}';
    }

    //constructeur
    public Biens(Float prix_dt, Float surface_total_metre, String description, String images, String num_tel, String adresse_mail, int id_bien, int num_etage, int nb_etoile, int nb_piscine, Float hauteur_metre) {
    }
    public Biens() {
    }
    //tous les attributs
    public Biens(String type_bien, float prix_dt,
                 float surface_total_metre,
                 String description, String images, String num_tel, String adresse_mail, int nb_chambre, int num_etage, int nb_etoile,
                 int nb_piscine, float hauteur_metre) {

        this.type_bien = type_bien;
        this.prix_dt = prix_dt;
        this.surface_total_metre = surface_total_metre;

        this.description = description;
        this.images = images;
        this.num_tel = num_tel;
        this.adresse_mail = adresse_mail;
        this.nb_chambre = nb_chambre;
        this.num_etage = num_etage;
        this.nb_etoile = nb_etoile;
        this.nb_piscine = nb_piscine;
        this.hauteur_metre = hauteur_metre;

    }

    // basique
    public Biens(String type_bien, float prix_dt,
                 float surface_total_metre,
                 String description, String images, String num_tel, String adresse_mail) {

        this.type_bien = type_bien;
        this.prix_dt = prix_dt;
        this.surface_total_metre = surface_total_metre;
        this.description = description;
        this.images = images;
        this.num_tel = num_tel;
        this.adresse_mail = adresse_mail;

    }

    //maison appartement
    public Biens(String type_bien, float prix_dt,
                 float surface_total_metre,
                 String description, String images, String num_tel, String adresse_mail, int nb_chambre, int num_etage) {

        this.type_bien = type_bien;
        this.prix_dt = prix_dt;
        this.surface_total_metre = surface_total_metre;
        this.description = description;
        this.images = images;
        this.num_tel = num_tel;
        this.adresse_mail = adresse_mail;
        this.nb_chambre = nb_chambre;
        this.num_etage = num_etage;

    }

    //hotel
    public Biens(String type_bien, float prix_dt,
                 float surface_total_metre,
                 String description, String images, String num_tel, String adresse_mail, int nb_chambre, int nb_etoile, int nb_piscine) {

        this.type_bien = type_bien;
        this.prix_dt = prix_dt;
        this.surface_total_metre = surface_total_metre;
        this.description = description;
        this.images = images;
        this.num_tel = num_tel;
        this.adresse_mail = adresse_mail;
        this.nb_chambre = nb_chambre;
        this.nb_etoile = nb_etoile;
        this.nb_piscine = nb_piscine;

    }

    //depot,usine
    public Biens(String type_bien, float prix_dt,
                 Float surface_total_metre,
                 String description, String images, String num_tel, String adresse_mail, float hauteur_metre) {

        this.type_bien = type_bien;

        this.prix_dt = prix_dt;
        this.surface_total_metre = surface_total_metre;
        this.description = description;
        this.images = images;
        this.num_tel = num_tel;
        this.adresse_mail = adresse_mail;
        this.hauteur_metre = hauteur_metre;
    }


}
