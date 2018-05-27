package teamaufgabe.quadtree;

public class Rectangle {

    private Point origin;
    private Size size;

    public Rectangle(Point origin, Size size) {
        this.origin = origin;
        this.size = size;
    }

    public double minX() {
        return this.origin.getX();
    }

    public double minY() {
        return origin.getY();
    }

    public double maxX() {
        return origin.getX() + size.getxLength();
    }

    public double maxY() {
        return origin.getY() + size.getyLength();
    }

    public boolean contains(Point point) {
        return (this.minX() <= point.getX() && point.getX() <= this.maxX()) &&
                (this.minY() <= point.getY() && point.getY() <= this.maxY());
    }

    public Rectangle leftTopRectangle() {
        return new Rectangle(origin, this.size.half());
    }

    public Rectangle leftBottomRectangle() {
        return new Rectangle(new Point(origin.getX(), origin.getY() + this.size.half().getyLength()), size.half());
    }

    public Rectangle rightTopRectangle() {
        return new Rectangle(new Point(origin.getX() + size.half().getxLength(), origin.getY()), this.size.half());
    }

    public Rectangle rightBottomRectangle() {
        return new Rectangle(new Point(origin.getX() + size.half().getxLength(), origin.getY() + size.half().getyLength()), size.half());
    }

    public boolean intersects(Rectangle rect){

        // to intersect, both horizontal and vertical projections need to intersect
        // horizontal
        if (!lineSegmentsIntersect(this.minX(), this.maxX(), rect.minX(), rect.maxX())) {
            return false;
        }

        // vertical
        return lineSegmentsIntersect(this.minY(), this.maxY(), rect.minY(), rect.maxY());
    }


    private boolean lineSegmentsIntersect(double lStart, double lEnd, double rStart, double rEnd) {
        return Math.max(lStart, rStart) <= Math.min(lEnd, rEnd);
    }

    @Override
    public String toString() {
        return "Rect(" + origin + ", " + size + ")";
    }
}
