package lab.main_classes;

import lab.utility.Reader;
import lab.utility.parseHistory;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> commandsList = new ArrayList<>();

    public static void main(String[] args) {
        parseHistory.parse();
        Scanner consoleRead = new Scanner(System.in);
        while (true) {
            String[] splitedConsoleRead = consoleRead.nextLine().split(" ");
            Reader.getLine(splitedConsoleRead);
        }
    }
}

//проблема с потоками

