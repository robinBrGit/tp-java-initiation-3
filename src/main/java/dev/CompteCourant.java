package dev;

public class CompteCourant extends CompteBancaire {
    private float decouvert;

    public CompteCourant(Proprietaire proprietaire, float montant, float decouvert) {
        super(proprietaire, montant);
        this.decouvert = decouvert;
    }

    // TODO: 06/06/2019 gerer les execption
    @Override
    public void virement(CompteBancaire compteBeneficiaire, float montant) {
        if(this.montant+this.decouvert > montant){
            this.montant-= montant;
            compteBeneficiaire.depot(montant);
            if(!this.proprietaire.getNom().equals(compteBeneficiaire.proprietaire.getNom()))this.montant-=TAX_VIREMENT;
        }
    }

    // TODO: 06/06/2019 gerer les execption
    @Override
    public void retrait(float montantRetrait) {
        if(this.montant+this.decouvert > montantRetrait) {
            this.montant -= montantRetrait;
            System.out.println("Un montant de "+montantRetrait+" a été retiré de votre compte");
        }
        else System.out.println("Fond inssufisant pour le retrait");
    }
}
