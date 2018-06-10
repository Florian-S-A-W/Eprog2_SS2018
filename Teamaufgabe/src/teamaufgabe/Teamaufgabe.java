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

        Quadtree quadtree = new Quadtree(new Rectangle(new Point(-25000.0, -25000.0), new Size(50000, 50000)));
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

            System.out.println("If not stated otherwise, time is given in mikroseconds");
            System.out.println("Read data" + ", time [ms]:" + timer/1000000);
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

                timer = java.lang.System.nanoTime();
                trainstations = specificTypeInCircle(pointsArray, center, radius, "TRAINSTATION").size();
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

                timer = java.lang.System.nanoTime();
                int airportsFound = quadtree.trainstationsNearAirports(radius, number);
                timer = java.lang.System.nanoTime() - timer;

                System.out.println(airportsFound + ", Quadtree search time [ms]: " + timer/1000000);

                timer = java.lang.System.nanoTime();
                airportsFound = trainstationsNearAirports(pointsArray, radius, number);
                timer = java.lang.System.nanoTime() - timer;

                System.out.println(airportsFound + ", Naive search time [ms]: " + timer/1000000);




            } else {
                System.out.println("Invalid input");
            }

        } catch(FileNotFoundException e) {
            // junctions.csv wurde nicht gefunden
            System.exit(1);
        }

    }

    /**
     * Naive implementation to find all points of a given arraylist of points
     * in a given circle.
     *
     * @param points The arraylist of points that is searched
     * @param point The center of the circle that is searched
     * @param radius The radius of the circle
     * @return A list of all points in the circle.
     */
    public static ArrayList<Point> naivePointsInCircle(ArrayList<Point> points, Point point, double radius) {

        ArrayList<Point> matchingPoints = new ArrayList<Point>();

        for (Point origin: points) {
            if (origin.distanceTo(point) <= radius) {
                matchingPoints.add(origin);
            }
        }
        return matchingPoints;
    }

    /**
     * Naive implementation to find all points of a specific given type in
     * a circle in a given arraylist of points.
     *
     * @param points the given ArrayList of Points
     * @param point the center of the circle searched
     * @param radius the radius of the circle searched
     * @param type the type of junction that is searched for
     * @return an ArrayList of all points that match the requirements
     */
    public static ArrayList<Point> specificTypeInCircle(ArrayList<Point> points, Point point, double radius, String type) {
        points = naivePointsInCircle(points, point, radius);
        ArrayList<Point> typeMatch = new ArrayList<>();
        for (Point listPoint: points) {
            if (listPoint.getType().equals(type)) {
                typeMatch.add(listPoint);
            }
        }
        return typeMatch;
    }

    /**
     * Naive implementation to find all airports that are near a given number of trainstations
     * in a given circle around the airport, by finding all airports, and
     * then traversing through them in a given arraylist of points.
     *
     * @param points the given Points ArrayList
     * @param radius  the radius in which the trainstations can lie
     * @param number the number of trainstations required in the specified area
     * @return the number of airports in the given arraylist that fit the specification
     */
    public static int trainstationsNearAirports(ArrayList<Point> points, double radius, int number) {
        ArrayList<Point> airports = specificTypeInCircle(points, new Point(0.0,0.0), 35000.0, "AIRPORT");
        int counter = 0;
        for (Point airport: airports) {
            if(specificTypeInCircle(points, airport, radius, "TRAINSTATION").size() >= number) {
                counter++;
            };
        }
        return counter;
    }
}
