package dev;

public class Societe extends Proprietaire {
    private Personne gerant;

    public Societe(String nom, String adresse, Personne gerant) {
        super(nom, adresse);
        this.gerant = gerant;
    }

    @Override
    public String getType() {
        return "Societe";
    }
}
