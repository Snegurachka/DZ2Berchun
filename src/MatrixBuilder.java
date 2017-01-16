import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by elena on 11.01.17.
 */
public class MatrixBuilder {
    private List<Point> points;
    private List<FixedAxis> fixed;
    private int size;



    public MatrixBuilder(List<Point> points, List<FixedAxis> fixed) {
        this.points = points;
        this.fixed = fixed;
        size = points.size() * 2 + fixed.size();
    }

    public void printA(List<List<Double>> matrixA){
        for(int i = 0; i < matrixA.size(); i++){
            for(int k = 0; k < matrixA.get(0).size(); k++){
                System.out.print(matrixA.get(i).get(k) + " ");
            }
            System.out.println();
        }
    }
    public void printB(List<Double> matrixB){
        for(int i = 0; i < matrixB.size(); i++){
            System.out.println(matrixB.get(i));
        }
        System.out.println();
    }

    public List<List<Double>> createA() {

        List<List<Double>> matrixA = new ArrayList<>();
        for(int i = 0; i < size; i++){
            List<Double> tempMatrix = new ArrayList<>();
            for(int k = 0; k < size; k++){
                tempMatrix.add(0.0);
            }
            matrixA.add(tempMatrix);
        }

        for (int i = 0; i < points.size() * 2; i++ ){
            for (int k = 0; k < points.size() * 2; k++){
                if(i == k){
                    matrixA.get(i).set(k, 2.0);
                }

            }
        }

        for(int i = 0; i < fixed.size(); i++) {
            int id = fixed.get(i).getPoint().getId();
            if (fixed.get(i).isCoordinate()){
                matrixA.get(id * 2).set(points.size() * 2 + i, -1.0);
                matrixA.get(points.size() * 2 + i).set(id * 2, 1.0);
            } else {
                matrixA.get(id * 2 + 1).set(points.size() * 2 + i, -1.0);
                matrixA.get(points.size() * 2 + i).set(id * 2 + 1, 1.0);
            }
        }

        printA(matrixA);
        return matrixA;
    }

    public List<Double> createB() {
        List<Double> matrixB = new ArrayList<>();
        for(int i = 0; i < size; i++){
            matrixB.add(0.0);
        }

        for( int i = 0; i < points.size(); i++){
            int id = points.get(i).getId();
            matrixB.set(id * 2, 2 * points.get(i).getX());
            matrixB.set(id * 2 + 1, 2 * points.get(i).getY());
        }

        for (int i = 0; i < fixed.size(); i++){
            int id = fixed.get(i).getPoint().getId();
            matrixB.set(points.size()*2 + i, fixed.get(i).getValue());
        }

        printB(matrixB);

        return matrixB;
    }

}
