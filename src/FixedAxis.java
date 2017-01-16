/**
 * Created by elena on 11.01.17.
 */
public class FixedAxis {

    private Point point;
    private boolean coordinate;
    private Double value;

    public Point getPoint() {
        return point;
    }

    public boolean isCoordinate() {
        return coordinate;
    }

    public Double getValue() {
        return value;
    }

    public FixedAxis(Point point, boolean coordinate, Double value){
        this.point = point;
        this.coordinate = coordinate;
        this.value = value;
    }



}
