package dev;

public class CompteCourant extends CompteBancaire {
    private float decouvert;

    public CompteCourant(Proprietaire proprietaire, int montant, float decouvert) {
        super(proprietaire, montant);
        this.decouvert = decouvert;
    }

    @Override
    public void virement(CompteBancaire compteBeneficiaire, float montant) {
        if(this.montant+this.decouvert > montant){
            this.montant-= montant;
            compteBeneficiaire.depot(montant);
            if(!this.proprietaire.getNom().equals(compteBeneficiaire.proprietaire.getNom()))this.montant-=1;
        }
    }

    @Override
    public void retrait(float montantRetrait) {
        if(this.montant+this.decouvert > montantRetrait) {
            this.montant -= montantRetrait;
            System.out.println("Un montant de "+montantRetrait+" a été retiré de votre compte");
        }
        else System.out.println("Fond inssufisant pour le retrait");
    }
}
