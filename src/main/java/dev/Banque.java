package dev;

import java.io.*;
import java.util.ArrayList;

// TODO: 06/06/2019 Ajouter des commentaire 
public class Banque implements Serializable{
    private ArrayList<Proprietaire> listProprietaire;
    private ArrayList<CompteBancaire> listCompteBancaire;
    private ArrayList<VirementAutomatique> listeVirementAuto;

    public ArrayList<Proprietaire> getListProprietaire() {
        return listProprietaire;
    }

    public ArrayList<CompteBancaire> getListCompteBancaire() {
        return listCompteBancaire;
    }

    public Banque(ArrayList<Proprietaire> listProprietaire, ArrayList<CompteBancaire> listCompteBancaire) {
        this.listProprietaire = listProprietaire;
        this.listCompteBancaire = listCompteBancaire;
        this.listeVirementAuto = new ArrayList<VirementAutomatique>();
    }

    public void appliquerInterets(){
        for (CompteBancaire object: listCompteBancaire) {
            object.appliquerInteret();
        }
    }


    public ArrayList<Proprietaire> searchProprietaires(String nomProprietaire){
        ArrayList<Proprietaire> listProprio = new ArrayList<Proprietaire>();
        for (Proprietaire unProprio: listProprietaire) {
            if(unProprio.getNom().contains(nomProprietaire)){
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

    public static void save(Banque uneBanque){
        //Nous déclarons nos objets en dehors du bloc try/catch

        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File("banque.txt"))));

            //Nous allons écrire l'obet banque dans un fichier
            oos.writeObject(uneBanque);
            //Ne pas oublier de fermer le flux !
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Banque load(){
        ObjectInputStream ois;
        Banque uneBanque=null;
        try {
            //On récupèreles données !
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("banque.txt"))));
            try {

                uneBanque = (Banque)ois.readObject();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            ois.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       return uneBanque;
    }

    public void addVirementAuto(CompteBancaire debit, CompteBancaire dest, float montant){
        ObjectInputStream ois = null;
        ObjectOutputStream oos;
        ArrayList<VirementAutomatique> listVirement = new ArrayList<VirementAutomatique>() ;
        File fich = new File("virement.txt");

        if(fich.length() > 0) {
            //On récupèreles données !
            try {
                ois = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(
                                        new File("virement.txt"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            try {
                if(ois != null){
                    listVirement = (ArrayList<VirementAutomatique>)ois.readObject();
                    ois.close();
                }

                VirementAutomatique unVirement = new VirementAutomatique(debit,dest,montant);
                listVirement.add(unVirement);

                oos = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(
                                        new File("virement.txt"))));

                //Nous allons écrire l'obet banque dans un fichier
                oos.writeObject(listVirement);
                //Ne pas oublier de fermer le flux !
                oos.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }

        public ArrayList<VirementAutomatique> getListeVirementAuto() {
            ObjectInputStream ois = null;
            ObjectOutputStream oos;
            ArrayList<VirementAutomatique> listVirement = new ArrayList<VirementAutomatique>();
            File fich = new File("virement.txt");

            //On récupèreles données !
            try {
                ois = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(
                                        new File("virement.txt"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {

                try {
                    listVirement = (ArrayList<VirementAutomatique>) ois.readObject();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return listVirement;
        }

        public void doLesVirementAuto(){
        this.listeVirementAuto = this.getListeVirementAuto();
        for(VirementAutomatique unVirementAuto: listeVirementAuto){
            unVirementAuto.doVirementAuto();
        }
        }

    }


