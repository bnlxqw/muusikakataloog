import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cataloog {

    private List<Song> songs;

    public Cataloog() {
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void showAllSongs() {
        if (songs.isEmpty()) {
            System.out.println("Catalog is empty");
            return;
        }

        System.out.println("All songs:");
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }
    }

    public List<Song> search(String keyword) {
        List<Song> result = new ArrayList<>();

        for (Song s : songs) {
            if (s.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    s.getArtist().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(s);
            }
        }
        return result;
    }

    public void deleteSong(String title) {
        songs.removeIf(song ->
                song.getTitle().equalsIgnoreCase(title));
    }

    public void rateSong(String title, float rating) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                song.setRating(rating);
                return;
            }
        }
        System.out.println("Song not found");
    }

    public void sortByTitle() {
        songs.sort(Comparator.comparing(Song::getTitle));
    }

    public void sortByArtist() {
        songs.sort(Comparator.comparing(Song::getArtist));
    }

    public void sortByRating() {
        songs.sort(Comparator.comparingDouble(Song::getRating).reversed());
    }
}