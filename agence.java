package com.example.newagence.entities;

public class agence {
    public agence() {
    }

    private int idAgence;
    private String codeRegionAgence;
    private String numeroTel;
    private String email;
    private String siteWeb;
    private String nomDuResponsable;
    private String nombreDesEmployees;
    private String jourDeCreation;



    public agence(String codeRegionAgence, String numeroTel, String email, String siteWeb, String nomDuResponsable, String nombreDesEmployees, String jourDeCreation) {
        this.codeRegionAgence = codeRegionAgence;
        this.numeroTel = numeroTel;
        this.email = email;
        this.siteWeb = siteWeb;
        this.nomDuResponsable = nomDuResponsable;
        this.nombreDesEmployees = nombreDesEmployees;
        this.jourDeCreation = jourDeCreation;
    }

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public String getCodeRegionAgence() {
        return codeRegionAgence;
    }

    public void setCodeRegionAgence(String codeRegionAgence) {
        this.codeRegionAgence = codeRegionAgence;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getNomDuResponsable() {
        return nomDuResponsable;
    }

    public void setNomDuResponsable(String nomDuResponsable) {
        this.nomDuResponsable = nomDuResponsable;
    }

    public String getNombreDesEmployees() {
        return nombreDesEmployees;
    }

    public void setNombreDesEmployees(String nombreDesEmployees) {
        this.nombreDesEmployees = nombreDesEmployees;
    }

    public String getJourDeCreation() {
        return jourDeCreation;
    }

    public void setJourDeCreation(String jourDeCreation) {
        this.jourDeCreation = jourDeCreation;
    }

    @Override
    public String toString() {
        return "agence{" +
                "idAgence=" + idAgence +
                ", codeRegionAgence='" + codeRegionAgence + '\'' +
                ", numeroTel='" + numeroTel + '\'' +
                ", email='" + email + '\'' +
                ", siteWeb='" + siteWeb + '\'' +
                ", nomDuResponsable='" + nomDuResponsable + '\'' +
                ", nombreDesEmployees='" + nombreDesEmployees + '\'' +
                ", jourDeCreation='" + jourDeCreation + '\'' +
                '}';
    }
}