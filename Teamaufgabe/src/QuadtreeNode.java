public class QuadtreeNode {

    public Rectangle rectangle;
    public Location[] locations;
    public boolean hasChildren = false;
    static int maxLocationCapacity = 3;

    public boolean add(Location location) {

        if (!this.rectangle.contains(location)) {
            return false;
        }

        if (this.hasChildren) {
            return true;
        }
        return false;
    }

    public QuadtreeNode(Rectangle rect) {
        this.rectangle = rect;
    }

}
