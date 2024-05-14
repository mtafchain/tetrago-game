package Tetrago;

import java.util.Random;

/*
 * On souhaite pouvoir jouer contre un ordinateur
 * On demande à l'utilisateur si il veut jouer contre l'ordinateur
 * L'ordinateur appliquera l'algorithme de Minimax 
 * Le but étant que l'ordinateur joue sur n'importe quelle case inoccupée du plateau
 * L'ordinateur ne sera pas très intelligent mais appliquera les règles du jeu
 * Cette méthode d'intelligence artificiel ne sera pas très intéressant puisque en fin de partie,
 * le calcul afin de trouver une case inoccupée du plateau sera très long
 */

public class Ordinateur {

    private int entierAleatoire;
    private int entierAleatoire2;

    public Ordinateur() {
        Random random = new Random();
        entierAleatoire = random.nextInt(3);
        entierAleatoire2 = random.nextInt(3);
    }
    public int getEntierAleatoire() {
        return entierAleatoire;
    }
    public int getEntierAleatoire2() {
        return entierAleatoire2;
    }
    @Override
    public String toString() {
        return "entier 1 : " + getEntierAleatoire() + " entier 2 : " + getEntierAleatoire2();
    }
}
