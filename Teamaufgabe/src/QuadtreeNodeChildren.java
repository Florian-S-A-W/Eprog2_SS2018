import java.util.Iterator;

/**
 * Created by Florian on 20/05/2018.
 */
public class QuadtreeNodeChildren implements Iterator {

    QuadtreeNode leftTop;
    QuadtreeNode leftBottom;
    QuadtreeNode rightTop;
    QuadtreeNode rightBottom;

    public QuadtreeNodeChildren( QuadtreeNode parentnode) {
        this.leftTop = new QuadtreeNode(parentnode.rectangle.leftTopRectangle());
        this.leftBottom = new QuadtreeNode(parentnode.rectangle.leftBottomRectangle());
        this.rightTop = new QuadtreeNode(parentnode.rectangle.rightTopRectangle());
        this.rightBottom = new QuadtreeNode(parentnode.rectangle.rightBottomRectangle());
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
