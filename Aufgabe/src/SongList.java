public class SongList {

    public Song firstSong = null;

    public void add(Song newSong, int hashKey) {

        Song previous = null;
        Song current = firstSong;

        newSong.key = hashKey;

        while(current != null && newSong.key > current.key) {

            previous = current;
            current = current.next;

        }

        if(previous == null) {

            this.firstSong = newSong;
        }
        else {

            previous.next = newSong;
        }

        newSong.next = current;
    }

    public Song find(int hashKey, String title) {

        Song current = firstSong;

        while(current != null) {

            if (current.getTitel().equals(title)) {
                return current;
            }

            current = current.next;

        }

        return null;

    }

    public String toString() {

        String listString = "";

        Song current = firstSong;

        while (current != null) {

            listString += (current.toString() + ", ");
            current = current.next;
        }

        if (listString == "") {
            return "No songs";
        }

        return listString;

    }


}
