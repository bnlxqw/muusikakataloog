import java.util.HashMap;
import java.util.Map;

public class PlaylistManager {

    private Map<String, Playlist> playlists;

    public PlaylistManager() {
        playlists = new HashMap<>();
    }

    public void createPlaylist(String name) {
        if (playlists.containsKey(name)) {
            System.out.println("Playlist already exists");
        } else {
            playlists.put(name, new Playlist(name));
        }
    }

    public Playlist getPlaylist(String name) {
        return playlists.get(name);
    }

    public void deletePlaylist(String name) {
        if (playlists.remove(name) != null) {
            System.out.println("Playlist deleted");
        } else {
            System.out.println("Playlist not found");
        }
    }

    public Map<String, Playlist> getPlaylists() {
        return playlists;
    }
}
