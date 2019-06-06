package dev;

import java.io.Serializable;

public class VirementAutomatique implements Serializable {
    private CompteBancaire debit;
    private CompteBancaire dest;
    private float montant;

    public CompteBancaire getDebit() {
        return debit;
    }

    public void setDebit(CompteBancaire debit) {
        this.debit = debit;
    }

    public CompteBancaire getDest() {
        return dest;
    }

    public void setDest(CompteBancaire dest) {
        this.dest = dest;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public VirementAutomatique(CompteBancaire debit, CompteBancaire dest, float montant) {
        this.debit = debit;
        this.dest = dest;
        this.montant = montant;
    }

    public void doVirementAuto(){
        this.debit.virement(this.dest,this.montant);
    }
}
