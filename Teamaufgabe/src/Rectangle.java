
public class Rectangle {

    Point origin;
    Size size;

    public Rectangle(Point origin, Size size) {
        this.origin = origin;
        this.size = size;
    }

    public double minX() {
        return this.origin.x;
    }

    public double minY() {
        return origin.y;
    }

    public double maxX() {
        return origin.x + size.xLength;
    }

    public double maxY() {
        return origin.y + size.yLength;
    }

    public boolean contains(Point point) {
        return (this.minX() <= point.x && point.x <= this.maxX()) &&
                (this.minY() <= point.y && point.y <= this.maxY());
    }

    public Rectangle leftTopRectangle() {
        return new Rectangle(origin, this.size.half());
    }

    public Rectangle leftBottomRectangle() {
        return new Rectangle(new Point(origin.x, origin.y + this.size.half().yLength), size.half());
    }

    public Rectangle rightTopRectangle() {
        return new Rectangle(new Point(origin.x + size.half().xLength, origin.y), this.size.half());
    }

    public Rectangle rightBottomRectangle() {
        return new Rectangle(new Point(origin.x + size.half().xLength, origin.y + size.half().yLength), size.half());
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
}
