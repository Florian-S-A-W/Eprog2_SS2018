
public class SongTree1Binary implements SongTreeNodable {

    private Song song;
    public SongTreeNodable left, right;

    public SongTree1Binary(Song newSong) {

        this.song = newSong;
        this.left = new SongTree1Null();
        this.right = new SongTree1Null();

    }

    @Override
    public SongTreeNodable add(Song newSong) {

        if (newSong.getTitel().compareTo(this.song.getTitel()) > 0) {
            this.left = this.left.add(newSong);
        } else if (newSong.getTitel().compareTo(this.song.getTitel()) < 0) {
            this.right = this.right.add(newSong);
        }

        return this;

    }

    @Override
    public void print() {

        this.song.print();
        this.left.print();
        this.right.print();
    }

    @Override
    public String toString() {

        String value = this.song.getTitel() + "," + this.song.getBand() + System.getProperty("line.separator");;
        value += "   " + "left: " + left.toString();
        value += "   " + "right: " + right.toString();

        return value;
    }

}