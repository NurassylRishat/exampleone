package models;
public class Point {
    //creating two points
    private double x;
    private double y;
    public Point(double x, double y){
        this.x=x;
        this.y=y;

    }
    public double distanceTo(Point anotherPoint){
        //calculating with distance between two coordinats formula
        double s;
        s=Math.sqrt((anotherPoint.x - this.x)*(anotherPoint.x - this.x)+(anotherPoint.y-this.y)*(anotherPoint.y-this.y));
        return s;

    }

    @Override
    public String toString() {
        //output of x and y coordinates
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

