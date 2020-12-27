import java.util.ArrayList;

public class Cercle extends Forme {
    private ArrayList<String> tracePoint = new ArrayList<>();
    private ArrayList<String> tracePointCopie;
    private int coorX = 0;
    private int coorY = 0;

    /***
     * CONSTRUCTEUR DU CERCLE
     * @param radius longueur du rayon
     * @param radiusX coordonee X du rayon
     * @param radiusY coordonee Y du rayon
     * */


    public Cercle(int radiusX, int radiusY, int radius ){

        int x = -1;
        int y = radius;
        int m = 5 - 4*radius;
        do{
            x++;
            tracePoint.add((x+radiusX)+","+(y+radiusY));
            tracePoint.add((y+radiusX)+","+(x+radiusY));
            tracePoint.add((-x+radiusX)+","+(y+radiusY));
            tracePoint.add((-y+radiusX)+","+(x+radiusY));
            tracePoint.add((x+radiusX)+","+(-y+radiusY));
            tracePoint.add((y+radiusX)+","+(-x+radiusY));
            tracePoint.add((-x+radiusX)+","+(-y+radiusY));
            tracePoint.add((-y+radiusX)+","+(-x+radiusY));

            if(m>0){
                y = y-1;
                m = m -8*y;
            }
            x = x+1;
            m = m + 8*x + 4;

        }while (x<=y);



        this.tracePointCopie = tracePoint;
        this.coorX = radiusX;
        this.coorY = radiusY;




    }
    /**
     * SETTER DU CERCLE
     *
     * */

    public void draw(ArrayList<ArrayList<String>> grid, String car){
        ArrayList<String> localArray = tracePointCopie;

        for(int i = 0; localArray.size()>0; i=0){

            String localString = localArray.get(i);
            String[] localTab = localString.split(",");
            int localInt2 = Integer.parseInt(localTab[i]);
            int localInt0 = Integer.parseInt(localTab[i+1]);


            grid.get(localInt0).set(localInt2,car);

            localArray.remove(i);



        }



    }

}
