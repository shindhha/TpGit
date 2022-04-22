/*
 * Diff�rents traitements les dur�es
 * DureeHMS.java
 */

package lesdurees;

import java.util.Scanner;

/**
 * Traitements sur les dur�es exprim�es en heure/minute/seconde Les minutes et
 * les secondes sont comprises entre 0 et 59 Un nombre d'heures est un entier
 * positif ou nul. Une dur�e est repr�sent�e par un tableau de 3 entiers.
 * 
 * @author INFO1
 */
public class DureeHMS {

    /**
     * Saisie d'un entier. La saisie est recommenc�e en cas d'erreur
     * @return l'entier saisi (un entier quelconque)
     */
    public static int saisirEntier() {
        Scanner entree = new Scanner(System.in);
        int valeur = 0;
        boolean correct = false;    // on suppose que la saisie est incorrecte

        // on recommence la saisie jusqu'� ce qu'elle soit correcte
        do {
            System.out.print("Vous allez entrez une chaine et le programme verifiera"
                             + " si elle est bien dans le format hh:mm:ss. \n"
                             + "Le separateur ':' peut etre remplace par n'importe"
                             + " quel caractere.          \n ==> ");
            if (entree.hasNextInt()) {      // l'utilisateur a entr� un entier
                valeur = entree.nextInt();
                correct = true;
            }
            entree.nextLine();              // on vide le tampon d'entr�e
        } while (!correct);
        return valeur;                      // on renvoie l'entier saisi
    }

    
    /**
     * Saisie d'un entier positif ou nul. La saisie est recommenc�e en cas
     * d'erreur
     * @param message affich� pour l'utilisateur
     * @return l'entier saisi
     */
    public static int saisirEntierPositif(String message) {
        Scanner entree = new Scanner(System.in);
        int valeur = -1; // initialis�e avec un entier incorrect

        // on recommence la saisie jusqu'� obtenir un entier positif ou nul
        do {
            System.out.print(message);
            if (entree.hasNextInt()) {  // l'utilisateur a entr� un entier
                valeur = entree.nextInt();
            }
            entree.nextLine();          // on vide le tampon d'entr�e
        } while (valeur < 0);

        return valeur;                  // on renvoie l'entier saisi
    }

    
    /**
     * Saisie d'un entier appartenant � un intervalle. La saisie est recommenc�e
     * en cas d'erreur
     * @param message affich� pour l'utilisateur
     * @param inferieur borne inf�rieure de l'intervalle
     * @param superieur borne sup�rieure de l'intervalle
     * @return l'entier saisi
     */
    public static int saisirEntierIntervalle(String message, int inferieur,
                                             int superieur) {
        Scanner entree = new Scanner(System.in);
        int valeur = inferieur - 1;         // initialis�e avec un entier incorrect

        /*
         * on recommence la saisie jusqu'� obtenir un entier
         * appartenant � l'intervalle
         */
        do {
            System.out.print(message);
            if (entree.hasNextInt()) {      // l'utilisateur a entr� un entier
                valeur = entree.nextInt();
            }
            entree.nextLine();              // on vide le tampon d'entr�e
        } while (valeur < inferieur || valeur > superieur);
        return valeur; // on renvoie l'entier saisi
    }

    
    /**
     * Affiche une dur�e exprim�e en heures, minutes et secondes

     * @param duree
     *            tableau de 3 entiers contenant les heures, minutes et secondes
     */
    public static void afficher(int[] duree) {
        System.out.println(duree[0] + " heure(s) " + duree[1] + " minute(s) "
                + duree[2] + " seconde(s) ");
    }

    /**
     * Saisie d'une dur�e en heures, minutes et secondes La saisie de chaque
     * valeur est recommenc�e en cas d'erreur
     * 
     * @param message
     *            affich� pour l'utilisateur
     * @return un tableau contenant les 3 entiers saisis
     */
    public static int[] saisirDuree(String message) {
        int[] duree = new int[3]; // dur�e saisie

        System.out.println(message);
        // saisie des heures, puis des minutes, puis des secondes
        duree[0] = saisirEntierPositif(" Heures ? ");
        duree[1] = saisirEntierIntervalle(" Minutes ? ", 0, 59);
        duree[2] = saisirEntierIntervalle(" Secondes ? ", 0, 59);

        return duree; // on renvoie la dur�e saisie
    }

   

    /**
     * D�termine si les 2 dur�es argument sont identiques ou pas
     * 
     * @param d1
     *            premi�re dur�e � tester
     * @param d2
     *            deuxi�me dur�e � tester
     * @return un bool�en �gal � vrai ssi les 2 dur�es argument sont �gales
     */
    public static boolean egalite(int[] d1, int[] d2) {
        // on renvoie vrai ssi les heures, les minutes et les secondes sont
        // 2 � 2 �gales
        return d1[0] == d2[0] && d1[1] == d2[1] && d1[2] == d2[2];
    }

    /**
     * D�termine si les 2 dur�es argument sont ordonn�es ou pas
     * 
     * @param d1
     *            premi�re dur�e � tester
     * @param d2
     *            deuxi�me dur�e � tester
     * @return un bool�en �gal � vrai ssi les 2 dur�es argument sont ordonn�es
     *         ou �gales
     */
    public static boolean ordre(int[] d1, int[] d2) {
        // comparaison des heures, puis �ventuellement des minutes, puis
        // �ventuellement des secondes
        return d1[0] < d2[0] || // heure de d1 < heure de d2
                (d1[0] == d2[0] && (d1[1] < d2[1] ||
                // les heures de d1 et de d2 sont �gales
                // et minute de d1 < minute de d2
                (d1[1] == d2[1] && d1[2] <= d2[2])));
        // les minutes de d1 et d2 sont �gales
        // et les secondes de d1 < secondes de d2
    }

