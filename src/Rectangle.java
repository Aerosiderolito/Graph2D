import java.util.*;

public class Rectangle extends Forme {
    private ArrayList < ArrayList < String >> container = new ArrayList < > ();
    /**
     * CONSTRUCTEUR DU RECTANGLE
     * */

    public Rectangle(int l, int h) {

        ArrayList < ArrayList < String >> tmp = new ArrayList < > ();
        for (int i = 0; i < h; i++) {
            tmp.add(new ArrayList < > ());
            for (int j = 0; j < l; j++) {
                tmp.get(i).add(" ");
            }
        }
        this.container = tmp;
    }
    /**
     * FIX UN CARACTER DANS LE RECTANGLE ACTUEL
     * @param car caracter a ecrire
     * */
    public void car(String car) {
        int hauteur = container.size();
        int largeur = container.get(0).size();
        ArrayList < ArrayList < String >> tmp = new ArrayList < > ();
        for (int i = 0; i < hauteur; i++) {
            tmp.add(new ArrayList < > ());
            for (int j = 0; j < largeur; j++) {
                tmp.get(i).add(car);
            }

        }
        this.container = tmp;

    }
    /**
     * GETTER DU RECTANGLE
     * */
    public ArrayList < ArrayList < String >> getRectangle() {
        return this.container;
    }
    /**
     * SETTER DU RECTANGLE DANS LA GRILLE
     *
     * */
    public void draw(int h, int l, ArrayList < ArrayList < String >> a) {

        int arraySizeLine = a.size();
        int arraySizeSk = a.get(0).size();
        int Container = container.size();
        int Container0 = container.get(0).size();
        String localCar = container.get(0).get(0);


        for (int i = h; i < arraySizeLine; i++) {

            if (i < Container0 + h) {
                for (int j = l; j < arraySizeSk; j++) {
                    if (j < Container + l) {
                        a.get(i).set(j, localCar);

                    }
                }
            }


        }
    }



}