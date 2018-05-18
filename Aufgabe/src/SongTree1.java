
public class SongTree1 {

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
    public boolean equals(Object obj) {
        if (obj instanceof SongTree1) {
            Song song = (Song)obj;
            return (song.getTitel() == this.titel &&
                    song.getBand() == this.band &&
                    song.getLaenge() == this.laenge);
        } else {
            return false;
        }
    }

}