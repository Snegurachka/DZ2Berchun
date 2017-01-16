import java.util.ArrayList;
import java.util.List;

/**
 * Created by elena on 15.01.17.
 */
public class Newton {
    private List<Point> points;
    private List<FixedAxis> fixed;
    private Source source;
    private List<Double> x0MassX;
    private List<Double> x0MassLambda;


    public Newton(List<Point> points, List<FixedAxis> fixed){
        this.points = points;
        this.fixed = fixed;
        source = new Source(points, fixed);
        x0MassX = source.getMassX();
        x0MassLambda = source.getMassLambda();

    }


    public void solve(){

        MatrixBuilder builder = new MatrixBuilder(points, fixed);
        List<Double> bVector;


        do {
            List<List<Double>> aMatrix = builder.createA();// добавить с приближением
            bVector = builder.createB();
            Gauss gauss = new Gauss(aMatrix, bVector);
            gauss.solve();
            bVector = gauss.getMatrixB();
            source.setNewVector(bVector);
            x0MassX = source.getMassX();
            x0MassLambda = source.getMassLambda();
        } while (!chekIfEnd(bVector));
    }

    private Boolean chekIfEnd(List<Double> delta) {
        Boolean result = true;
        for (int i = 0; i < delta.size() && result; ++i) {
            if (Math.abs(delta.get(i)) >= 0.001) {
                result = false;
            }
        }
        return result;
    }



}
