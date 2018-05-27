package teamaufgabe.quadtree;

import java.util.Iterator;

/**
 * Created by Florian on 20/05/2018.
 */
public class QuadtreeNodeChildren implements Iterable<QuadtreeNode> {

    private QuadtreeNode leftTop;
    private QuadtreeNode leftBottom;
    private QuadtreeNode rightTop;
    private QuadtreeNode rightBottom;

    public QuadtreeNodeChildren(QuadtreeNode parentnode) {
        this.leftTop = new QuadtreeNode(parentnode.getRectangle().leftTopRectangle());
        this.leftBottom = new QuadtreeNode(parentnode.getRectangle().leftBottomRectangle());
        this.rightTop = new QuadtreeNode(parentnode.getRectangle().rightTopRectangle());
        this.rightBottom = new QuadtreeNode(parentnode.getRectangle().rightBottomRectangle());
    }

    @Override
    public Iterator<QuadtreeNode> iterator() {
        return new QuadtreeNodeChildrenIterator(this);
    }

    public class QuadtreeNodeChildrenIterator implements Iterator<QuadtreeNode> {

        private int index = 0;
        private QuadtreeNodeChildren children;

        public QuadtreeNodeChildrenIterator(QuadtreeNodeChildren children) {
            this.children = children;
        }

        @Override
        public boolean hasNext() {
            return index <= 3;
        }

        @Override
        public QuadtreeNode next() {
            switch (index) {
                case 0:
                    index++;
                    return children.leftTop;
                case 1:
                    index++;
                    return children.leftBottom;
                case 2:
                    index++;
                    return children.rightTop;
                case 3:
                    index++;
                    return children.rightBottom;
                default:
                    index++;
                    return null;
            }
        }
    }
}
