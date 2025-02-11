package lab.commands;

import lab.exceptions.InvalidInputException;
import lab.interfaces.Executable;
import lab.interfaces.ValidatableCommand;
import lab.main_classes.Main;
import lab.utility.InputManager;
import lab.utility.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteScript extends Command implements Executable, ValidatableCommand {
    private final String FILE_NAME = (String) this.parameter;

    public boolean validate() {
        try {
            if (this.parameter != null) {
                return true;
            } else {
                throw new InvalidInputException("У execute_script должен быть аргумент: путь до файла!");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ExecuteScript(Object parameter) {
        super(parameter);
    }

    @Override
    public void execute() {
        Main.commandsList.add("execute_script");
        InputManager.runningCommand = false;
        lab.utility.HistoryParser.parseToFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String[] input = reader.readLine().split(" ");
            Reader.getLine(input);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage() + "\n" + "Перепроверьте, " +
                    "существует ли такой файл.\n");
        }
    }
}