    /**
     * D�termine si les 3 dur�es argument sont ordonn�es ou pas
     * 
     * @param d1
     *            premi�re dur�e � tester
     * @param d2
     *            deuxi�me dur�e � tester
     * @param d3
     *            troisi�me dur�e � tester
     * @return un bool�en �gal � vrai ssi les 3 dur�es argument sont ordonn�es
     *         ou �gales
     */
    public static boolean ordre(int[] d1, int[] d2, int[] d3) {
        return ordre(d1, d2) && ordre(d2, d3);
    }

    /**
     * D�termine combien de dur�es sont diff�rentes parmi les 3 pass�es en
     * param�tres
     * 
     * @param d1
     *            premi�re dur�e
     * @param d2
     *            deuxi�me dur�e
     * @param d3
     *            troisi�me dur�e
     * @return un entier compris entre 1 et 3 �gal au nombre de dur�es
     *         diff�rentes pass�es en param�tre
     */
    public static int combienDifferentes(int[] d1, int[] d2, int[] d3) {
        int differente = 3;
        if (egalite(d1, d2)) {
            if (egalite(d2, d3)) { // les 3 dur�es sont identiques
                differente = 1;
            } else {
                differente = 2; // d1 == d2 et d3 diff�rente
            }
        } else if (egalite(d2, d3)) {
            differente = 2; // d2 == d3 et d1 diff�rente
        } else if (egalite(d1, d3)) {
            differente = 2; // d1 == d3 et d2 diff�rente
        }

        // on renvoie le r�sultat
        return differente;
    }


    /**
     * D�termine si un caract�re est un chiffre
     * 
     * @param caractere
     *            caract�re � tester
     * @return un bool�en �gal � vrai ssi le caract�re est un chiffre
     */
    public static boolean estUnChiffre(char caractere) {
        return caractere >= '0' && caractere <= '9';
    }

    /**
     * D�termine si la cha�ne argument contient le motif suivant � partir de la
     * position d�but : un s�parateur ( un caract�re autre qu'un chiffre) un
     * chiffre ou 2 chiffres
     * 
     * @param chaine
     *            la cha�ne dans laquelle le motif est v�rifi�
     * @param debut
     *            l'indice � partir duquel la v�rification est faite
     * @return un entier �gal � -1 si le motif n'a pas �t� trouv� l'indice du
     *         caract�re qui fait suite au motif
     */
    public static int motif(String chaine, int debut) {
        boolean correct;
        int indiceFin = -1;

        // on v�rifie si le caract�re d'indice debut existe et contient un
        // s�parateur
        correct = debut < chaine.length()
                && !estUnChiffre(chaine.charAt(debut));

        // on v�rifie si le caract�re d'indice d�but+1 existe
        // et est un chiffre
        correct = correct && debut + 1 < chaine.length()
                && estUnChiffre(chaine.charAt(debut + 1));

        if (correct) {
            indiceFin = debut + 2; // fin pr�sum� du motif
            if (indiceFin < chaine.length()
                    && estUnChiffre(chaine.charAt(indiceFin))) {
                // il y a un chiffre � l'indiceFin
                indiceFin++;
            }
        }

        // on renvoie le r�sultat
        return correct ? indiceFin : -1;
    }

    /**
     * D�termine si une cha�ne de caract�res contient une dur�e dans le format
     * suivant : une suite de chiffres non vide un s�parateur (autre qu'un
     * chiffre) un ou 2 chiffres un s�parateur un ou 2 chiffres
     * 
     * @param chaine
     *            cha�ne � tester
     * @return un bool�en �gal � vrai ssi la cha�ne contient bien une dur�e
     */
    public static boolean estChaineDuree(String chaine) {
        boolean correct;
        int indice; // indice de parcours de la cha�ne

        // on v�rifie qu'il y a bien au moins un chiffre en d�but de cha�ne
        correct = chaine != null && chaine.length() > 0
                && estUnChiffre(chaine.charAt(0));
        if (correct) {
            // on am�ne l'indice sur le 1er s�parateur
            for (indice = 0; indice < chaine.length()
                    && estUnChiffre(chaine.charAt(indice)); indice++)
                ;

            correct = indice < chaine.length(); // le caract�re courant
                                                // n'est pas un chiffre
            if (correct) {

                // on teste si l'on a un motif � partir de l'indice
                // motif = s�parateur puis un ou 2 chiffres
                indice = motif(chaine, indice);
                correct = indice > -1 && indice < chaine.length();

                if (correct) {
                    // on teste la pr�sence du deuxi�me motif
                    indice = motif(chaine, indice);
                    correct = indice > -1 && indice == chaine.length();
                }
            }
        }

        return correct;
    }
        
          /**
     * Affiche une dur�e exprim�e en heures, minutes et secondes
     * 
     * @param h
     *            heures
     * @param m
     *            minutes
     * @param s
     *            seconcdes
     */
    public static void afficher(int h, int m, int s) {
        System.out.println(h + " heure(s) " + m + " minute(s) " + s
                + " seconde(s) ");
    }

   


}