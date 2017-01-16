import java.util.ArrayList;
import java.util.List;

/**
 * Created by elena on 16.01.17.
 */

//вектор приближения!!!!
public class Source {
    private List<Double> massX;
    private List<Double> massLambda;

    public Source(List<Point> points, List<FixedAxis> fixed){
        massX = new ArrayList<>();
        massLambda = new ArrayList<>();

        for(int i = 0; i < points.size(); i++){
            massX.add(points.get(i).getX());
            massX.add(points.get(i).getY());
        }
        for(int i = 0; i < fixed.size(); i++){
            massLambda.add(0.0);
        }
    }

    public List<Double> getMassX(){
        return massX;
    }

    public List<Double> getMassLambda(){
        return massLambda;
    }


    // вычисление нового вектора приближения
    public void setNewVector(List<Double> deltaVector){
        for(int i = 0; i < massX.size(); i++){
            massX.set(i, massX.get(i) + deltaVector.get(i));
        }
        for(int i = 0; i < massLambda.size(); i++){
            massLambda.set(i, massLambda.get(i) + deltaVector.get(massX.size() + i));
        }

    }

}
