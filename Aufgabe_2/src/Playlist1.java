public class Playlist1 {

    public Song firstSong;

    /*
    * 1. Frage: Macht es Sinn "laenge" im Konstruktor zu behalten?
    *
    * Nein, da die Linked List, bzw Playlist ja nur die Referenz zum letzten Objekt in der Liste enthält.
    * Die Anzahl der Elemente ist in einer Linked List dynamisch und nicht von der Linked-List Klasse abhängig.
    * */

    public Playlist1(int laenge) {

        this.firstSong = null;
    }

    public Playlist1(Playlist1 myplaylist, int l1, int l2) {

        this.firstSong = null;

        Song currentSong = myplaylist.firstSong;

        while(currentSong != null) {

            if ((currentSong.getLaenge() >= l1) && (currentSong.getLaenge() <= l2)) {

                this.add(currentSong);

            }

            currentSong = currentSong.next;
        }

    }


    boolean isEmpty() {

        return(firstSong == null);
    }


    void add(Song song) {

        song.next = firstSong;

        firstSong = song;
    }


    void addAfter(String title, Song song) {

        if (this.lookupTitle(title) != null) {

            song.next = this.lookupTitle(title).next;

            this.lookupTitle(title).next = song;


        } else {

            this.add(song);

        }

    }

    void addBefore(String title, Song song) {

        if (this.lookupTitle(title) != null) {

            Song currentSong = firstSong;

            while(currentSong.next.getTitel() != title) {

                currentSong = currentSong.next;

            }

            song.next = currentSong.next;
            currentSong.next = song;

        } else {

            this.add(song);

        }

    }


    long getLaenge() {
        long laenge = 0;

        Song currentSong = firstSong;

        while(currentSong != null) {

            laenge += currentSong.getLaenge();

            currentSong = currentSong.next;
        }

        return laenge;
    }

    void print() {

        Song currentSong = firstSong;

        while(currentSong != null) {

            currentSong.print();

            System.out.println();

            currentSong = currentSong.next;
        }


    }

    Song lookupTitle(String title) {

        Song currentSong = firstSong;

        if(!isEmpty()){

            while(currentSong.getTitel() != title) {

                if(currentSong.next == null) {

                    return null;

                } else {

                    currentSong = currentSong.next;

                }

            }

        }   else {

            return null;

        }

        return currentSong;

    }

}