package teamaufgabe.quadtree;

import java.util.Iterator;

/**
 * Represents the children of a quadtreenode. Each child inside
 * the quadtreenodechildren Object is a quadtreenode. It can be
 * used to to iterate over all children of a node and recursively
 * over all children of children etc.
 *
 * @author Florian Winkler
 */
public class QuadtreeNodeChildren implements Iterable<QuadtreeNode> {

    private QuadtreeNode leftTop;
    private QuadtreeNode leftBottom;
    private QuadtreeNode rightTop;
    private QuadtreeNode rightBottom;

    /**
     * Constructs a children object for a given parent node by
     * subdividing the rectangle of the parent into four rectangles.
     * Each new rectangle is then assigned to a quadtree node object.
     *
     * @param parentnode The parent Node of this children object
     */
    public QuadtreeNodeChildren(QuadtreeNode parentnode) {
        this.leftTop = new QuadtreeNode(parentnode.getRectangle().leftTopRectangle());
        this.leftBottom = new QuadtreeNode(parentnode.getRectangle().leftBottomRectangle());
        this.rightTop = new QuadtreeNode(parentnode.getRectangle().rightTopRectangle());
        this.rightBottom = new QuadtreeNode(parentnode.getRectangle().rightBottomRectangle());
    }

    /**
     * Creates a new iterator for a Quadtreenodechildren object.
     *
     * @return an iterator
     */
    @Override
    public Iterator<QuadtreeNode> iterator() {
        return new QuadtreeNodeChildrenIterator(this);
    }

    /**
     * The iterator class for QuadTreeNodeChildren. Creates an iterator for a given
     * children object.
     */
    public class QuadtreeNodeChildrenIterator implements Iterator<QuadtreeNode> {

        private int index = 0;
        private QuadtreeNodeChildren children;

        /**
         * Sets the children for this iterator
         * @param children the given children object
         */
        public QuadtreeNodeChildrenIterator(QuadtreeNodeChildren children) {
            this.children = children;
        }

        /**
         * As a Node always has exactly 4 children, it has a next element until
         * the iteratorindex is above 3.
         *
         * @return if the iteratorindex is below 4
         */
        @Override
        public boolean hasNext() {
            return index <= 3;
        }

        /**
         * Returns the corresponding child for each iteration, starting
         * with the left top rectangle, going counter clockwise.
         * @return
         */
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
