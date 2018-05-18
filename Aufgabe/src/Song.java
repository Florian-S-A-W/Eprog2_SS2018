public class Song {

    private String titel;
    private String band;
    private long laenge;

    public Song(String titel, String band, long laenge) {
        this.titel = titel;
        this.band = band;
        this.laenge = laenge;
    }

    public String getTitel() {
        return this.titel;
    }

    public String getBand() {
        return this.band;
    }

    public long getLaenge() {
        return this.laenge;
    }

    public void print() {
        System.out.printf("%s: %s (%d s)", this.band, this.titel, this.laenge);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Song) {
            Song song = (Song)obj;
            return (song.getTitel() == this.titel &&
                    song.getBand() == this.band &&
                    song.getLaenge() == this.laenge);
        } else {
            return false;
        }
    }
}
