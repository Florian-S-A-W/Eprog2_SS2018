import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Playlist1 {

    public Song firstSong;


    public Playlist1() {

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

    public Playlist1(String filename) {

        try(Scanner s = new Scanner(
                new File(System.getProperty(filename)), "UTF-8")) {
            s.useDelimiter(System.getProperty("line.separator"));
            while(s.hasNextLine()){
                if (s.hasNext()) {
                    String line = s.next();
                    String[] parts = line.split(";");
                    if (parts.length != 3) {
                        throw new IOException();
                    } else {
                        String title = parts[0];
                        String band = parts[1];
                        long laenge = Long.valueOf(parts[2]);
                        Song newSong = new Song(title, band, laenge);
                        this.add(newSong);
                    }
                } else {
                    break;
                }
            }
            s.close();
        } catch(FileNotFoundException e) {
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
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

    void save(String filename) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filename);

            Song currentSong = this.firstSong;

            if(!this.isEmpty()){

                while(currentSong != null) {

                    fileWriter.append(currentSong.getTitel());
                    fileWriter.append(";");
                    fileWriter.append(currentSong.getBand());
                    fileWriter.append(";");
                    fileWriter.append(String.valueOf(currentSong.getLaenge()));
                    fileWriter.append("\n");

                    if(currentSong.next == null) {

                        break;

                    } else {

                        currentSong = currentSong.next;

                    }

                }

            }   else { return; }


        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}