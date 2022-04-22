/*
 * UtilisationDuree.java
 */

package lesdurees;

import java.util.Scanner;

/**
 * Utilisation des m�thodes traitant les dur�es
 */
public class UtilisationDuree {


    /** 
     * Methode de test de la fonction Chaine
     * 
     */
    public static void testChaine() {
        Scanner entree = new Scanner(System.in);
        String phrase;
        System.out.print("Entrez une chaine : ");
        phrase = entree.nextLine();
        if (DureeHMS.estChaineDuree(phrase)) {
            System.out.println("OK !!");
        } else {
            System.out.println("ERREUR !!! ");
        }
    }
    
    /**
     * Methode de test pour la fonction ordre
     * 
     */
    public static void testOrdre() {
        int[] d1; // premi�re dur�e
        int[] d2; // deuxi�me dur�e
        int[] d3; // troisi�me

        d1 = DureeHMS.saisirDuree("Saisie de la premi�re dur�e : ");
        d2 = DureeHMS.saisirDuree("Saisie de la deuxi�me dur�e : ");
        d3 = DureeHMS.saisirDuree("Saisie de la troisi�me dur�e : ");

        System.out.println("ces 3 dur�es sont "
                + (DureeHMS.ordre(d1, d2, d3) ? " ordonn�es " : " dans le d�sordre"));

    }
    
    /** 
     * Methode de test de la fonction differente
     * 
     */
    public static void testDifferente() {
        int[] d1; // premi�re dur�e
        int[] d2; // deuxi�me dur�e
        int[] d3; // troisi�me

        d1 = DureeHMS.saisirDuree("Saisie de la premi�re dur�e : ");
        d2 = DureeHMS.saisirDuree("Saisie de la deuxi�me dur�e : ");
        d3 = DureeHMS.saisirDuree("Saisie de la troisi�me dur�e : ");

        System.out.println("Parmi ces 3 dur�es, "
                + DureeHMS.combienDifferentes(d1, d2, d3) + " sont diff�rentes.");

    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         testChaine();
    }
}