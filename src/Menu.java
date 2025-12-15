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

    private int getIntChoice(String prompt) {
        System.out.println(prompt);
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a whole number!");
            }
        }
    }

    private float getFloatValue(String prompt) {
        System.out.println(prompt);
        while (true) {
            try {
                String input = sc.nextLine().replace(',', '.');
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a number!");
            }
        }
    }

    private String getStringInput(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    public void start() {
        while (true) {
            System.out.println("\nMUSIC CATALOG");
            System.out.println("1. Show catalog");
            System.out.println("2. Find song");
            System.out.println("3. Add song");
            System.out.println("4. Delete song");
            System.out.println("5. Rate song");
            System.out.println("6. Playlists");
            System.out.println("7. Sort songs");
            System.out.println("0. Exit");

            int choice = getIntChoice("Enter your choice:");

            switch (choice) {
                case 1:
                    ct.showAllSongs();
                    break;
                case 2:
                    var result = ct.search(getStringInput("Enter song title or artist:"));
                    if (result.isEmpty()) {
                        System.out.println("No songs found");
                    } else {
                        result.forEach(System.out::println);
                    }
                    break;
                case 3:
                    String title = getStringInput("Enter title:");
                    String artist = getStringInput("Enter artist:");
                    float rating = getFloatValue("Enter rating (1-5):");
                    float duration = getFloatValue("Enter duration (minutes):");
                    ct.addSong(new Song(title, artist, rating, duration));
                    System.out.println("Song added");
                    break;
                case 4:
                    ct.deleteSong(getStringInput("Enter song title to delete:"));
                    break;
                case 5:
                    String rateTitle = getStringInput("Enter song title:");
                    float rate = getFloatValue("Enter rating (1-5):");
                    ct.rateSong(rateTitle, rate);
                    break;
                case 6:
                    playlistMenu();
                    break;
                case 7:
                    System.out.println("\nSORT OPTIONS");
                    System.out.println("1. Sort by Title");
                    System.out.println("2. Sort by Artist");
                    System.out.println("3. Sort by Rating");
                    int sortChoice = getIntChoice("Enter (1-3):");

                    if (sortChoice == 1) ct.sort(new SortByTitle());
                    else if (sortChoice == 2) ct.sort(new SortByArtist());
                    else if (sortChoice == 3) ct.sort(new SortByRating());

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
        System.out.println("\nPLAYLIST MENU");
        System.out.println("1. Create");
        System.out.println("2. Add Song");
        System.out.println("3. Remove Song");
        System.out.println("4. Show All");
        System.out.println("0. Back");

        int choice = getIntChoice("Enter choice:");

        switch (choice) {
            case 1:
                pm.createPlaylist(getStringInput("Name:"));
                break;
            case 2:
                Playlist pl = pm.getPlaylist(getStringInput("Playlist:"));
                if (pl != null) ct.search(getStringInput("Song title:")).forEach(pl::addSong);
                else System.out.println("Playlist not found.");
                break;
            case 3:
                Playlist playlist = pm.getPlaylist(getStringInput("Playlist:"));
                if (playlist != null) playlist.removeSong(getStringInput("Song title:"));
                else System.out.println("Playlist not found.");
                break;
            case 4:
                pm.getPlaylists().forEach((name, p) -> {
                    System.out.println("\nPlaylist: " + name);
                    p.getSongs().forEach(System.out::println);
                });
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}