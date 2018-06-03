package teamaufgabe.quadtree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A Node of the point Quadtree. Each node contains a
 * specified maximum capacity of points. A Node is confined
 * by a rectangle. A Node can have exactly four children, set
 * inside its children object.
 * The four children represent four rectangle areas inside
 * the rectangle of the node. If a node contains more points
 * than the specified point capacity, it splits up itself to
 * create four children nodes. Children can be iterated to
 * get all points of the nodes.
 *
 * @author Florian Winkler
 */

public class QuadtreeNode implements PointsContainer {

    private static int MAX_LOCATION_CAPACITY = 3;

    private Rectangle rectangle;
    private ArrayList<Point> points = new ArrayList<Point>();
    private boolean hasChildren = false;
    private QuadtreeNodeChildren children;

    /**
     * Constructor that sets the rectangle area this node is representing
     *
     * @param rect the rectangle area
     */
    public QuadtreeNode(Rectangle rect) {
        this.rectangle = rect;
    }

    // Getters and Setters

    /**
     * Sets the hasChildren property to a given boolean
     *
     * @param hasChildren the boolean
     */
    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    /**
     * Returns the rectangle that confines the area of the node
     *
     * @return the rectangle area of the node
     */
    public Rectangle getRectangle() {
        return rectangle;
    }

    // Descriptions

    /**
     * Creates a recursive description of all children of the node.
     *
     * @return a string that represents the tree structure of and below the node.
     */
    @Override
    public String toString() {
        if (hasChildren) {
            return "parent " + rectangle + " Points: " + Arrays.toString(points.toArray());
        } else {
            return "leaf " + rectangle + " Points: " +  Arrays.toString(points.toArray());
        }
    }

    /**
     * Inserts space in the description string to make it more readable
     *
     * @return recursive computed whitespace
     */
    public String recursiveDescription() {
        return recursiveDescription(0);
    }

    /**
     * Inserts a given number of tabs between for the layers of the tree to make the output
     * string more readable.
     *
     * @param withTabCount number of tabs for each layer
     * @return the tabs for the current layer as a string
     */
    private String recursiveDescription(int withTabCount) {
        String indent = "";
        for (int i = 0; i < withTabCount; i++) {
            indent += "\t";
        }

        String result = indent + toString() + "\n";
        if (hasChildren) {
            for (QuadtreeNode node : children) {
                result += node.recursiveDescription(withTabCount + 1);
            }
        }

        return result;
    }

    // PointsContainer functions

    /**
     * Adds a point to the node. If the node area contains the point,
     * it returns false. If the node has children it assesses them. If the
     * number of points for this node is the max capacity, it subdivides the node
     * into children.
     *
     * @param point the point to add
     * @return if the point was successfully added
     */
    @Override
    public boolean add(Point point) {
        if (!this.rectangle.contains(point)) {
            return false;
        }

        if (hasChildren) {
            for (QuadtreeNode node : children) {
                if (node.add(point)) {
                    return true;
                }
            }

            // TODO: Crash? Throw?
        } else {
            points.add(point);
            if (points.size() == QuadtreeNode.MAX_LOCATION_CAPACITY) {
                subdivide();
            }
        }

        return true;
    }

    /**
     * Checks if a given rectangle and the nodes rectangle intersect and collects all points
     * that lie in the given rectangle. If the node has children, it assesses them recursively.
     *
     * @param inRectangle the rectangle for which we search points
     * @return  the list of points in the given rectangle
     */
    @Override
    public ArrayList<Point> points(Rectangle inRectangle) {
        // if the node's rect and the given rect don't intersect, return an empty array,
        // because there can't be any points that lie the node's (or its children's) rect and
        // in the given rect
        if (!this.rectangle.intersects(inRectangle)) {
            return new ArrayList<Point>();
        }

        ArrayList<Point> result = new ArrayList<Point>();

        // collect the node's points that lie in the rect
        for (Point point : points) {
            if (inRectangle.contains(point)) {
                result.add(point);
            }
        }

        if (hasChildren) {
            // recursively add children's points that lie in the rect
            for (QuadtreeNode node : children) {
                result.addAll(node.points(inRectangle));
            }
        }

        return result;
    }

    // Helpers

    /**
     * Transforms the type of the node by subdividing
     * the rectangle of the node into four children nodes.
     * The node can than be used to assess these areas.
     */
    private void subdivide() {
        if (!hasChildren) {
            hasChildren = true;
            children = new QuadtreeNodeChildren(this);
        } else {
            // TODO: Crash? Throw?
        }
    }
}
