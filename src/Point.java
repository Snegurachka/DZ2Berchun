/**
 * Created by elena on 11.01.17.
 */
public class Point {
    private int id;
    private Double X;
    private Double Y;

    public  int getId() { return id; }

    public Double getX() {
        return X;
    }

    public Double getY() {
        return Y;
    }

    public Point(int id, Double X, Double Y){
        this.id = id;
        this.X = X;
        this.Y = Y;
    }
}
