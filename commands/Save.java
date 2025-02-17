package commands;

import exceptions.InvalidInputException;
import interfaces.Executable;
import interfaces.ValidatableCommand;
import main_classes.Main;
import utility.HistoryParser;
import utility.InputManager;
import utility.Parser;

public class Save extends Command implements Executable, ValidatableCommand {
    public Save(Object parameter) {
        super(parameter);
    }

    public boolean validate() {
        try {
            if (this.parameter == null) {
                return true;
            } else {
                throw new InvalidInputException("У save не должно быть аргументов!");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void execute() {
        InputManager.runningCommand = true;
        Main.commandsList.add("save");
        HistoryParser.parseToFile();
        Parser.toJson();
        Parser.fromJson();
        System.out.println();
    }
}
