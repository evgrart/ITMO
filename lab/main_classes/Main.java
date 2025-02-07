package lab.main_classes;

import java.util.Scanner;

import lab.utility.Reader;

public class Main {
    public static void main(String[] args) {
        boolean flag;
        Scanner consoleRead = new Scanner(System.in);
        do {
            String[] splitedConsoleRead = consoleRead.nextLine().split(" ");
            flag = Reader.getLine(splitedConsoleRead);
        } while (flag);
    }
}

//проблема с потоками

