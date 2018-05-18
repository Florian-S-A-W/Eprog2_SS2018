
public class SongTree1Null implements SongTreeNodable {

    @Override
    public SongTreeNodable add(Song song) {

        SongTreeNodable newNode = new SongTree1Binary(song);

        return newNode;
    }

    @Override
    public void print() {
    }

    @Override
    public String toString() {

        return "null";
    }

}