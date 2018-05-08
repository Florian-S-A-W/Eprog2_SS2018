public class Song {

    private String titel;
    private String band;
    private long laenge;
    public Song next;

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


}
