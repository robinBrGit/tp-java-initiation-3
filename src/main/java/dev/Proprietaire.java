package dev;
import java.io.Serializable;
public abstract class Proprietaire implements Serializable {
    protected String nom;
    protected String adresse;

    public Proprietaire(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public String getNom(){
        return this.nom;
    }
    public String getAdresse(){
        return this.adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return this.nom;
    }
}
