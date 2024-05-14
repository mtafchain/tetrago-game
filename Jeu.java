package Tetrago;

import java.util.Scanner;

public class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;
    private Plateau plateau;

    public Jeu() { 
        joueur1 = new Joueur();
        joueur2 = new Joueur();
        plateau = new Plateau();
    }

    public Plateau getPlateau() {
        return plateau;
    }

    /**
     * rappelle les regles du jeu
     */
    public void reglesJeu() {
        System.out.println("Bienvenue dans le jeu de Tetrago");
        System.out.print("Voici les règles du jeu : à chaque tour,");
        System.out.print(" un joueur place une bille de son chiffre (1 ou 2) sur");
        System.out.print(" une case inoccupée du plateau puis tourne");
        System.out.println(" un des quartiers secondaires d'un quart de tour ");
        System.out.println("dans le sens contraire des aiguilles d'une montre.");
        System.out.print("Un joueur gagne en alignant quatre de ses billes");
        System.out.print(" dans une rangée verticale, horizontale ou diagonale");
        System.out.print(" après la rotation du quartier.");
        joueur1.bienvenue();
    }
    /**
     * 
     * @return vrai si la partie est soit gagnante pour un joueur ou nulle
     */
    public boolean verificationPartie() {
        return plateau.partieGagne() == true || plateau.partieNulle() == true;
    }

    /**
     * permet d'executer les differents tour de jeu selon le joueur qui a debuter
     * et de verifier a chaque tour si la partie est gagnee ou nulle
     */
    public void tourJeu() {
        if (joueur1.tirageAuSort() == true) {
            while (verificationPartie() == false) {
                System.out.println(joueur1.tourJoueur());
                if (plateau.partieGagne()) {
                    break;
                }
                if (plateau.partieNulle()) {
                    break;
                }
                System.out.println(joueur2.tourJoueur());
                if (plateau.partieGagne()) {
                    break;
                }
                if (plateau.partieNulle()) {
                    break;
                }
            }
        } else {
            while (verificationPartie() == false) {
                System.out.println(joueur2.tourJoueur());
                if (plateau.partieGagne()) {
                    break;
                }
                if (plateau.partieNulle()) {
                    break;
                }
                System.out.println(joueur1.tourJoueur());
                if (plateau.partieGagne()) {
                    break;
                }
                if (plateau.partieNulle()) {
                    break;
                }
            }
        }
    }
}
