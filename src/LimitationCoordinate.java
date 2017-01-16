import java.util.ArrayList;
import java.util.List;

/**
 * Created by elena on 16.01.17.
 */
public class LimitationCoordinate {
    private List<Double> points = new ArrayList<>();

    public List<Double> getPoints(){
        return points;
    }

    private  List<FixedAxis> fixed;



    public LimitationCoordinate(List<FixedAxis> fixed){
        this.fixed = fixed;
    }


    //lambda1 * (b1 - x1)

    public Double diff(Var var, Source source) {
        if (var.getX() == true){

            return ((-1) * (source.getMassLambda().get(var.getId())));
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
