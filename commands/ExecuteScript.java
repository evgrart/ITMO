package commands;

import exceptions.InvalidInputException;
import interfaces.Executable;
import interfaces.ValidatableCommand;
import main_classes.Main;
import utility.HistoryParser;
import utility.InputManager;
import utility.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        InputManager.runningCommand = true;
        HistoryParser.parseToFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(this.FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] input = line.split(" ");
                Reader.getLine(input);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage() + "\nПерепроверьте, существует ли такой файл.\n");
        } catch (StackOverflowError e) {
            System.out.println("Ай-ай-ай, рекурсия!\n");
        }

    }
}