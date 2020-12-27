import java.util.*;

public class Surface {
    private ArrayList < ArrayList < String >> tmpo = new ArrayList < > ();
    /**
     * CONSTRUCTEUR DE LA SURFACE
     * @param hauteur determine l'hauteur de la surface
     * @param largeur determine la surface
     * */

    public Surface(int hauteur, int largeur) {

        ArrayList < ArrayList < String >> tmp = new ArrayList < > ();
        for (int i = 0; i < hauteur; i++) {
            tmp.add(new ArrayList < > ());
            for (int j = 0; j < largeur; j++) {
                tmp.get(i).add(" ");
            }

        }
        this.tmpo = tmp;

    }
    /**
     * GETTER DE LA SURFACE
     * */

    public ArrayList < ArrayList < String >> getSurface() {
        ArrayList < ArrayList < String >> tmp = new ArrayList < > ();
        tmp = tmpo;
        return tmp;
    }

    /**
     * PERMET DE RENVERSER LA SURFACE
     * */

    public void renverser() {
        Collections.reverse(this.tmpo);
    }

    public void dessiner() {
        String concat = "";
        for (int i = 0; i < tmpo.size(); i++) {
            concat = "";
            for (int j = 0; j < tmpo.get(0).size(); j++) {
                concat += tmpo.get(i).get(j);

            }
            System.out.println(concat);
        }



    }

}