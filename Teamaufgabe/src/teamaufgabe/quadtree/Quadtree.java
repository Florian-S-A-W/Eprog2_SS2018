package teamaufgabe.quadtree;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * This is an implementation of a point Quadtree.
 * It can be used to save a collection of Point Objects by
 * using the add method and implements functions to find all
 * contained points (of a specific type) in a given circle
 * or rectangle.
 *
 * @author Florian Winkler
 */

public class Quadtree implements PointsContainer {

    private QuadtreeNode root;

    /**
     * Constructor that creates a Quadtree covering the size of a given rectangle.
     *
     * @param rectangle the rectangle that specifies the boundaries of the quadtree.
     */

    public Quadtree(Rectangle rectangle) {
        this.root = new QuadtreeNode(rectangle);
    }

    /**
     * Adds a point to the quadtree by accessing the add methode of the quadtree root.
     * Returns false if the point already is in the tree.
     *
     * @param point the new point added to the tree.
     * @return boolean if the point was added.
     */

    @Override
    public boolean add(Point point) {
        if (root.add(point)) {
            return true;
        } else return false;
    }

    /**
     * Returns an Arraylist of all points in a given rectangle.
     *
     * @param inRectangle the rectangle that is searched for points.
     * @return the list of points in this rectangle
     */

    @Override
    public ArrayList<Point> points(Rectangle inRectangle) {
        return root.points(inRectangle);
    }

    /**
     * Creates a recursive string description of all points in the quadtree.
     *
     * @return a string of all points in the tree
     */

    @Override
    public String toString() {
        return "Quad tree\n" + root.recursiveDescription();
    }

    /**
     *  Creates an arraylist of all points in a given circle by searching the quadtree
     *  for all points in the surrounding rectangle and then checking all points found
     *  for the distance to the center of the circle.
     *
     * @param center the center of the circle
     * @param radius the radius of the circle
     * @return all points in the circle
     */

    public ArrayList<Point> pointsInCircle(Point center, double radius) {
        Point origin = new Point(center.getX() - radius, center.getY() - radius);
        Rectangle circRect = new Rectangle(origin, new Size(2* radius, 2* radius));
        ArrayList<Point> pointsInRect = this.points(circRect);
        ArrayList<Point> inCircle = new ArrayList<>();
        pointsInRect.forEach(point -> {
            if (point.distanceTo(center) <= radius) {
                inCircle.add(point);
            }
        });
        return inCircle;
    }

    /**
     *  Creates an arraylist for all points of a specific type that are
     *  within a circle.
     *
     * @param origin the center of the circle
     * @param radius the radius of the circle
     * @param type the type of points that is searched.
     * @return an arraylist of all points of given type in the circle
     */

    public ArrayList<Point> specificTypeInCircle(Point origin, double radius, String type) {
        ArrayList<Point> pointsInCircle = this.pointsInCircle(origin, radius);
        ArrayList<Point> typeMatch = new ArrayList<>();
        pointsInCircle.forEach(point -> {
            if (point.getType().equals(type)) {
                typeMatch.add(point);
            }
        });
        return typeMatch;
    }

    /**
     * Finds all airports that are near a given number of trainstations
     * in a given circle around the airport, by finding all airports, and
     * then traversing through them.
     *
     * @param radius The radius of the circle
     * @param number The number of trainstations near the airport
     * @return the total number of airports the fit the requirements
     */
    public int trainstationsNearAirports(double radius, int number) {
        ArrayList<Point> airports = specificTypeInCircle(new Point(0.0,0.0), 35000.0, "AIRPORT");
        int counter = 0;
        for (Point airport: airports) {
            if(specificTypeInCircle( airport, radius, "TRAINSTATION").size() >= number) {
                counter++;
            };
        }
        return counter;
    }


}
