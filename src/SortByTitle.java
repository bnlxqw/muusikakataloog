import java.util.Comparator;
import java.util.List;

public class SortByTitle implements Sorting {

    public SortByTitle() {}

    @Override
    public void sort(List<Song> songs) {
        songs.sort(Comparator.comparing(Song::getTitle));
        System.out.println("Catalog sorted by Title (A-Z).");
    }
}