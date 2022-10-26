package com.example.demo2.entities;
import java.util.Objects;

public class Annonces {

    public static void add(Annonces annonces) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int id_annonce;
    private int id_bien;
    private String titre_annonce;
    private String affiche_annonce;
    private String date_depot;

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public int getId_bien() {
        return id_bien;
    }

    public void setId_bien(int id_bien) {
        this.id_bien = id_bien;
    }

    public String getTitre_annonce() {
        return titre_annonce;
    }

    public void setTitre_annonce(String titre_annonce) {
        this.titre_annonce = titre_annonce;
    }

    public String getAffiche_annonce() {
        return affiche_annonce;
    }

    public void setAffiche_annonce(String affiche_annonce) {
        this.affiche_annonce = affiche_annonce;
    }

    public String getDate_depot() {
        return date_depot;
    }

    public void setDate_depot(String date_depot) {
        this.date_depot = date_depot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Annonces annonces = (Annonces) o;
        return id_annonce == annonces.id_annonce && id_bien == annonces.id_bien && Objects.equals(titre_annonce, annonces.titre_annonce) && Objects.equals(affiche_annonce, annonces.affiche_annonce) && Objects.equals(date_depot, annonces.date_depot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_annonce, id_bien, titre_annonce, affiche_annonce, date_depot);
    }

    @Override
    public String toString() {
        return "Annonces{"
                + "id_annonce=" + id_annonce
                + ", id_bien=" + id_bien
                + ", titre_annonce='" + titre_annonce + '\''
                + ", affiche_annonce='" + affiche_annonce + '\''
                + ", date_depot='" + date_depot + '\''
                + '}';
    }

    public Annonces() {
    }

    public Annonces(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public Annonces(String titre_annonce) {
        this.titre_annonce = titre_annonce;
    }

    public Annonces(int id_annonce, int id_bien, String titre_annonce, String affiche_annonce, String date_depot) {

        this.id_annonce = id_annonce;
        this.id_bien = id_bien;
        this.titre_annonce = titre_annonce;
        this.affiche_annonce = affiche_annonce;
        this.date_depot = date_depot;
    }

    public Annonces(int id_bien, String titre_annonce, String affiche_annonce, String date_depot) {

        this.id_bien = id_bien;
        this.titre_annonce = titre_annonce;
        this.affiche_annonce = affiche_annonce;
        this.date_depot = date_depot;
    }

    public Annonces(String titre_annonce, String affiche_annonce, String date_depot) {

        this.titre_annonce = titre_annonce;
        this.affiche_annonce = affiche_annonce;
        this.date_depot = date_depot;
    }

    public String titre_annonce() {
        return titre_annonce;
    }
}
