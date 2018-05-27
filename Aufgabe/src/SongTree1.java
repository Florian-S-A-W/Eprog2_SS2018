
public class SongTree1 implements Iterable<Song> {

    SongTreeNodable root;

    public SongTree1() {
        this.root = new SongTree1Null();
    }

    public void add(Song song) {

        this.root = this.root.add(song);

    }

    public void print() {
        this.root.print();
    }

    public String toString() {
        return this.root.toString();
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Song next() {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public class SongTreeIterator implements Iterator<Song> {

        private int index = 0;
        private Song song;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Song next() {
            return null;
        }
    }
}