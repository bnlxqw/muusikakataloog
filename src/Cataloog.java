import java.util.ArrayList;
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
        String lowerKeyword = keyword.toLowerCase();
        for (Song s : songs) {
            if (s.getTitle().toLowerCase().contains(lowerKeyword) ||
                    s.getArtist().toLowerCase().contains(lowerKeyword) ||
                    s.getGenre().getName().toLowerCase().contains(lowerKeyword)) {
                result.add(s);
            }
        }
        return result;
    }

    public void deleteSong(String title) {
        boolean removed = songs.removeIf(song ->
                song.getTitle().equalsIgnoreCase(title));
        if (!removed) {
            System.out.println("Song '" + title + "' not found.");
        }
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

    public void sort(Sorting strategy) {
        strategy.sort(songs);
    }
}