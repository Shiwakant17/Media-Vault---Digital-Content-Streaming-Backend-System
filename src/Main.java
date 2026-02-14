import java.util.Scanner;

import model.Greetings;
import service.Menu;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // IMPORTS
        Greetings greetings = new Greetings();
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);

        // LOGICS
        while (true) {
            greetings.welcome();
            System.out.print("                                                                           ENTER:- ");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    menu.userMenu();
                    break;

                case 2:
                    menu.AdminMenu();
                    break;

                default: {
                    System.out.println(
                            "                                                                           THANK's (EXITED)");
                    System.exit(input);
                    break;
                }
            }
        }
    }
}
