package entite;

import java.sql.Date;

public class Agent {
    int id;
    String Nom;
    String Prenom;
    String Email;
    String Mdp;
    String NumTel;
    String dateNaissance;

    public Agent(int id, String nom, String prenom, String email, String mdp, String numTel, String dateNaissance) {
        this.id=id;
        this.Nom = nom;
        this.Prenom = prenom;
        this.Email = email;
        this.Mdp = mdp;
        this.NumTel = numTel;
        this.dateNaissance = dateNaissance;
    }

    public Agent() {

    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", Email='" + Email + '\'' +
                ", Mdp='" + Mdp + '\'' +
                ", NumTel='" + NumTel + '\'' +
                ", dateNaissance=" + dateNaissance +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMdp() {
        return Mdp;
    }

    public void setMdp(String mdp) {
        Mdp = mdp;
    }

    public String getNumTel() {
        return NumTel;
    }

    public void setNumTel(String numTel) {
        NumTel = numTel;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


}
