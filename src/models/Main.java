package models;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;



        public class Main {

            public static void main(String[] args) throws FileNotFoundException {
                File file = new File("C:\\Users\\risha_ciz985v\\IdeaProjects\\from scratch\\src\\source.txt");
                Scanner read = new Scanner(file);
                Shape shape = new Shape();

                while (read.hasNext()) { //reading two coordinates, points
                    String adress = read.next();
                    String[] onlyXandY = adress.split(",");

                    double x = Double.parseDouble(onlyXandY[0]);
                    double y = Double.parseDouble(onlyXandY[1]);


                    Point point = new Point(x , y);
                    shape.addPoint(point);
                }
                System.out.println("P="+shape.perimeter());
                System.out.println("Lobgest side="+shape.getLongestSide());
                System.out.println("Average side"+shape.getAverageSide());
            }
        }

