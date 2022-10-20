package com.theagences.theagences.entities;

public class coordonnees {
    private int id_coordonnees ;
    private float latitude ;
    private float longitude ;

    public coordonnees (){}

    public coordonnees(int id_coordonnees, float latitude, float longitude) {
        this.id_coordonnees = id_coordonnees;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public coordonnees(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public int getId_coordonnees() {
        return id_coordonnees;
    }

    public void setId_coordonnees(int id_coordonnees) {
        this.id_coordonnees = id_coordonnees;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }



    @Override
    public String toString() {
        return "coordonnees{" +
                "id_coordonnees=" + id_coordonnees +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
