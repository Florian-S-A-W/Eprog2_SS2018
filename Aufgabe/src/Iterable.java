import java.util.Iterator;

public interface Iterable<Song> extends java.util.Iterator<Song> {
    Iterator iterator();
}
