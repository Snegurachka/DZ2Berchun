import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by elena on 11.01.17.
 */
public class Main {

    public static void main(String[] args) {
        Point pointX1 = new Point(0, 5.0, 7.0);
        Point pointX2 = new Point(1, 9.0, 11.0);
        FixedAxis fixedAxis = new FixedAxis(pointX1, true, 10.0);
        FixedAxis fixedAxis1 = new FixedAxis(pointX1, false, 15.0);
        FixedAxis fixedAxis2 = new FixedAxis(pointX2, false, 20.0);

        List<Point> points = new ArrayList<>();
        points.add(pointX1);
        points.add(pointX2);
        List<FixedAxis> fixed = new ArrayList<>();
        fixed.add(fixedAxis);
        fixed.add(fixedAxis1);
        fixed.add(fixedAxis2);

        Source source = new Source(points, fixed);
        List <Double> xmass = source.getMassX();
        List <Double> lammass = source.getMassLambda();






        MatrixBuilder builder = new MatrixBuilder(points, fixed);

        builder.createMatrixA(source);
        builder.createVectorB(source);

        Gauss gauss = new Gauss(builder.createA(), builder.createB());
        gauss.solve();
        List<Double> matrixB1 = gauss.getMatrixB();
    }
}
