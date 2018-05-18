
public class Size {

    public double xLength;
    public double yLength;

    public Size(double xLength, double yLength) {

        this.xLength = xLength;
        this.yLength = yLength;
    }

    public Size half() {
        return new Size(this.xLength / 2, this.yLength / 2);
    }
}
