package Tetrago;

import java.util.Scanner;

public class Joueur {
    private String joueur1;
    private String joueur2;
    private Plateau plateau;

    public Joueur() {
        joueur1 = new String();
        joueur2 = new String();
        plateau = new Plateau();
    }
    /**
     * 
     * @return le joueur1
     */
    public String getJoueur1() {
        return joueur1;
    }
    /**
     * 
     * @return le joueur2
     */
    public String getJoueur2() {
        return joueur2;
    }
    @Override
    public String toString() {
        if (tirageAuSort()) {
            return getJoueur1();
        }
        else {
            return getJoueur2();
        }
    }
     /**
     * demande les noms des deux joueurs et presente le plateau
     */
    public void bienvenue() {
        System.out.print("Donnez le nom du premier joueur qui aura comme chiffre 1 : ");
        Scanner scanner = new Scanner(System.in);
        joueur1 = scanner.nextLine();
        System.out.print("Donnez le nom du second joueur qui aura comme chiffre 2 : ");
        joueur2 = scanner.nextLine();
        System.out.println();

        System.out.println("Bienvenue " + joueur1 + " et " + joueur2 + " ! ");
        System.out.println();
        System.out.println("Voici le plateau ! ");
    }

    /**
     * 
     * @return vrai si le joueur 1 doit commencer 
     */
    public boolean tirageAuSort() {
        System.out.println("Nous allons faire le tirage au sort pour savoir qui commence...");
        double random = Math.random();
        if (random >= 0 && random < 0.5) {
            System.out.println("Le joueur qui commence est " + joueur1);
            return true;
        }
        System.out.println("Le joueur qui commence est " + joueur2);
        return false;
    }
    /**
     * permet au joueur un de poser une de ses billes dans une case inoccupee du
     * plateau et de tourner
     * un des quartiers secondaires
     * 
     * @return le plateau modifie
     */
    public Plateau tourJoueur() {
        System.out.println("Tour : " + this.toString());
        System.out.println("Sur quelle ligne du plateau voulez-vous poser votre pion ? : ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println("Sur quelle colonne du plateau voulez-vous poser votre pion ? : ");
        int y = scanner.nextInt();
        plateau.setCase(x, y, 1);
        System.out.println("Indiquez le quartier que vous voulez tourner : ");
        Scanner scanner2 = new Scanner(System.in);
        int a = scanner2.nextInt();
        System.out.println();

        int[] tableau = plateau.quartierCorrespondant(a);

        plateau.rotationQuartier(tableau[0], tableau[1]);

        return plateau;
    }
    
}
