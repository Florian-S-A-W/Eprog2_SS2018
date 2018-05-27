package teamaufgabe.quadtree;

public class Point {

    private double x;
    private double y;
    private String type;
    private String name;

    public Point(double x, double y, String name, String type) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.type = type;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point point) {
        return Math.sqrt((this.x - point.x)*(this.x - point.x) + (this.y - point.y)*(this.y - point.y));
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public String getType() { return this.type; }

    @Override
    public String toString() {
        return name + ", a " + type + " at(" + x + ", " + y + ")";
    }
}
