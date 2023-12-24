package models;

import java.util.ArrayList;
public class Shape {
    private ArrayList<Point> points=new ArrayList<>();
    //creating new list for points
    public Shape(){}

    public void addPoint(Point point){
        //add points to the list
        points.add(point);
    }
    public double perimeter(){
        double perimeter=0;
        //calculating perimeter by loop
        for (int i=0; i<points.size()-1;i++){
            Point current=points.get(i);
            Point next=points.get(i+1);
            perimeter += current.distanceTo(next);

        }
        perimeter +=points.get(points.size()-1).distanceTo(points.get(0));
        //returns the perimeters value
        return perimeter;

    }
    public double getAverageSide(){
        return perimeter()/points.size();
    }
    public double getLongestSide(){
        double longest=0;
        //finding longest side with loop
        for (int i=0; i<points.size()-1;i++){
            Point current = points.get(i);
            Point next=points.get(i+1);
            double distance = current.distanceTo(next);
            if (distance>longest){
                longest=distance;
            }


        }
        //finding remain point
        double distance = points.get(points.size()-1).distanceTo(points.get(0));
        if (distance>longest){
            longest=distance;
        }
        return longest;
    }


}
