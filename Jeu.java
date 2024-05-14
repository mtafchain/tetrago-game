package Tetrago;

import java.util.Scanner;

public class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;
    private Plateau plateau;

    public Jeu() {
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
        System.out.println();
    }

    /**
     * demande les noms des deux joueurs et presente le plateau
     */
    public void bienvenue() {
        System.out.print("Donnez le nom du premier joueur qui aura comme chiffre 1 : ");
        Scanner scanner = new Scanner(System.in);
        String nomJoueur1 = scanner.nextLine();
        joueur1 = new Joueur(nomJoueur1, 1);
        System.out.print("Donnez le nom du second joueur qui aura comme chiffre 2 : ");
        String nomJoueur2 = scanner.nextLine();
        joueur2 = new Joueur(nomJoueur2, 2);
        System.out.println();

        System.out.println("Bienvenue " + nomJoueur1 + " et " + nomJoueur2 + " ! ");
        System.out.println();
        System.out.println("Voici le plateau ! ");
    }

    /**
     * 
     * @return le joueur qui va debuter
     */
    public Joueur tirageAuSort() {
        System.out.println("Nous allons faire le tirage au sort pour savoir qui commence...");
        double random = Math.random();
        if (random >= 0 && random < 0.5) {
            System.out.println("Le joueur qui commence est " + joueur1.getNom());
            return joueur1;
        }
        System.out.println("Le joueur qui commence est " + joueur2.getNom());
        return joueur2;
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
        if (tirageAuSort() == joueur1) {
            while (verificationPartie() == false) {
                joueur1.jouer(plateau);
                System.out.println(plateau);
                if (plateau.partieGagne()) {
                    break;
                }
                if (plateau.partieNulle()) {
                    break;
                }
                joueur2.jouer(plateau);
                System.out.println(plateau);
                if (plateau.partieGagne()) {
                    break;
                }
                if (plateau.partieNulle()) {
                    break;
                }
            }
        } else {
            while (verificationPartie() == false) {
                joueur2.jouer(plateau);
                System.out.println(plateau);
                if (plateau.partieGagne()) {
                    break;
                }
                if (plateau.partieNulle()) {
                    break;
                }
                joueur1.jouer(plateau);
                System.out.println(plateau);
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
