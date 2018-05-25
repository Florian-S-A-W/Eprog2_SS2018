package teamaufgabe.quadtree;

import java.util.ArrayList;
import java.util.Objects;

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

    public ArrayList<Point> pointsInCircle(Point origin, double radius) {
        Rectangle circRect = new Rectangle(origin, new Size(2* radius, 2* radius));
        ArrayList<Point> pointsInRect = this.points(circRect);
        ArrayList<Point> inCircle = new ArrayList<>();
        pointsInRect.forEach(point -> {
            if (origin.distanceTo(point) <= radius) {
                inCircle.add(point);
            }
        });
        return inCircle;
    }

    public ArrayList<Point> specificTypeInCircle(Point origin, double radius, String type) {
        ArrayList<Point> pointsInCircle = this.pointsInCircle(origin, radius);
        ArrayList<Point> typeMatch = new ArrayList<>();
        pointsInCircle.forEach(point -> {
            if (Objects.equals(point.getType(), type)) {
                typeMatch.add(point);
            }
        });
        return typeMatch;
    }


}
