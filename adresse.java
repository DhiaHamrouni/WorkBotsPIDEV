package com.example.newagence.entities;

public class adresse {

    private int idAdresse ;
    private String codeRegionAdresse ;
    private String avenue ;
    private String numeroRue ;
    private String codePostal ;
    public adresse(){};
    public adresse(int idAdresse, String codeRegionAdresse, String avenue, String numeroRue, String codePostal) {
        this.idAdresse = idAdresse;
        this.codeRegionAdresse = codeRegionAdresse;
        this.avenue = avenue;
        this.numeroRue = numeroRue;
        this.codePostal = codePostal;
    }

    public adresse(String codeRegionAdresse, String avenue, String numeroRue, String codePostal) {
        this.codeRegionAdresse = codeRegionAdresse;
        this.avenue = avenue;
        this.numeroRue = numeroRue;
        this.codePostal = codePostal;
    }

    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getCodeRegionAdresse() {
        return codeRegionAdresse;
    }

    public void setCodeRegionAdresse(String codeRegionAdresse) {
        this.codeRegionAdresse = codeRegionAdresse;
    }

    public String getAvenue() {
        return avenue;
    }

    public void setAvenue(String avenue) {
        this.avenue = avenue;
    }

    public String getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(String numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        return "adresse{" +
                "idAdresse=" + idAdresse +
                ", codeRegionAdresse='" + codeRegionAdresse + '\'' +
                ", avenue='" + avenue + '\'' +
                ", numeroRue='" + numeroRue + '\'' +
                ", codePostal='" + codePostal + '\'' +
                '}';
    }
}
