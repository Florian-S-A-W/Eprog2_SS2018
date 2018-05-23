package teamaufgabe.quadtree;

import java.util.ArrayList;

public interface PointsContainer {

    boolean add(Point point);

    ArrayList<Point> points(Rectangle inRectangle);
}
