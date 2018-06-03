package teamaufgabe;

import teamaufgabe.quadtree.Point;
import teamaufgabe.quadtree.Quadtree;
import teamaufgabe.quadtree.Rectangle;
import teamaufgabe.quadtree.Size;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Teamaufgabe {

    public static void main (String[] args) {

        Quadtree quadtree = new Quadtree(new Rectangle(new Point(-15000.0, -15000.0, "zero", "Koordinatenursprung"), new Size(30000, 30000)));
        ArrayList<Point> pointsArray = new ArrayList<Point>();
        long timer = java.lang.System.nanoTime();

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
                    pointsArray.add(newLocation);
                } else {
                    break;
                }
            }


            timer = java.lang.System.nanoTime() - timer;

            System.out.println("Daten eingelesen" + ", time [ms]:" + timer/1000000);
            timer = java.lang.System.nanoTime();

            Scanner reader = new Scanner(System.in);
            System.out.println("Please enter your request");

            String input = reader.nextLine();

            if (input.startsWith("Junctions less than ")) {

                input = input.replace("Junctions less than ", "");
                input = input.replace("units from ", "");

                String[] parts = input.split(" ");
                double radius = Double.parseDouble(parts[0]);
                parts[1] = parts[1].replace("x=", "");
                parts[2] = parts[2].replace("y=", "");

                Point center = new Point(Double.parseDouble(parts[1]),Double.parseDouble(parts[2]));

                timer = java.lang.System.nanoTime();
                int trainstations = quadtree.specificTypeInCircle(center, radius, "TRAINSTATION").size();
                int airports = quadtree.specificTypeInCircle(center, radius, "AIRPORT").size();
                timer = java.lang.System.nanoTime() - timer;

                System.out.println("Airports: " + airports + " Trainstations: " + trainstations + " Quadtree search time: " + timer/1000);

                System.out.println(pointsArray.size());
                timer = java.lang.System.nanoTime();
                trainstations = specificTypeInCircle(pointsArray, center, radius, "TRAINSTATION").size();
                System.out.println(trainstations);
                airports = specificTypeInCircle(pointsArray, center, radius, "AIRPORT").size();
                timer = java.lang.System.nanoTime() - timer;

                System.out.println("Airports: " + airports + " Trainstations: " + trainstations + " Naive search time: " + timer/1000);



            } else if (input.startsWith("Airports with at least ")) {

                input = input.replace("Airports with at least ", "");
                input = input.replace(" Trainstations less than", "");
                input = input.replace(" units away", "");

                String[] parts = input.split(" ");

                int number = Integer.parseInt(parts[0]);
                double radius = Double.parseDouble(parts[1]);

                int airportsFound = trainstationsNearAirports(pointsArray, radius, number);

                System.out.println(airportsFound);



            } else {
                System.out.println("Invalid input");
            }

        } catch(FileNotFoundException e) {
            // junctions.csv wurde nicht gefunden
            System.exit(1);
        }

    }

    public static ArrayList<Point> naivePointsInCircle(ArrayList<Point> points, Point point, double radius) {

        ArrayList<Point> matchingPoints = new ArrayList<Point>();

        for (Point origin: points) {
            if (origin.distanceTo(point) <= radius) {
                matchingPoints.add(origin);
            }
        }
        return matchingPoints;
    }

    public static ArrayList<Point> specificTypeInCircle(ArrayList<Point> points, Point point, double radius, String type) {
        points = naivePointsInCircle(points, point, radius);
        System.out.println(points.toString());
        ArrayList<Point> typeMatch = new ArrayList<>();
        for (Point listPoint: points) {
            if (listPoint.getType().equals(type)) {
                typeMatch.add(listPoint);
            }
        }
        return typeMatch;
    }

    public static int trainstationsNearAirports(ArrayList<Point> points, double radius, int number) {
        ArrayList<Point> airports = specificTypeInCircle(points, new Point(0.0,0.0), 25000.0, "AIRPORT");
        int counter = 0;
        System.out.println(airports.toString());
        for (Point airport: airports) {
            if(specificTypeInCircle(points, airport, radius, "TRAINSTATION").size() >= number) {
                counter++;
                System.out.println(counter);
            };
        }
        return counter;
    }
}
