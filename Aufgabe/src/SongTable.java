public class SongTable {

    private SongList[] songListArray;
    private int size;


    public SongTable(int size) {

        this.size = size;
        this.songListArray = new SongList[size];

        for (int i = 0; i < size; i++) {

            this.songListArray[i] = new SongList();

        }

    }

    public void add(Song song) {

        int key = songHash(song);

        songListArray[key].add(song, key);

    }

    public Song lookUpTitle(String title) {

        int key = title.hashCode() % this.size;

        Song result = songListArray[key].find(key, title);

        if (result == null) {
            System.out.println("Song is not in Hashtable");
        }
        return result;

    }

    public String toString() {

        String tableString = "";

        for (int i = 0; i < this.size; i++) {
            tableString += (this.songListArray[i].toString() + " at Index " + i + System.lineSeparator());
        }

        return tableString;

    }

    public void print() {

        System.out.print(this.toString());

    }

    public int songHash(Song song) {

        return (song.getTitel().hashCode() % this.size);

    }

}
