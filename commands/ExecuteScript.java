package commands;

import exceptions.InvalidInputException;
import interfaces.Executable;
import interfaces.ValidatableCommand;
import main_classes.Main;
import utility.HistoryParser;
import utility.InputManager;
import utility.Reader;

import java.io.*;

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
    }
}