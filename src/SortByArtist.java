import java.util.Comparator;
import java.util.List;

public class SortByArtist implements Sorting {

    public SortByArtist() {}

    @Override
    public void sort(List<Song> songs) {
        songs.sort(Comparator.comparing(Song::getArtist));
        System.out.println("Catalog sorted by Artist (A-Z).");
    }
}