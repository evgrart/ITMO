package commands;

import exceptions.InvalidInputException;
import interfaces.Executable;
import interfaces.ValidatableCommand;
import main_classes.Main;
import utility.CollectionManager;
import utility.HistoryParser;

public class Info extends Command implements Executable, ValidatableCommand {
    public Info(Object parameter) {
        super(parameter);
    }

    public boolean validate() {
        try {
            if (this.parameter == null) {
                return true;
            } else {
                throw new InvalidInputException("У info не должно быть аргументов!");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void execute() {
        
        Main.commandsList.add("info");
        HistoryParser.parseToFile();
        System.out.println("Информация о коллекции:");
        CollectionManager.info();
    }
}
