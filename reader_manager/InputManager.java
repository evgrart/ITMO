package reader_manager;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class InputManager {
    public static Scanner consoleRead = new Scanner(System.in);

    public static void startInput() {
        try {
            do {
                String ConsoleRead = consoleRead.nextLine();
                Reader.getLine(ConsoleRead);
            } while (true);
        } catch (NoSuchElementException e) {
            System.out.println("Ну зачем вам ломать мою программу(");
            System.exit(0);
        }

    }
}