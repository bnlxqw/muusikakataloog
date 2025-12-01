import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Song> songs = new ArrayList<>();

    public Playlist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public void showAllSongs() {
        if (songs.isEmpty()) {
            System.out.println("Playlist is empty");
            return;
        }
        System.out.println("Songs in the playlist: " + name + ";");
        songs.forEach(System.out::println);
    }

    public List<Song> getSongs() {
        return songs;
    }
}
