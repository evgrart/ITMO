package utility;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class InputManager {
    public static Scanner consoleRead = new Scanner(System.in);
    public static boolean runningCommand = false;
    public static String[] input;
    public static void startInput() {
        try {
            do {
                input = consoleRead.nextLine().split(" ");
                String s = Reader.getLine(input);
            } while (true);
        } catch (NoSuchElementException e) {
            System.out.println("Ну зачем вам ломать мою программу(");
            System.exit(0);
        }

    }
}