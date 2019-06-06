package dev;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Proprietaire eleve1 = new Personne("Broquerie Robin","44 rue des lilas","11/12/1993");
        Proprietaire eleve2 = new Personne("Ormaux Clement","45 Boulevard de Longchamp","11/06/1992");
        Proprietaire eleve3 = new Personne("Ollivier Glen","94 Rue Hector Berlioz","2/09/1995");

        CompteCourant compte1 = new CompteCourant(eleve1,1000,0);
        CompteCourant compte2 = new CompteCourant(eleve2,2000,150);
        CompteCourant compte3 = new CompteCourant(eleve3,4000,50);

        LDD compte4 = new LDD(eleve1,5000);

        System.out.println(compte1.getMontant());
        compte1.retrait(500);
        System.out.println(compte1.getMontant());
        compte1.depot(600);
        System.out.println(compte1.getMontant());
        compte1.virement(compte2,200);
        System.out.println(compte1.getMontant());
        System.out.println(compte2.getMontant());

        System.out.println("------------------------------");
        System.out.println(compte4.getMontant()+" : "+compte4.getProprietaire());
        compte4.depot(8000);
        System.out.println(compte4.getMontant()+" : "+compte4.getProprietaire());
        compte4.retrait(5000);
        System.out.println(compte4.getMontant()+" : "+compte4.getProprietaire());
        compte4.appliquerInteret();
        System.out.println(compte4.getMontant()+" : "+compte4.getProprietaire());
        System.out.println("------------------------------");

        ArrayList<Proprietaire> listProrietaire = new ArrayList<Proprietaire>();
        ArrayList<CompteBancaire> listCompteBancaire = new ArrayList<CompteBancaire>();

        listProrietaire.add(eleve1);
        listProrietaire.add(eleve2);
        listProrietaire.add(eleve3);

        listCompteBancaire.add(compte1);
        listCompteBancaire.add(compte2);
        listCompteBancaire.add(compte3);
        listCompteBancaire.add(compte4);

        Banque uneBanque = new Banque(listProrietaire,listCompteBancaire);

        uneBanque.appliquerInterets();
        System.out.println(compte4.getMontant());

        Banque.save(uneBanque);

        Banque uneBanque2 = Banque.load();

        System.out.println(uneBanque2.getListCompteBancaire().get(0).getProprietaire()+" : "+uneBanque2.getListCompteBancaire().get(0).getMontant());

    }
}
