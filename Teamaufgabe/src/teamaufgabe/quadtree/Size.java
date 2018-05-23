package teamaufgabe.quadtree;

public class Size {

    private double xLength;
    private double yLength;

    public Size(double xLength, double yLength) {
        this.xLength = xLength;
        this.yLength = yLength;
    }

    public Size half() {
        return new Size(this.xLength / 2, this.yLength / 2);
    }

    public double getxLength() {
        return xLength;
    }

    public double getyLength() {
        return yLength;
    }

    @Override
    public String toString() {
        return "teamaufgabe.quadtree.Size(" + xLength + ", " + yLength + ")";
    }
}
