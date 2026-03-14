package model;

import java.io.IOException;
import java.util.ArrayList;

import data.UserList;
import repository.UserRepository;
import service.UserService;

public class Playlist {
    public void pushToPlayList(User user, Song song) throws IOException {
        UserList userList = new UserList();
        UserService userService = new UserService();
        UserRepository userRepository = new UserRepository();
        userList.loadUserList();

        ArrayList<User> allUsers = new ArrayList<>();
        allUsers = userList.getUserList();

        boolean foundUser = false;
        int idx = -1;

        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getEmail().equalsIgnoreCase(user.getEmail())) {
                foundUser = true;
                idx = i;
                break;
            }
        }

        if (foundUser == false) {
            System.out.println(
                    "                                                                                  REGISTER  PLEASE     ");
            System.out.println(
                    "                                                                                  CLICK 1 FOR REGISTRATION     ");
            userService.registerUser();
            return;
        } else {
            String userEmail = allUsers.get(idx).getEmail();
            userRepository.addSongToPlayList(userEmail, song);
        }
    }
}
