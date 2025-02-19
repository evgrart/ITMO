package commands;

import exceptions.InvalidInputException;
import interfaces.Executable;
import interfaces.ValidatableCommand;
import main_classes.Main;
import reader_manager.InputManager;
import utility.HistoryParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExecuteScript extends Command implements Executable, ValidatableCommand {
    private final String FILE_NAME;

    public ExecuteScript(Object parameter) {
        super(parameter);
        this.FILE_NAME = (String) this.parameter;
    }

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

    public void execute() {
        Main.commandsList.add("execute_script");
        HistoryParser.parseToFile();

        try {
            System.setIn(new FileInputStream(FILE_NAME));
            InputManager.consoleRead = new Scanner(System.in);
            InputManager.startInput();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage() + "\nПерепроверьте, существует ли такой файл.\n");
        } catch (StackOverflowError e) {
            System.out.println("Ай-ай-ай, рекурсия!");
        }

    }
}

//execute_script C:\Users\minec\Desktop\text.txt