/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vivalavilla.gestionetatbiens.entities;

/**
 *
 * @author lenovo
 */
public class EtatBiens {
    private int id; 
    private int id_bien;
    private String etat;
    private int nombre_pannes;
    private String description;

    public EtatBiens() {
    }

    public EtatBiens(int id, int id_bien, String etat, int nombre_pannes, String description) {
        this.id = id;
        this.id_bien = id_bien;
        this.etat = etat;
        this.nombre_pannes = nombre_pannes;
        this.description = description;
    }

    public EtatBiens(int id_bien, String etat, int nombre_pannes, String description) {
        this.id_bien = id_bien;
        this.etat = etat;
        this.nombre_pannes = nombre_pannes;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_bien() {
        return id_bien;
    }

    public void setId_bien(int id_bien) {
        this.id_bien = id_bien;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getNombre_pannes() {
        return nombre_pannes;
    }

    public void setNombre_pannes(int nombre_pannes) {
        this.nombre_pannes = nombre_pannes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "EtatBiens{" +
                "id=" + id +
                ", id_bien=" + id_bien +
                ", etat='" + etat + '\'' +
                ", nombre_pannes=" + nombre_pannes +
                ", description='" + description + '\'' +
                '}';
    }
}
