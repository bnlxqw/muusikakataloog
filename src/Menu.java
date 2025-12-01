import java.util.Scanner;

public class Menu {
    public static void menu(String[] args){
        Scanner sc = new Scanner(System.in);
        Cataloog ct = new Cataloog();

        while (true){
            System.out.println("Show cataloog");
            System.out.println("Find song");
            System.out.println("Add song");
            System.out.println("Delete song");
            System.out.println("Rate song");
            System.out.println("Add and manage playlist");
            System.out.println("Sort songs by title, artist or rating");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Error: Enter number!");
                continue;
            }

            switch (choice) {
                case 1:
                    ct.showAllSongs();
                    break;

                case 2:
                    System.out.println("Enter song title: ");
                    String searchTitle = sc.nextLine();
                    ct.findSongByTitle(searchTitle);
                    break;

                case 3:
                    System.out.println("Enter title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter artist: ");
                    String artist = sc.nextLine();
                    System.out.println("Enter rating: ");
                    int rating = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter duration: ");
                    float duration = Integer.parseInt(sc.nextLine());

                    ct.addSong(new Song(title, artist, rating, duration));
                    break;

                case 4:

                default:
                    System.out.println("Error: choose something");
            }
        }
    }
}