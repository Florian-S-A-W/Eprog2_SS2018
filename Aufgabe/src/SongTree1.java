
public class SongTree1 {

    SongTreeNodable root;

    public SongTree1() {
        this.root = new SongTree1Null();
    }

    /**
     * Adds a song to the binary tree
     *
     * @param song a new song that shall be added to the tree
     * @throws IllegalArgumentException song == null
     *
     * Postcondition: The song is in the tree if it is not null
     */
    public void add(Song song) throws IllegalArgumentException {

        if(song == null) {
            throw new IllegalArgumentException();
        }

        this.root = this.root.add(song);

    }

    public void print() {
        this.root.print();
    }

    public String toString() {
        return this.root.toString();
    }

}