import java.util.HashMap;
import java.util.Map;

public class PlaylistManager {
    private Map<String, Playlist> playlists = new HashMap<>();

    public void createPlaylist(String name) {
        playlists.putIfAbsent(name, new Playlist(name));
    }

    public Playlist getPlaylist(String name) {
        return playlists.get(name);
    }

    public boolean playlistExists(String name) {
        return playlists.containsKey(name);
    }

    public Set<String> getAllPlaylistNames() {
        return playlists.keySet();
    }
 }
