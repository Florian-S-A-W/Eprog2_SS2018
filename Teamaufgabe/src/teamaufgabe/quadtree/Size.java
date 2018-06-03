package teamaufgabe.quadtree;

/**
 * A Size object represents a rectangle with x and y length without an exact location
 *
 * @author Florian Winkler
 */
public class Size {

    private double xLength;
    private double yLength;

    /**
     * Constructor. Creates this Size Object with a given x and y length.
     * @param xLength
     * @param yLength
     */
    public Size(double xLength, double yLength) {
        this.xLength = xLength;
        this.yLength = yLength;
    }

    /**
     * Creates a new Size Object with half the x and y length of this Size.
     *
     * @return The new size object with half the vertice length
     */
    public Size half() {
        return new Size(this.xLength / 2, this.yLength / 2);
    }

    /**
     * Getter. Returns this x length.
     * @return x length of this Size Object
     */
    public double getxLength() {
        return xLength;
    }

    /**
     * Getter. Returns this y length.
     * @return y length of this Size Object
     */
    public double getyLength() {
        return yLength;
    }

    /**
     * Creates a string showing the x and y length of this size
     *
     * @return The string
     */
    @Override
    public String toString() {
        return "teamaufgabe.quadtree.Size(" + xLength + ", " + yLength + ")";
    }
}
