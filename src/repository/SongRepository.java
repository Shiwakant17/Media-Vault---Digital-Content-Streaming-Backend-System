package repository;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Song;
import model.User;

public class SongRepository {
    public void addSong(Song song) throws IOException {
        File songsFile = new File(
                "D:/Projects/Core JAVA/Media Vault - Digital Content & Streaming Backend System/Program/src/data/Songs.csv");
        if (!songsFile.exists()) {
            songsFile.createNewFile();
        }

        BufferedOutputStream bufferedOutputStreamSong = new BufferedOutputStream(
                new FileOutputStream(songsFile, true));

        int songId = song.getId();
        String songTitle = song.getTitle();
        double songDuration = song.getDuration();
        long songViews = 0;
        ArrayList<User> viewedUsers = new ArrayList<>();
        String songData = songId + "," + songTitle + "," + songDuration + "," + songViews + ","
                + ("USERS:-" + viewedUsers)
                + "\n";
        bufferedOutputStreamSong.write(songData.getBytes());
        bufferedOutputStreamSong.close();
        System.out.println(
                "                                                                           Added Successfully !!");
    }

    public void getAllSongs() throws FileNotFoundException {
        File songsFile = new File(
                "D:/Projects/Core JAVA/Media Vault - Digital Content & Streaming Backend System/Program/src/data/Songs.csv");

        BufferedInputStream bufferedInputStreamSongs = new BufferedInputStream(new FileInputStream(songsFile));

        Scanner scanSongs = new Scanner(bufferedInputStreamSongs);

        while (scanSongs.hasNextLine()) {
            String song = scanSongs.nextLine();
            System.out.println(song);
            System.out.println(song);
        }
    }
}
