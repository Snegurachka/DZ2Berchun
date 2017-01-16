import java.util.ArrayList;
import java.util.List;

/**
 * Created by elena on 11.01.17.
 */
public class Gauss {
    private List<List<Double>> matrixA;
    private List<Double> matrixB;

    public Gauss(List<List<Double>> matrixA, List<Double> matrixB) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
    }

    public void printA(){
        for(int i = 0; i < matrixA.size(); i++){
            for(int k = 0; k < matrixA.get(0).size(); k++){
                System.out.print(matrixA.get(i).get(k) + " ");
            }
            System.out.println();
        }
    }

    public void printB(){
        for(int i = 0; i < matrixA.size(); i++){
            System.out.println(matrixB.get(i));
        }
        System.out.println();
    }

    public void forward() {
        for (int i = 0; i < matrixA.size(); i++) {

//            1 0 0 0
//            0 0 2 0
//            0 1 2 1 Пока пока)
//            0 0 1 0
            Double n = matrixA.get(i).get(i);
            while(n == 0.0){
                List<Double> temp = matrixA.get(i);
                matrixA.remove(i);
                matrixA.add(temp);
                n = matrixA.get(i).get(i);
            }

            for (int k = 0; k < matrixA.get(i).size(); k++){
                matrixA.get(i).set(k, matrixA.get(i).get(k) / n);
            }
            matrixB.set(i, matrixB.get(i) / n);

            for(int k = i + 1; k < matrixA.size(); k++){
                List<Double> temp = new ArrayList<>();
                Double tempN = matrixA.get(k).get(i);
                for (int l = 0; l < matrixA.get(k).size(); l++){
                    temp.add(matrixA.get(i).get(l)*tempN);
                }
                for(int l = 0; l < matrixA.size(); l++){
                    matrixA.get(k).set(l, matrixA.get(k).get(l) - temp.get(l));
                }
                matrixB.set(k, matrixB.get(k) - matrixB.get(i)*tempN);
            }
        }
    }

    public void back() {
        for (int i = matrixA.size() - 1; i >= 0; i--){
            for (int k = i - 1; k >= 0; k--){
                List<Double> temp = new ArrayList<>();
                Double tempN = matrixA.get(k).get(i);
                for (int l = 0; l < matrixA.size(); l++) {
                    temp.add(matrixA.get(i).get(l) * tempN);
                }

                for(int l = 0; l < matrixA.size(); l++){
                    matrixA.get(k).set(l, matrixA.get(k).get(l) - temp.get(l));
                }
                matrixB.set(k, matrixB.get(k) - matrixB.get(i)*tempN);
            }
        }
    }

    public void solve(){
        //прямой ход
        forward();
        // обратный ход
        back();
    }

    public List<Double> getMatrixB() {
        return matrixB;
    }
}
