package Tetrago;

public class Main {
    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.reglesJeu();
        jeu.bienvenue();
        System.out.println();
        System.out.println(jeu.getPlateau());
        System.out.println();
        jeu.tourJeu();

    }
}



