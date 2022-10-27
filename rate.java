package com.example.newagence.entities;

public class rate {

    private int id_rate;
    private String adresse;
    private int rating;

    public rate(int id_rate, String adresse, int rating) {
        this.id_rate = id_rate;
        this.adresse = adresse;
        this.rating = rating;
    }

    public rate(String adresse, int rating) {
        this.adresse = adresse;
        this.rating = rating;
    }

    public rate( ) {

    }

    public int getId_rate() {
        return id_rate;
    }

    public void setId_rate(int id_rate) {
        this.id_rate = id_rate;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "rate{" +
                "id_rate=" + id_rate +
                ", adresse='" + adresse + '\'' +
                ", rating=" + rating +
                '}';
    }
}
