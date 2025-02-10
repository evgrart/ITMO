package lab.commands;

import lab.exceptions.InvalidInputException;
import lab.interfaces.Executable;
import lab.main_classes.Main;
import lab.utility.InputManager;
import lab.interfaces.ValidatableCommand;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Exit extends Command implements Executable, ValidatableCommand {
    public Exit(Object parameter) {
        super(parameter);
    }

    public boolean validate() {
        try {
            if (this.parameter == null) {
                return true;
            }
            else {
                throw new InvalidInputException("У exit не должно быть аргументов!");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void execute() {
        InputManager.runningCommand = false;
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
