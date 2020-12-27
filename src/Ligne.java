
import java.util.*;

public class Ligne extends Forme {
    private ArrayList < ArrayList < String >> tableau;
    public Ligne(int x1, int y1, int x2, int y2, ArrayList < ArrayList < String >> a, String car) {
        int nextX = 0;
        int nextY = 0;
        double m = 0;
        int b = 0;
        // PREMIER CAS DANS L'ENONCE DU DEVOIR delta X >delta Y
        if ((Math.abs(x2 - x1) > Math.abs(y2 - y1))) {

            m = (double)(y2 - y1) / (double)(x2 - x1);
            b = y1;
            a.get(y1).set(x1, car); // POINT INITIAL
            a.get(y2).set(x2, car); // POINT FINAL

            // ON DECREMENT LA BOUCLE
            if (x1 > x2) {

                for (int i = x1; i != x2; i--) {

                    nextY = (int) Math.round((m * (i - x1) + b));
                    if (nextY >= a.size()) {
                        break;
                    }
                    if (i >= a.size()) {
                        break;
                    }
                    a.get(nextY).set(i, car);

                }

            } else {
                // ON INCREMENT LA BOUCLE
                for (int i = x1; i != x2; i++) {

                    nextY = (int) Math.round((m * (i - x1) + b));
                    if (nextY >= a.size()) {
                        break;
                    }
                    if (i >= a.size()) {
                        break;
                    }
                    a.get(nextY).set(i, car);

                }
            }


        }

        // DEUXIEME CAS DANS L'ENONCE delta Y >delta X
        if ((Math.abs(x2 - x1) <= Math.abs(y2 - y1))) {


            m = (double)(x2 - x1) / (double)(y2 - y1);

            b = x1;
            a.get(y1).set(x1, car);
            a.get(y2).set(x2, car);
            if (y1 > y2) {

                for (int i = x1; i > 0; i--) {

                    nextX = (int) Math.round((m * (i - y1) + b));

                    a.get(i).set(nextX, car);

                }

            } else {

                for (int i = y1; i < y2; i++) {

                    if (nextX > a.get(0).size()) {
                        break;
                    }
                    nextX = (int) Math.round((m * (i - y1) + b));

                    a.get(i).set(nextX, car);



                }
            }


        }
        this.tableau = a;

    }
    public ArrayList < ArrayList < String >> retLine() {
        return this.tableau;
    }

}