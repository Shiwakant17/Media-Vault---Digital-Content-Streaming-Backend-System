package model;

import java.util.ArrayList;

public class User {
    String userId;
    String name;
    long phone;
    String email;
    String password;
    ArrayList<Integer> playedSongs = new ArrayList<>();
    public Subscription subscription = new Subscription();

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public ArrayList<Integer> getPlayedSongs() {
        return playedSongs;
    }

    public void setPlayedSongs(ArrayList<Integer> playedSongs) {
        this.playedSongs = playedSongs;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
