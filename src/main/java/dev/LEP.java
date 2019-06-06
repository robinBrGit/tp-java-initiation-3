package dev;

public class LEP extends CompteBancaire {
    private final float INTERRET = 1.5f;
    private final float PLAFOND_MIN = 30;
    private final float PLAFOND_MAX = 7700;

    public LEP(Proprietaire proprietaire, float montant) {
        super(proprietaire, montant);
    }

    @Override
    public void retrait(float montantRetrait) {
        if(this.montant-PLAFOND_MIN >= montantRetrait)
            super.retrait(montantRetrait);
        else System.out.println("Fond insufisant pour effectuer le retrait");
    }

    @Override
    public void depot(float montantDepot) {
        if (this.montant + montantDepot < PLAFOND_MAX)
            super.depot(montantDepot);
        else System.out.println("Impossible d'effectuer le depot. Vous dépasser le plafond max du compte");
    }

    @Override
    public void virement(CompteBancaire compteBeneficiaire, float montant) {
        if(this.montant-PLAFOND_MIN-TAX_VIREMENT >= montant)
            super.virement(compteBeneficiaire, montant);
    }

    @Override
    public void appliquerInteret() {
        this.montant += this.montant*INTERRET/100;
    }
}
