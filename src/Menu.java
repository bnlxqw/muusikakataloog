import java.util.Scanner;

public class Menu {
    private Scanner sc;
    private Cataloog ct;
    private PlaylistManager pm;

    public Menu(Cataloog ct, PlaylistManager pm) {
        this.sc = new Scanner(System.in);
        this.ct = ct;
        this.pm = pm;
    }

    public void start() {
        while (true) {
            System.out.println("\n=== MUSIC CATALOG ===");
            System.out.println("1. Show catalog");
            System.out.println("2. Find song");
            System.out.println("3. Add song");
            System.out.println("4. Delete song");
            System.out.println("5. Rate song");
            System.out.println("6. Playlists");
            System.out.println("7. Sort songs");
            System.out.println("0. Exit");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: enter a number!");
                continue;
            }

            switch (choice) {

                case 1:
                    ct.showAllSongs();
                    break;

                case 2:
                    System.out.println("Enter song title or artist:");
                    var result = ct.search(sc.nextLine());
                    if (result.isEmpty()) {
                        System.out.println("No songs found");
                    } else {
                        result.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.println("Enter title:");
                    String title = sc.nextLine();

                    System.out.println("Enter artist:");
                    String artist = sc.nextLine();

                    System.out.println("Enter rating (1-5):");
                    float rating = Float.parseFloat(sc.nextLine());

                    System.out.println("Enter duration (minutes):");
                    float duration = Float.parseFloat(sc.nextLine());

                    ct.addSong(new Song(title, artist, rating, duration));
                    System.out.println("Song added");
                    break;

                case 4:
                    System.out.println("Enter song title to delete:");
                    ct.deleteSong(sc.nextLine());
                    System.out.println("Song deleted");
                    break;

                case 5:
                    System.out.println("Enter song title:");
                    String rateTitle = sc.nextLine();

                    System.out.println("Enter rating (1-5):");
                    float rate = Float.parseFloat(sc.nextLine());

                    ct.rateSong(rateTitle, rate);
                    System.out.println("Rating updated");
                    break;

                case 6:
                    playlistMenu();
                    break;

                case 7:
                    System.out.println("1 - by title");
                    System.out.println("2 - by artist");
                    System.out.println("3 - by rating");

                    int sort = Integer.parseInt(sc.nextLine());

                    if (sort == 1) ct.sortByTitle();
                    else if (sort == 2) ct.sortByArtist();
                    else if (sort == 3) ct.sortByRating();

                    System.out.println("Songs sorted");
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }


    private void playlistMenu() {
        System.out.println("\n=== PLAYLIST MENU ===");
        System.out.println("1. Create playlist");
        System.out.println("2. Add song to playlist");
        System.out.println("3. Remove song from playlist");
        System.out.println("4. Show playlists");

        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {

            case 1:
                System.out.println("Playlist name:");
                pm.createPlaylist(sc.nextLine());
                System.out.println("Playlist created");
                break;

            case 2:
                System.out.println("Playlist name:");
                Playlist pl = pm.getPlaylist(sc.nextLine());
                if (pl == null) {
                    System.out.println("Playlist not found");
                    return;
                }

                System.out.println("Song title:");
                String songTitle = sc.nextLine();
                ct.search(songTitle).forEach(pl::addSong);
                System.out.println("Song added to playlist");
                break;

            case 3:
                System.out.println("Playlist name:");
                Playlist playlist = pm.getPlaylist(sc.nextLine());
                if (playlist == null) {
                    System.out.println("Playlist not found");
                    return;
                }

                System.out.println("Song title:");
                playlist.removeSong(sc.nextLine());
                System.out.println("Song removed");
                break;

            case 4:
                pm.getPlaylists().forEach((name, playlistShow) -> {
                    System.out.println("\nPlaylist: " + name);
                    playlistShow.getSongs().forEach(System.out::println);
                });
                break;

            default:
                System.out.println("Invalid choice");
        }
    }
}