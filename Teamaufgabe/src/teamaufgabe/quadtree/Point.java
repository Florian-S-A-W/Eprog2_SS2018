package teamaufgabe.quadtree;

/**
 * A point is the representation of Location for this exercise.
 * It has a type and name, and is located at a given x and y coordinate.
 * It can compute the distance to another point.
 */
public class Point {

    private double x;
    private double y;
    private String type;
    private String name;

    /**
     * Constructor, sets private object variables.
     * @param x the x coordinate of this point
     * @param y the y coordinate of this point
     * @param name the name of this point
     * @param type the type of this point
     */
    public Point(double x, double y, String name, String type) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.type = type;
    }

    /**
     * Constructs a point without name and type
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Computes this points distance to another given point
     *
     * @param point The other point
     * @return the distance to the point
     */
    public double distanceTo(Point point) {
        return Math.sqrt((this.x - point.x)*(this.x - point.x) + (this.y - point.y)*(this.y - point.y));
    }

    /**
     * Getter. Returns this point's x coordinate
     * @return x coordinate of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * Getter. Returns this point's y coordinate
     * @return y coordinate of this point
     */
    public double getY() {
        return this.y;
    }

    /**
     * Checks if this point has a type and returns it.
     * @return The point's type or a message saying it has none.
     */
    public String getType() {
        if (this.type != null) {
            return this.type;
        }
        else {
        return "No type specified";
        }
     }

    /**
     * Creates a string representation of the point.
     * @return The string
     */
    @Override
    public String toString() {
        return this.name + ", a " + this.type + " at(" + this.x + ", " + this.y + ")";
    }
}
