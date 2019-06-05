package dev;

public class Personne extends Proprietaire {
    private String dateNaissance;

    public Personne(String nom, String adresse, String dateNaissance) {
        super(nom, adresse);
        this.dateNaissance = dateNaissance;
    }

    @Override
    public String getType() {
        return "Personne";
    }
}
