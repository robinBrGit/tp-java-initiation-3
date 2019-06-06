package dev;

import java.util.ArrayList;

public class Banque {
    private ArrayList<Proprietaire> listProprietaire;
    private ArrayList<CompteBancaire> listCompteBancaire;

    public Banque(ArrayList<Proprietaire> listProprietaire, ArrayList<CompteBancaire> listCompteBancaire) {
        this.listProprietaire = listProprietaire;
        this.listCompteBancaire = listCompteBancaire;
    }

    public void appliquerInterets(){
        for (CompteBancaire object: listCompteBancaire) {
            object.appliquerInteret();
        }
    }

    public ArrayList<Proprietaire> searchProprietaire(String nomProprietaire){
        ArrayList<Proprietaire> listProprio = new ArrayList<Proprietaire>();
        for (Proprietaire unProprio: listProprietaire) {
            if(unProprio.getNom().equals(nomProprietaire) || unProprio.getNom().indexOf(nomProprietaire) != -1){
                listProprio.add(unProprio);
            }
        }
        return  listProprio;
    }

    public ArrayList<CompteBancaire> getListCompteBancaireFrom(Proprietaire unProprio){
        ArrayList<CompteBancaire> lesCompte = new ArrayList<CompteBancaire>();
        for(CompteBancaire unCompte: listCompteBancaire){
            if(unCompte.getProprietaire().equals(unProprio))
                lesCompte.add(unCompte);
        }
        return lesCompte;
    }

    public ArrayList<CompteBancaire> listCompteDecouvert(){
        ArrayList<CompteBancaire> lesCompte = new ArrayList<CompteBancaire>();
        for(CompteBancaire unCompte:listCompteBancaire){
            if(unCompte.getMontant()<0)
                lesCompte.add(unCompte);
        }
        return lesCompte;
    }

    public float getMontantTotalDe(Proprietaire unProprio){
        float total = 0;
        for(CompteBancaire unCompte:this.getListCompteBancaireFrom(unProprio)){
            total+=unCompte.getMontant();
        }
        return total;
    }
}
