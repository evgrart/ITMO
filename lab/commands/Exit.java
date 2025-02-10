package lab.commands;

import lab.interfaces.Executable;
import lab.main_classes.Main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Exit extends Command implements Executable {
    public void execute() {
        System.out.println("Программа завершена");

        try (PrintWriter writer = new PrintWriter(new File("C:\\Users\\minec\\IdeaProjects\\Studing\\src\\lab\\utility\\history.txt"))) {
            for (String command : Main.commandsList) {
                writer.println(command);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }

        System.exit(0);
    }
}
