package reader_manager;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class InputManager {
    public static Scanner consoleRead = new Scanner(System.in);
    private static final InputStream DEFAULT_IN = System.in;

    public static String readInput() {
        if (consoleRead.hasNextLine()) {
            return consoleRead.nextLine(); // Читаем строку из текущего ввода (файл или консоль)
        } else {
            restoreStandardInput(); // Возвращаем ввод на клавиатуру
            return consoleRead.nextLine(); // Читаем с клавиатуры
        }
    }

    public static void startInput() {
        try {
            do {
                String ConsoleRead = readInput();
                Reader.getLine(ConsoleRead);
            } while (true);
        } catch (NoSuchElementException e) {
            System.out.println("Ну зачем вам ломать мою программу(");
            System.exit(0);
        }

    }

    public static void restoreStandardInput() {
        System.setIn(DEFAULT_IN);
        InputManager.consoleRead = new Scanner(System.in);
    }
}