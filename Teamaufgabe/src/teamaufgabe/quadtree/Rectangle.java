package teamaufgabe.quadtree;

/**
 * A Rectangle represents an area confined by a x and y length at
 * a specific location, set by its origin.
 *
 *
 * @author Florian Winkler
 */
public class Rectangle {

    private Point origin;
    private Size size;

    /**
     * Constructor. Creates an area with a given size at a given location
     *
     * @param origin lefttop corner of the rectangle
     * @param size x and y size of the rectangle
     */
    public Rectangle(Point origin, Size size) {
        this.origin = origin;
        this.size = size;
    }

    /**
     * Computed property, minimum x coordinate of this rectangle
     * @return minimum x coordinate
     */
    public double minX() {
        return this.origin.getX();
    }

    /**
     * Computed property, minimum y coordinate of this rectangle
     * @return minimum x coordinate
     */
    public double minY() {
        return origin.getY();
    }

    /**
     * Computed property, maximum x coordinate of this rectangle
     * @return minimum x coordinate
     */
    public double maxX() {
        return origin.getX() + size.getxLength();
    }

    /**
     * Computed property, maximum y coordinate of this rectangle
     * @return minimum x coordinate
     */
    public double maxY() {
        return origin.getY() + size.getyLength();
    }

    /**
     * Checks if a given point lies within the rectangle.
     *
     * @param point the point given
     * @return boolean if point lies in rectangle
     */
    public boolean contains(Point point) {
        return (this.minX() <= point.getX() && point.getX() <= this.maxX()) &&
                (this.minY() <= point.getY() && point.getY() <= this.maxY());
    }

    /**
     * Creates a new rectangle that represents the half left top area of the rectangle.
     * @return the new rectangle
     */
    public Rectangle leftTopRectangle() {
        return new Rectangle(origin, this.size.half());
    }

    /**
     * Creates a new rectangle that represents the half left bottom area of the rectangle.
     * @return the new rectangle
     */
    public Rectangle leftBottomRectangle() {
        return new Rectangle(new Point(origin.getX(), origin.getY() + this.size.half().getyLength()), size.half());
    }

    /**
     * Creates a new rectangle that represents the half right top area of the rectangle.
     * @return the new rectangle
     */
    public Rectangle rightTopRectangle() {
        return new Rectangle(new Point(origin.getX() + size.half().getxLength(), origin.getY()), this.size.half());
    }

    /**
     * Creates a new rectangle that represents the half right bottom area of the rectangle.
     * @return the new rectangle
     */
    public Rectangle rightBottomRectangle() {
        return new Rectangle(new Point(origin.getX() + size.half().getxLength(), origin.getY() + size.half().getyLength()), size.half());
    }

    /**
     * Checks if this rectangle intersects with another given rectangle
     *
     * @param rect the rectangle given
     * @return boolean if the rectangle intersects with this rectangle
     */
    public boolean intersects(Rectangle rect){

        // to intersect, both horizontal and vertical projections need to intersect
        // horizontal
        if (!lineSegmentsIntersect(this.minX(), this.maxX(), rect.minX(), rect.maxX())) {
            return false;
        }

        // vertical
        return lineSegmentsIntersect(this.minY(), this.maxY(), rect.minY(), rect.maxY());
    }

    /**
     * Checks if two linesegments intersect
     *
     * @param lStart Start of first line
     * @param lEnd  End of first line
     * @param rStart Start of second line
     * @param rEnd  End of first line
     * @return
     */
    private boolean lineSegmentsIntersect(double lStart, double lEnd, double rStart, double rEnd) {
        return Math.max(lStart, rStart) <= Math.min(lEnd, rEnd);
    }

    /**
     * Creates a string of the origin and size of this rectangle
     * @return the string created
     */
    @Override
    public String toString() {
        return "Rect(" + origin + ", " + size + ")";
    }
}
