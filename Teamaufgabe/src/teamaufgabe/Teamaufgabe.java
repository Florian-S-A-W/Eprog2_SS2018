package teamaufgabe;

import teamaufgabe.quadtree.Point;
import teamaufgabe.quadtree.Quadtree;
import teamaufgabe.quadtree.Rectangle;
import teamaufgabe.quadtree.Size;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Teamaufgabe {

    public static void main (String[] args) {

        Quadtree quadtree = new Quadtree(new Rectangle(new Point(0, 0, "zero", "Koordinatenursprung"), new Size(10000, 10000)));

        try(Scanner s = new Scanner(
                new File(System.getProperty("user.dir") +
                        "/data/junctions.csv"), "UTF-8")) {
            s.useDelimiter(";|\\n");
            while(s.hasNextLine()){
                if (s.hasNext()) {
                    String name = s.next();
                    double x = Double.valueOf(s.next());
                    double y = Double.valueOf(s.next());
                    String type = s.next();
                    Point newLocation = new Point(x, y, name, type);
                    quadtree.add(newLocation);
                } else {
                    break;
                }
            }

            System.out.println("Daten eingelesen");
            Rectangle rect = new Rectangle(new Point(0.0, 0.0), new Size(100.0, 200.0));
            ArrayList<Point> pointsInRect = quadtree.points(rect);
            System.out.println(pointsInRect);
            rect = new Rectangle(new Point(5000.0, 5000.0), new Size(5000.0, 5000.0));
            pointsInRect = quadtree.points(rect);
            System.out.println(pointsInRect);
            pointsInRect = quadtree.pointsInCircle(new Point(5000.0, 5000.0), 5000.0);
            System.out.println(pointsInRect);
            pointsInRect = quadtree.specificTypeInCircle(new Point(5000.0, 5000.0), 5000.0, "TRAINSTATION");
            System.out.println(pointsInRect);

        } catch(FileNotFoundException e) {
            // junctions.csv wurde nicht gefunden
            System.exit(1);
        }

    }
}
