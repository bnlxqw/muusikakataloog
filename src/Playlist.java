import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(String title) {
        songs.removeIf(song ->
                song.getTitle().equalsIgnoreCase(title));
    }

    public void showAllSongs() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty");
            return;
        }

        System.out.println("Playlist: " + name);
        songs.forEach(System.out::println);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getName() {
        return name;
    }
}