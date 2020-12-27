import java.lang.reflect.Array;
import java.util.*;

public class Caracter extends Forme {
    private ArrayList < ArrayList < String >> Table;
    private ArrayList < ArrayList < String >> surCopy = new ArrayList < > ();
    private ArrayList < ArrayList < String >> tabByte1 = new ArrayList < > ();
    private ArrayList < ArrayList < String >> drawCar = new ArrayList < > ();

    /**
     * CONSTRUCTEUR DU CARACTER
     * @param txt caracter a faire
     * @param Tablero surface actuelle
     * @param letra caracter de dessin
     * */

    public Caracter(String txt, ArrayList < ArrayList < String >> Tablero, String letra) {
        Table = Tablero; // surface
        /**
         * RETOURNE LE PATTERN SELON LE FICHIER POLICE 8X12
         * */


        char localValue = txt.charAt(0);

        byte[] Byte = Police8x12.getImage(localValue);

        String localInt = "";

        tabByte1.add(new ArrayList < > ());

        for (int j = 0; j < Byte.length; j++) {


            int localByte = Byte[j];

            localInt = Integer.toBinaryString(localByte);
            int localSize = localInt.length();
            if (localSize < 8) {

                for (int k = 0; k < 8 - localSize; k++) {

                    localInt = "0" + localInt;

                }

            }

            tabByte1.get(0).add(j, (localInt));
        }

        // }
        /**
         * Copions faison une copie de la surface
         *
         * */
        for (int i = 0; i < 11; i++) {
            drawCar.add(new ArrayList < > ());
            for (int j = 0; j < 8 * txt.length(); j++) {
                String localElement = Table.get(i).get(j);

                drawCar.get(i).add(j, localElement);

            }


        }

        /**
         * FAIT UNE COPIE DE LA SURFACE DE TAILLE 8X12
         *
         *
         * */
        for (int i = 0; i < 11; i++) {
            surCopy.add(new ArrayList < > ());
            for (int j = 0; j < 8 * txt.length(); j++) {
                String localElement = drawCar.get(i).get(j);

                surCopy.get(i).add(j, localElement);

            }


        }

        /**
         * REECRITURE DE LA SURFACE COPIEE
         *
         * */


        for (int i = 0; i < tabByte1.size(); i++) {

            char localCar = ' ';

            for (int j = 0; j < tabByte1.get(0).size(); j++) {


                String localString = tabByte1.get(i).get(j); // PATTERN A COPIER

                for (int k = 0; k < localString.length(); k++) // ON CHERCHE DANS LE PATTERN OU COPIER

                {

                    localCar = localString.charAt(k);


                    if (localCar == '1') {
                        // COPIER

                        surCopy.get(j).set(k, letra);


                    }

                }

            }
        }

    }
    /***
     * Setter des characters
     * @param x coordonee en X
     * @param y coordonee en Y
     * @param grid surface pour fixer le caractere
     * */

    public void putOn(int x, int y, ArrayList < ArrayList < String >> grid) {


        for (int i = y; i < surCopy.size() + y; i++) {


            for (int j = x; j < surCopy.get(0).size() + x; j++) {


                String Carac = surCopy.get(i - y).get(j - x);
                grid.get(i).set(j, Carac);


            }

        }
    }
    /***
     * Getter des characters
     * */
    public ArrayList < ArrayList < String >> getC() {

        return this.surCopy;

    }


}

