package dev;
import java.io.Serializable;
public abstract class CompteBancaire implements Serializable {
    protected Proprietaire proprietaire;
    protected int idCompteUnique;
    protected static int NB_COMPTE = 1;
    protected float montant;
    protected final float TAX_VIREMENT = 1;

    public Proprietaire getProprietaire() {
        return proprietaire;
    }

    public int getIdCompteUnique() {
        return idCompteUnique;
    }

    public float getMontant() {
        return montant;
    }

    public CompteBancaire(Proprietaire proprietaire, float montant) {
        this.proprietaire = proprietaire;
        this.idCompteUnique = NB_COMPTE;
        this.montant = montant;
        NB_COMPTE++;
    }

    public void retrait(float montantRetrait){
        if(this.montant >= montantRetrait) {
             this.montant -= montantRetrait;
            System.out.println("Un montant de "+montantRetrait+" a été retiré de votre compte");
        }
        else System.out.println("Fond inssufisant pour le retrait");

    }
    public void depot(float montantDepot){
        this.montant+=montantDepot;
        System.out.println("Un montant de "+montantDepot+" a été ajouter à votre compte");
    }

    public void virement(CompteBancaire compteBeneficiaire,float montant){
        if(this.montant-TAX_VIREMENT >= montant){
            this.montant-= montant;
            compteBeneficiaire.depot(montant);
            if(!this.proprietaire.getNom().equals(compteBeneficiaire.proprietaire.getNom()))this.montant-=1;
        }
    }

    public void appliquerInteret(){

    }
}
