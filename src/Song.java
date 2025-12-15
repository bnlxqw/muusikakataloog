public class Song {

    private String title;
    private String artist;
    private float rating;
    private float duration;
    private Genre genre; // Добавлено поле Genre

    public Song(String title, String artist, float rating, float duration, Genre genre) {
        this.title = title;
        this.artist = artist;
        setRating(rating);
        this.duration = duration;
        this.genre = genre;
    }

    public Song(String title, String artist, float rating, float duration) {
        this(title, artist, rating, duration, new Genre("Unknown"));
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public float getRating() {
        return rating;
    }

    public float getDuration() {
        return duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setRating(float rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Rating must be between 1 and 5");
            this.rating = 0;
        }
    }

    @Override
    public String toString() {
        return title + " | " + artist + " | Genre: " + genre + " | rating: " + rating + " | " + duration + " min";
    }
}