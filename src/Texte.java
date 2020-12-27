import java.util.ArrayList;

public class Texte {
    private ArrayList < ArrayList < String >> surCarac;
    private ArrayList < ArrayList < String >> newSurface;
    /**
     * CONSTRUCTEUR QUI PREND EN ENTREE UN CARACTER DEFINIE
     * DANS MAIN.
     * */
    public Texte(ArrayList < ArrayList < String >> caracter) {

        this.surCarac = caracter;

    }
    /**
     * Setteur du caracter dans la grille
     *
     * */


    public void writter(int x, int y, ArrayList < ArrayList < String >> origSurf) {

        /**
         *maintenant copions le caractere a sa place dans la copie
         *
         * */

        for (int i = y; i < surCarac.size() + y; i++) {
            for (int j = x; j < surCarac.get(0).size() + x; j++) {

                String Carac = surCarac.get(i - y).get(j - x);
                origSurf.get(i).set(j, Carac);

            }
        }

    }
}