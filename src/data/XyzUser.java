package data;

import java.util.ArrayList;

public class XyzUser {
    String userId;
    String email;
    ArrayList<Integer> playlistSongs;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Integer> getPlaylistSongs() {
        return playlistSongs;
    }

    public void setPlaylistSongs(ArrayList<Integer> playlistSongs) {
        this.playlistSongs = playlistSongs;
    }
}
