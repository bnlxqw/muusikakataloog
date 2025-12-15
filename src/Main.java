public class Main {
    public static void main(String[] args) {

        Cataloog cataloog = new Cataloog();
        PlaylistManager playlistManager = new PlaylistManager();
        Menu menu = new Menu(cataloog, playlistManager);

        cataloog.addSong(new Song("Numb", "Linkin Park", 5, 5.25F));
        cataloog.addSong(new Song("Billie Jean", "Michael Jackson", 4.5F, 4.12F));

        menu.start();
    }
}