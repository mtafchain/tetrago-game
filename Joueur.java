package Tetrago;

import java.util.Scanner;

public class Joueur {
    private String nom;
    private int pion;

    public Joueur(String nom, int pion) {
        this.nom = nom;
        this.pion = pion;
    }

    public String getNom() {
        return nom;
    }

    /**
     * permet au joueur de poser une de ses billes dans une case inoccupee du
     * plateau et de tourner
     * un des quartiers secondaires
     * 
     * @return le plateau modifie
     */
    public void jouer(Plateau plateau) {
        System.out.println("Tour : " + nom);
        System.out.println("Sur quelle ligne du plateau voulez-vous poser votre pion ? : ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println("Sur quelle colonne du plateau voulez-vous poser votre pion ? : ");
        int y = scanner.nextInt();
        plateau.setCase(x, y, pion);
        System.out.println("Indiquez le quartier que vous voulez tourner : ");
        Scanner scanner2 = new Scanner(System.in);
        int a = scanner2.nextInt();
        System.out.println();

        int[] tableau = plateau.quartierCorrespondant(a);

        plateau.rotationQuartier(tableau[0], tableau[1]);

    }
}
