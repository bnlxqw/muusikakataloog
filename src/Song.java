public class Song {

    private String title;
    private String artist;
    private float rating;
    private float duration;

    public Song(String title, String artist, float rating, float duration) {
        this.title = title;
        this.artist = artist;
        setRating(rating);
        this.duration = duration;
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
        return title + " | " + artist + " | rating: " + rating + " | " + duration + " min";
    }
}