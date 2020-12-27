import java.lang.reflect.Array;
import java.util.*;
public class Tp1 {
    public static void main(String[] args) {
        boolean test = true;
        int count = 0;
        boolean rectangleTest = false;
        boolean surfaceTest = false;
        int param = 0;
        int param2 = 0;
        int param3 = 0;
        int param4 = 0;
        String car = " ";
        ArrayList < ArrayList < String >> regTab = null;
        Rectangle rectangulo = null;
        Ligne ligne = null;
        ArrayList < ArrayList < String >> recTab;
        Surface registrer = new Surface(0, 0);

        Scanner prg = new Scanner(System.in);

        do {
            String read = prg.nextLine();

            if (read.equalsIgnoreCase("fin"))
                break;

            String[] tabRead = read.split(" ");
            if (tabRead[0].equalsIgnoreCase("init")) {
                int hauteur = Integer.parseInt(tabRead[2]);
                int longueur = Integer.parseInt(tabRead[1]);
                registrer = new Surface(hauteur, longueur);
                surfaceTest = true;

            }
            if (tabRead[0].equalsIgnoreCase("car")) {

                car = tabRead[1];

            }

            if (tabRead[0].equalsIgnoreCase("dessiner")) {
                registrer.dessiner();

            }
            if (tabRead[0].equalsIgnoreCase("renverser")) {
                registrer.renverser();

            }

            if (tabRead[0].equalsIgnoreCase("ajouter")) {
                if (surfaceTest == false) {
                    System.out.println("ERREUR: Aucune surface définie");
                } else {
                    if (car.equals(" "))
                        car = "#";
                    if (tabRead[1].equalsIgnoreCase("rectangle")) {

                        param = Integer.parseInt(tabRead[2]);
                        param2 = Integer.parseInt(tabRead[3]);
                        param3 = Integer.parseInt(tabRead[4]);
                        param4 = Integer.parseInt(tabRead[5]);

                        rectangulo = new Rectangle(param4, param3);
                        rectangulo.car(car);
                        regTab = registrer.getSurface();
                        rectangulo.draw(param2, param, regTab);
                        rectangleTest = true;

                    }
                    if (tabRead[1].equalsIgnoreCase("carre")) {
                        param = Integer.parseInt(tabRead[2]);
                        param2 = Integer.parseInt(tabRead[3]);
                        param3 = Integer.parseInt(tabRead[4]);

                        rectangulo = new Rectangle(param3, param3);
                        rectangulo.car(car);
                        regTab = registrer.getSurface();
                        rectangulo.draw(param, param2, regTab);

                    }
                    if (tabRead[1].equalsIgnoreCase("ligne")) {

                        param = Integer.parseInt(tabRead[2]);
                        param2 = Integer.parseInt(tabRead[3]);
                        param3 = Integer.parseInt(tabRead[4]);
                        param4 = Integer.parseInt(tabRead[5]);
                        regTab = registrer.getSurface();
                        ligne = new Ligne(param, param2, param3, param4, regTab, car);


                    }
                    if (tabRead[1].equalsIgnoreCase("lettre")) {
                        param = Integer.parseInt(tabRead[2]);
                        param2 = Integer.parseInt(tabRead[3]);
                        String parame = tabRead[4];
                        String[] paraTab = parame.split("");
                        regTab = registrer.getSurface();
                        ArrayList < ArrayList < String >> copyS = regTab;
                        Caracter texte = new Caracter(paraTab[0], copyS, car);
                        texte.putOn(param, param2, regTab);


                    }
                    if (tabRead[1].equalsIgnoreCase("texte")) {

                        param = Integer.parseInt(tabRead[2]);
                        param2 = Integer.parseInt(tabRead[3]);
                        String parame = tabRead[4];
                        String[] mmm = tabRead[4].split("");
                        regTab = registrer.getSurface();
                        Rectangle recS = new Rectangle(12, 12);
                        String localCa = regTab.get(0).get(0);
                        recS.car(localCa);
                        ArrayList < ArrayList < String >> copyS = recS.getRectangle();


                        for (int i = 0; i < mmm.length; i++) {


                            String[] tempoString = mmm[i].split("");
                            Caracter tempoCat = new Caracter(tempoString[0], copyS, car);
                            ArrayList < ArrayList < String >> localC = tempoCat.getC();
                            Texte tx = new Texte(localC);
                            tx.writter(param, param2, regTab);

                            param += 7;


                        }

                    }
                    if (tabRead[1].equalsIgnoreCase("cercle")) {
                        param = Integer.parseInt(tabRead[2]);
                        param2 = Integer.parseInt(tabRead[3]);
                        param3 = Integer.parseInt(tabRead[4]);
                        regTab = registrer.getSurface();
                        Cercle Circulo = new Cercle(param, param2, param3);
                        Circulo.draw(regTab, car);
                    }
                    if (tabRead[0].equalsIgnoreCase("brasser")) {

                    }
                }
            }



        } while (prg.hasNext());
    }
}