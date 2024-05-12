package Tetrago;

public class Quartier {
    private int[][] quartier;

    public Quartier(int chiffre1, int chiffre2, int chiffre3, int chiffre4) {
        this.quartier = new int[2][2];
    }

    /**
     * 
     * @param x connaitre l'emplacement du quartier selon la ligne
     * @param y connaitre l'emplacement du quartier selon la colonne
     * @return la donnee d'un quartier selon la ligne et la colonne
     */
    public int getCase(int x, int y) {
        int chiffre = quartier[x][y];
        return chiffre;
    }

    /**
     * 
     * @param x    connaitre l'emplacement du quartier selon la ligne
     * @param y    connaitre l'emplacement du quartier selon la colonne
     * @param pion valeur du pion a jouer selon le joueur
     */
    public void setCase(int x, int y, int pion) {
        quartier[x][y] = pion;
    }

    /**
     * permet la rotation des valeurs dans le sens anti-horaire
     * du quartier
     */

    public void rotation() {

        int premierIndice = quartier[0][0];
        int secondIndice = quartier[0][1];
        int troisiemeIndice = quartier[1][0];
        int quatriemeIndice = quartier[1][1];

        quartier[0][0] = secondIndice;
        quartier[0][1] = quatriemeIndice;
        quartier[1][0] = premierIndice;
        quartier[1][1] = troisiemeIndice;
    }

    /**
     * permet de retourner les differentes valeurs d'une ligne
     * 
     * @param ligne indice de la ligne souhaitee
     */

    public void ligneQuartier(int ligne) {
        for (int i = 0; i < quartier[ligne].length; i++) {
            System.out.print(quartier[ligne][i]);
        }
    }

    /**
     * verifie si le quartier est complet.
     * verifie si toutes les valeurs d'un quartier sont
     * differentes de 0
     * 
     * @return vrai si le quartier est complet
     */

    public boolean quartierComplet() {
        int verificationComplet = 0;
        for (int i = 0; i < quartier.length; i++) {
            for (int j = 0; j < quartier[i].length; j++) {
                if (quartier[i][j] != 0) {
                    verificationComplet++;
                }
            }
        }
        if (verificationComplet == 4) {
            return true;
        }
        return false;
    }

    /**
     * @return vrai si la premiere ligne d'un quartier a des valeurs similaires
     */
    public boolean horizontale1() {
        if (quartier[0][0] != 0 && quartier[0][0] == quartier[0][1]) {
            return true;
        }
        return false;
    }

    /**
     * @return vrai si la deuxieme ligne d'un quartier a des valeurs similaires
     */
    public boolean horizontale2() {
        if (quartier[1][0] != 0 && quartier[1][0] == quartier[1][1]) {
            return true;
        }
        return false;
    }

    /**
     * @return vrai si la premiere colonne d'un quartier a des valeurs similaires
     */
    public boolean verticale1() {
        if (quartier[0][0] != 0 && quartier[0][0] == quartier[1][0]) {
            return true;
        }
        return false;
    }

    /**
     * @return vrai si la deuxieme colonne d'un quartier a des valeurs similaires
     */
    public boolean verticale2() {
        if (quartier[0][1] != 0 && quartier[0][1] == quartier[1][1]) {
            return true;
        }
        return false;
    }

    /**
     * @return vrai si la diagonale commencant par la gauche a des valeurs
     *         similaires
     */
    public boolean diagonaleG() {
        if (quartier[0][0] != 0 && quartier[0][0] == quartier[1][1]) {
            return true;
        }
        return false;
    }

    /**
     * @return vrai si la diagonale commencant par la droite a des valeurs
     *         similaires
     */
    public boolean diagonaleD() {
        if (quartier[0][1] != 0 && quartier[0][1] == quartier[1][0]) {
            return true;
        }
        return false;
    }

    /*
     * affichage d'un quartier
     */
    @Override
    public String toString() {
        String resultat = "";
        for (int i = 0; i < quartier.length; i++) {
            for (int j = 0; j < quartier[i].length; j++) {
                resultat += quartier[i][j];
                /**
                 * toDo : retour chariot en moins
                 */
            }
            resultat += "\n";
        }
        return resultat;
    }
}
