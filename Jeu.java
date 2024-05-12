package Tetrago;

import java.util.Scanner;

public class Jeu {
    private String joueur1;
    private String joueur2;
    private Plateau plateau;

    public Jeu() {
        plateau = new Plateau();
    }

    /**
     * 
     * @return le plateau de jeu
     */
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
        joueur1 = scanner.nextLine();
        System.out.print("Donnez le nom du second joueur qui aura comme chiffre 2 : ");
        joueur2 = scanner.nextLine();
        System.out.println();

        System.out.println("Bienvenue " + joueur1 + " et " + joueur2 + " ! ");
        System.out.println();
        System.out.println("Voici le plateau ! ");
    }

    /**
     * tire au sort
     * 
     * @return le joueur qui va debuter
     */
    public String tirageAuSort() {
        System.out.println("Nous allons faire le tirage au sort pour savoir qui commence...");
        double random = Math.random();
        if (random >= 0 && random < 0.5) {
            System.out.println("Le joueur qui commence est " + joueur1);
            return joueur1;
        }
        System.out.println("Le joueur qui commence est " + joueur2);
        return joueur2;
    }

    /**
     * permet au joueur un de poser une de ses billes dans une case inoccupee du
     * plateau et de tourner
     * un des quartiers secondaires
     * 
     * @return le plateau modifie
     */
    public Plateau tourJoueur1() {
        System.out.println("Tour : " + joueur1);
        System.out.println("Sur quelle ligne du plateau voulez-vous poser votre pion ? : ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println("Sur quelle colonne du plateau voulez-vous poser votre pion ? : ");
        int y = scanner.nextInt();
        plateau.setCase(x, y, 2);
        /*while (plateau.setCase(x, y, 2) == false) {
            System.out.println("Sur quelle ligne du plateau voulez-vous poser votre pion ? : ");
            x = scanner.nextInt();
            System.out.println("Sur quelle colonne du plateau voulez-vous poser votre pion ? : ");
            y = scanner.nextInt();
        }*/

        System.out.println("Indiquez le quartier que vous voulez tourner : ");
        Scanner scanner2 = new Scanner(System.in);
        int a = scanner2.nextInt();

        int[] tableau = plateau.quartierCorrespondant(a);

        plateau.rotationQuartier(tableau[0], tableau[1]);
        return plateau;
    }

    /**
     * permet au joueur deux de poser une de ses billes dans une case inoccupee du
     * plateau et de tourner
     * un des quartiers secondaires
     * 
     * @return le plateau modifie
     */
    public Plateau tourJoueur2() {
        System.out.println("Tour : " + joueur2);
        System.out.println("Sur quelle ligne du plateau voulez-vous poser votre pion ? : ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println("Sur quelle colonne du plateau voulez-vous poser votre pion ? : ");
        int y = scanner.nextInt();
        plateau.setCase(x, y, 1);
       /*  while (plateau.setCase(x, y, 1) == false) {
            System.out.println("Sur quelle ligne du plateau voulez-vous poser votre pion ? : ");
            x = scanner.nextInt();
            System.out.println("Sur quelle colonne du plateau voulez-vous poser votre pion ? : ");
            y = scanner.nextInt();
        }*/

        System.out.println("Indiquez le quartier que vous voulez tourner : ");
        Scanner scanner2 = new Scanner(System.in);
        int a = scanner2.nextInt();

        int[] tableau = plateau.quartierCorrespondant(a);

        plateau.rotationQuartier(tableau[0], tableau[1]);
        return plateau;
    }

    /**
     * permet d'executer les differents tour de jeu selon le joueur qui a debuter
     */
    public boolean tourJeu() {
        if (tirageAuSort() == joueur1) {
            while (plateau.partieNulle() == false || plateau.partieGagne() == false) {
                System.out.println(tourJoueur1());
                System.out.println(tourJoueur2());
            }
            if (plateau.partieGagne()) {
                return plateau.partieGagne();
            } else {
                return plateau.partieNulle();
            }
        } else {
            while (plateau.partieNulle() == false || plateau.partieGagne() == false) {
                System.out.println(tourJoueur2());
                System.out.println(tourJoueur1());
            }
            if (plateau.partieGagne()) {
                return plateau.partieGagne();
            }
            return plateau.partieNulle();
        }
    }
}
