import java.util.Comparator;
import java.util.List;

public class SortByRating implements Sorting {

    public SortByRating() {}

    @Override
    public void sort(List<Song> songs) {
        songs.sort(Comparator.comparingDouble(Song::getRating).reversed());
        System.out.println("Catalog sorted by Rating (5 to 1).");
    }
}