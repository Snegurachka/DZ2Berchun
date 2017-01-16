import org.omg.PortableServer.POA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elena on 16.01.17.
 */
public class SquareDiff {
    private List<Double> points = new ArrayList<>();

    public List<Double> getPoints(){
        return points;
    }

    public SquareDiff(List<Point> points) {
        for (int i = 0; i < points.size(); i++) {
            this.points.add(points.get(i).getX());
            this.points.add(points.get(i).getY());
        }
    }
    //(xi - x0i)^2

    public Double diff(Var var, Source source) {
        if (var.getX() == true){
            return (2 * (source.getMassX().get(var.id) -  points.get(var.id)));
        } else {
            return 0.0;
        }
    }

    public Double diff(Var var1, Var var2, Source source){
        if(var1.getX() == true){
            if(var1.id == var2.id){
                return 2.0;
            } else {
                return 0.0;
            }
        } else {
            return 0.0;
        }

    }


}

