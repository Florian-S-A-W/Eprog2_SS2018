package teamaufgabe.quadtree;

import java.util.ArrayList;
import java.util.Arrays;

public class QuadtreeNode implements PointsContainer {

    private static int MAX_LOCATION_CAPACITY = 3;

    private Rectangle rectangle;
    private ArrayList<Point> points = new ArrayList<Point>();
    private boolean hasChildren = false;
    private QuadtreeNodeChildren children;

    public QuadtreeNode(Rectangle rect) {
        this.rectangle = rect;
    }

    // Getters and Setters

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    // Descriptions

    @Override
    public String toString() {
        if (hasChildren) {
            return "parent " + rectangle + " Points: " + Arrays.toString(points.toArray());
        } else {
            return "leaf " + rectangle + " Points: " +  Arrays.toString(points.toArray());
        }
    }

    public String recursiveDescription() {
        return recursiveDescription(0);
    }

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

    private void subdivide() {
        if (!hasChildren) {
            hasChildren = true;
            children = new QuadtreeNodeChildren(this);
        } else {
            // TODO: Crash? Throw?
        }
    }
}
