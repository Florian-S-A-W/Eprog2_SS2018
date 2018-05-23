package teamaufgabe;

import teamaufgabe.quadtree.Point;
import teamaufgabe.quadtree.Quadtree;
import teamaufgabe.quadtree.Rectangle;
import teamaufgabe.quadtree.Size;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Teamaufgabe {

    public static void main (String[] args) {

        /*
        try(Scanner s = new Scanner(
                new File(System.getProperty("user.dir") +
                        "/data/junctions.csv"), "UTF-8")) {
            // Benutzen Sie das Scanner-Objekt s hier
            s.useDelimiter(";|\\n");
            int i = 0;
            while(s.hasNextLine() && i < 10){
                System.out.print("Name: " + s.next()+ "|");
                System.out.print("x: " + s.next() + "|");
                System.out.print("y: " + s.next() + "|");
                System.out.print("Type: " + s.next() + "|");
                System.out.print("\n");
                i++;
            }


        } catch(FileNotFoundException e) {
            // junctions.csv wurde nicht gefunden
            System.exit(1);
        }*/

        Quadtree quadtree = new Quadtree(new Rectangle(new Point(0, 0), new Size(1000, 1000)));

        System.out.println(quadtree);

        System.out.println("********");

        for (int i = 0; i < 100; i++) {
            double x = Math.random() * 1000;
            double y = Math.random() * 1000;

            quadtree.add(new Point(x, y));
        }

        System.out.println(quadtree);
    }
}
