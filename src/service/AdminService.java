package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import data.SongList;
import model.Greetings;
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

    public void showSongs() throws FileNotFoundException {
        songRepository.getAllSongs();
    }

    public void searchSong() throws InterruptedException, FileNotFoundException {
        System.out
                .println(
                        "                                                                      Enter By id(1):-");
        System.out
                .print(
                        "                                                                      Enter By Name(2):-");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                searchById();
                break;

            case 2:
                searchByName();
                break;

            default:
                break;
        }
    }

    public static void searchById() throws InterruptedException, FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        SongList songList = new SongList();
        Greetings greetings = new Greetings();
        songList.loadsongList();
        ArrayList<Song> list = songList.getSongList();
        System.out
                .print(
                        "                                                                      Enter Id:-");
        int searchId = sc.nextInt();
        // --------SEARCHING [BINARY]-------
        int l = 0;
        int h = list.size() - 1;

        if (list.isEmpty()) {
            greetings.load10s();
            System.out.println("SORRY CAN'T GET");
            return;
        }

        Song foundSong = new Song();

        while (l <= h) {
            int mid = (l + h) / 2;
            if (list.get(mid).getId() == searchId) {
                foundSong = list.get(mid);
                break;
            } else if (list.get(mid).getId() > searchId) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        String singlePadding = " ".repeat(67);
        System.out.println(singlePadding + "------------------------------------");
        System.out.printf(singlePadding + "| %-34s |%n", "");
        System.out.printf(singlePadding + "| Name:- %-27s |%n", foundSong.getTitle());
        System.out.printf(singlePadding + "| %-34s |%n", "");
        System.out.printf(singlePadding + "| Duration:- %-23s |%n", foundSong.getDuration());
        System.out.printf(singlePadding + "| %-34s |%n", "");
        System.out.printf(singlePadding + "| Id:- %-29s |%n", foundSong.getId());
        System.out.printf(singlePadding + "| %-34s |%n", "");
        System.out.printf(singlePadding + "| Views:- %-26s |%n", foundSong.getViews());
        System.out.printf(singlePadding + "| %-34s |%n", "");
        System.out.println(singlePadding + "------------------------------------");

    }

    public static void searchByName() {
        Scanner sc = new Scanner(System.in);
        System.out
                .print(
                        "                                                                      Enter Name:-");
        String searchName = sc.next();
        searchName.trim();
    }
}
