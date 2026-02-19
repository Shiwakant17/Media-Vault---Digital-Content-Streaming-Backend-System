package service;

import java.io.IOException;
import java.util.Scanner;

import model.Song;
import repository.SongRepository;

public class AdminService {
    Scanner sc = new Scanner(System.in);
    SongRepository songRepository = new SongRepository();

    public void showAnalytics() throws InterruptedException {
        int arr[] = { 100, 200, 300 };
        for (int i = 0; i < 3; i++) {
            System.out.print(
                    "                                                                       SONG " + i + 1 + ": ");
            for (int j = 10; j < arr[i]; j = j + 10) {
                System.out.print("█");
                try {
                    Thread.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            Thread.sleep(100);
            System.out.println();
        }
    }

    public void addSong() throws IOException {
        Song song = new Song();
        // -----------------------------inputs--------------------
        System.out.print("                                                                      Enter Song Id:-");
        int id = sc.nextInt();
        song.setId(id);
        System.out.print("                                                                      Enter Song Title:-");
        String title = sc.nextLine();
        song.setTitle(title);
        sc.nextLine();
        System.out
                .print(
                        "                                                                      Enter Song Duration(min):-");
        double duration = sc.nextDouble();
        song.setDuration(duration);
        // ----------------------------repo---------------------------------------------------

        songRepository.addSong(song);
    }
}
