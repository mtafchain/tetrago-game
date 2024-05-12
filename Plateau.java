package Tetrago;

public class Plateau {
    public Quartier[][] plateau;

    public Plateau() {

        plateau = new Quartier[2][2];
        plateau[0][0] = new Quartier(0, 0, 0, 0);
        plateau[0][1] = new Quartier(0, 0, 0, 0);
        plateau[1][0] = new Quartier(0, 0, 0, 0);
        plateau[1][1] = new Quartier(0, 0, 0, 0);

    }
    /**
     * 
     * @param a connaitre le placement d'un quartier du plateau selon la ligne
     * @param b connaitre le placement d'un quartier du plateau selon la colonne
     * @return le quartier souhaite
     */
    public Quartier getQuartier(int a, int b) {
        return plateau[a][b];
    }

    /**
     * 
     * @param x connaître l'emplacement d'une donnee selon la ligne
     * @param y connaître l'emplacement d'une donnee selon la colonne
     * @return la valeur d'une case en allant la chercher dans le bon quartier
     */
    public int getCase(int x, int y) {
        if ((0 <= x && x < 4) && (0 <= y && y < 4)) {
            int plateauX = x / 2;
            int plateauY = y / 2;

            int quartierX = x % 2;
            int quartierY = y % 2;

            Quartier quartierDemande = plateau[plateauX][plateauY];
            return quartierDemande.getCase(quartierX, quartierY);
        }
        throw new IllegalArgumentException("Ceci est un nombre non compris dans le plateau");
    }

    /**
     * 
     * @param x    connaitre l'emplacement d'une donnee selon la ligne
     * @param y    connaitre l'emplacement d'une donnee selon la colonne
     * @param pion donne la valeur du pion a jouer selon le joueur
     * @return place un pion dans le bon quartier
     */
    public boolean setCase(int x, int y, int pion) {
        if (pion == 1 || pion == 2) {
            if (this.getCase(x, y) != 0) {
                return false;
            } else {
                if ((0 <= x && x < 4) && (0 <= y && y < 4)) {
                    int plateauX = x / 2;
                    int plateauY = y / 2;

                    int quartierX = x % 2;
                    int quartierY = y % 2;

                    Quartier quartierDemande = plateau[plateauX][plateauY];
                    quartierDemande.setCase(quartierX, quartierY, pion);
                }
            }
            return true;
        }
        throw new IllegalArgumentException("Vous ne pouvez pas donner un pion inexistant");
    }

    /**
     * 
     * @param a connaitre l'emplacement du quartier selon la ligne
     * @param b connaitre l'emplacement du quartier selon la colonne
     *          permet la rotation du quartier souhaite
     */

    public void rotationQuartier(int a, int b) {
        if ((a == 0 || a == 1) && (b == 0 || b == 1)) {
            plateau[a][b].rotation();
        }
    }
     /**
     * 
     * @return vérifie si une partie est gagnee.
     *         Une partie est gagnee si quatre billes sont alignees de maniere
     *         horizontale, verticale ou diagonale.
     */
    public boolean partieGagne() {
        if (plateau[0][0].horizontale1() && plateau[0][1].horizontale1()) {
            System.out.println("Vous avez gagné la partie en horizontale");
            return true;
        }
        if (plateau[0][0].horizontale2() && plateau[0][1].horizontale2()) {
            System.out.println("Vous avez gagné la partie en horizontale");
            return true;
        }
        if (plateau[0][0].verticale1() && plateau[1][0].verticale1()) {
            System.out.println("Vous avez gagné la partie en verticale");
            return true;
        }
        if (plateau[0][0].verticale2() && plateau[1][0].verticale2()) {
            System.out.println("Vous avez gagné la partie en verticale");
            return true;
        }
        if (plateau[1][0].diagonaleD() && plateau[0][1].diagonaleD()) {
            System.out.println("Vous avez gagné la partie en diagonale");
            return true;
        }
        if (plateau[0][0].diagonaleG() && plateau[1][1].diagonaleG()) {
            System.out.println("Vous avez gagné la partie en diagonale");
            return true;
        }
        return false;
    }
    public boolean partieNulle() {
        if (plateau[0][0].quartierComplet() == true && plateau[0][1].quartierComplet() == true && plateau[1][0].quartierComplet() == true && plateau[1][1].quartierComplet() == true) {
            return true;
        }
        return false;
    }
    /**
     * affichage du plateau
     */
    public String toString() {

        plateau[0][0].ligneQuartier(0);// faire une boucle
        System.out.print(" ");
        plateau[0][1].ligneQuartier(0);
        System.out.println();
        plateau[0][0].ligneQuartier(1);
        System.out.print(" ");
        plateau[0][1].ligneQuartier(1);
        System.out.println();
        System.out.println();
        plateau[1][0].ligneQuartier(0);
        System.out.print(" ");
        plateau[1][1].ligneQuartier(0);
        System.out.println();
        plateau[1][0].ligneQuartier(1);
        System.out.print(" ");
        plateau[1][1].ligneQuartier(1);

        System.out.println();

        /*
         * for (int i = 0; i < plateau.length; i++) {
         * for (int j = 0; j < plateau[i].length; j++) {
         * plateau[i][j].ligneQuartier(i);
         * System.out.println();
         * }
         * }
         */
        // à changer !

        return "";

    }
    
}
