public class Main {
    public static void main(String[] args) {

        Cataloog cataloog = new Cataloog();
        PlaylistManager playlistManager = new PlaylistManager();
        ArtistManager artistManager = new ArtistManager();

        Genre rock = new Genre("Rock");
        Genre pop = new Genre("Pop");

        artistManager.addArtist(new Artist("Linkin Park", "American rock band known for nu metal."));
        artistManager.addArtist(new Artist("Michael Jackson", "The King of Pop."));
        artistManager.addArtist(new Artist("Daft Punk"));

        cataloog.addSong(new Song("Numb", "Linkin Park", 5.0F, 5.25F, rock));
        cataloog.addSong(new Song("Billie Jean", "Michael Jackson", 4.5F, 4.12F, pop));
        cataloog.addSong(new Song("In The End", "Linkin Park", 4.8F, 3.36F, rock));

        Menu menu = new Menu(cataloog, playlistManager);

        menu.start();
    }
}