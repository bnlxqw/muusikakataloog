import java.util.ArrayList;
import java.util.List;

public class Cataloog {
    private List<Song> songs;
    private List<Playlist> playlists;

    public Cataloog() {
        songs = new ArrayList<>();
        playlists = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void showAllSongs() {
        if (songs.isEmpty()) {
            System.out.println("Catalog is empty");
            return;
        }
        System.out.println("All songs: ");
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + " " + songs.get(i));
        }
    }

    public void findSongByTitle(String title) {
        boolean found = false;
        for (Song s : songs){
            if (s.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + s);
                found = true;
            }
        }

        if (!found){
            System.out.println("Song with title " + title + "is not found");
        }
    }

    public void deleteSong(Song song) {
        songs.remove(song);
    }

    public void rateSong(String title, float rating) {
        for (Song s : songs) {
            if (s.getTitle().equalsIgnoreCase(title)) {
                s.setRating(rating);
                return;
            }
        }
    }
}
