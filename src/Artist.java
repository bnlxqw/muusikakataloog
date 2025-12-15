public class Artist {
    private String name;
    private String biography;

    public Artist(String name) {
        this.name = name;
        this.biography = "No biography available.";
    }

    public Artist(String name, String biography) {
        this.name = name;
        this.biography = biography;
    }

    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }

    @Override
    public String toString() {
        return name + (biography.equals("No biography available.") ? "" : " (Bio: " + biography + ")");
    }
}