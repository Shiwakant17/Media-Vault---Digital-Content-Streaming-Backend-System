package controller;

import java.io.IOException;
import java.util.Scanner;

import model.Greetings;
import model.User;
import service.AdminService;
import service.LoggedInUserService;
import service.Menu;
import service.UserService;

public class LoggedInUserController {
    Menu menu = new Menu();
    Scanner sc = new Scanner(System.in);
    Greetings greetings = new Greetings();
    AdminService adminService = new AdminService();
    LoggedInUserService loggedInUserService = new LoggedInUserService();
    UserService userService =  new UserService();


    public void loggedInUser(User user) throws InterruptedException, IOException {
        while (true) {
            menu.LoggedInUser();
            greetings.enter();
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    loggedInUserService.playSongs();
                    break;

                case 2:
                    adminService.searchSong();
                    break;
                case 3:
                    userService.trendingTop10Songs();
                    break;

                case 4:
                    adminService.showSongs();
                    break;

                case 5:
                    loggedInUserService.appendSongToPlayList(user);
                    break;

                default:
                    return;
            }
        }
    }
}