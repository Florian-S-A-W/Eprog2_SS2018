package teamaufgabe.quadtree;

import java.util.ArrayList;

/**
 * An interface, specifying what an object containing points has to implement.
 */
public interface PointsContainer {

    /**
     * Adds a point to the PointsContainer.
     *
     * @param point the new point
     * @return If the point was added
     */
    boolean add(Point point);

    /**
     * Creates a list of all points lying in a given rectangle area.
     * @param inRectangle the given rectangle
     * @return An Arraylist of all points in this area
     */
    ArrayList<Point> points(Rectangle inRectangle);
}
