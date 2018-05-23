package teamaufgabe.quadtree;

import java.util.ArrayList;

public class Quadtree implements PointsContainer {

    private QuadtreeNode root;

    public Quadtree(Rectangle rectangle) {
        this.root = new QuadtreeNode(rectangle);
    }

    @Override
    public boolean add(Point point) {
        return root.add(point);
    }

    @Override
    public ArrayList<Point> points(Rectangle inRectangle) {
        return root.points(inRectangle);
    }

    @Override
    public String toString() {
        return "Quad tree\n" + root.recursiveDescription();
    }
}
