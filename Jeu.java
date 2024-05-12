package Tetrago;

import java.util.Scanner;

public class Jeu {
    private String joueur1;
    private String joueur2;
    private Plateau plateau;

    public Jeu() {
        plateau = new Plateau();
    }

    public Plateau getPlateau() {
        return plateau;
    }

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

    public String tirageAuSort() {
        System.out.println("Nous allons faire le tirage au sort pour savoir qui commence...");
        double random = Math.random();
        if (random >= 0 && random < 0.5) {
            return "Le joueur qui commence est : " + joueur1;
        }
        return "Le joueur qui commence est " + joueur2;
    }

    public static void tourJoueur1() {
        
    }

    public static void tourJoueur2() {

    }

    public void tourJeu() {
        if (tirageAuSort() == joueur1) {
            while (plateau.partieNulle() == false || plateau.partieGagne() == false) {
                tourJoueur1();
                tourJoueur2();
            }
        }
        else {
            while (plateau.partieNulle() == false || plateau.partieGagne() == false) {
                tourJoueur2();
                tourJoueur1();
            }
        }
    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.reglesJeu();
        jeu.bienvenue();
        System.out.println(jeu.getPlateau());
    }
}
