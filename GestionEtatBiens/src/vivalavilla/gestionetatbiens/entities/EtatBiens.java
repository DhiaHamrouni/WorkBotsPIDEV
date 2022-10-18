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
    private String rating_bien; 
    private int nombre_defaults; 
    private String description_defaults; 

    public EtatBiens() {
    }

    public EtatBiens(int id, String rating_bien, int nombre_defaults, String description_defaults) {
        this.id = id;
        this.rating_bien = rating_bien;
        this.nombre_defaults = nombre_defaults;
        this.description_defaults = description_defaults;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRating_bien() {
        return rating_bien;
    }

    public void setRating_bien(String rating_bien) {
        this.rating_bien = rating_bien;
    }

    public int getNombre_defaults() {
        return nombre_defaults;
    }

    public void setNombre_defaults(int nombre_defaults) {
        this.nombre_defaults = nombre_defaults;
    }

    public String getDescription_defaults() {
        return description_defaults;
    }

    public void setDescription_defaults(String description_defaults) {
        this.description_defaults = description_defaults;
    }

    @Override
    public String toString() {
        return "EtatBiens{" + "id=" + id + ", rating_bien=" + rating_bien + ", nombre_defaults=" + nombre_defaults + ", description_defaults=" + description_defaults + '}';
    }
    
    
}
