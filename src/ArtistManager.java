import java.util.HashMap;
import java.util.Map;

public class ArtistManager {
    private Map<String, Artist> artists;

    public ArtistManager() {
        this.artists = new HashMap<>();
    }

    public void addArtist(Artist artist) {
        if (!artists.containsKey(artist.getName().toLowerCase())) {
            artists.put(artist.getName().toLowerCase(), artist);
        }
    }

    public Artist getArtistByName(String name) {
        return artists.get(name.toLowerCase());
    }

    public void showAllArtists() {
        if (artists.isEmpty()) {
            System.out.println("No artists in the system.");
            return;
        }
        System.out.println("\nAll Artists:");
        artists.values().forEach(System.out::println);
    }
}