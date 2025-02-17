package utility;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class InputManager {
    public static boolean runningCommand = true;
    public static Scanner consoleRead = new Scanner(System.in);

    public static String getInput() {
        return consoleRead.nextLine();
    }

    public static void startInput() {
        try {
            do {
                String[] splitedConsoleRead = consoleRead.nextLine().split(" ");
                if (runningCommand) {
                    Reader.getLine(splitedConsoleRead);
                } else {
                    getInput();
                }
            } while (true);
        } catch (NoSuchElementException e) {
            System.out.println("Ну зачем вам ломать мою программу(");
            System.exit(0);
        }

    }
}