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
    
}
