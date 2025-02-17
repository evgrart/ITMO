package commands;

import exceptions.InvalidInputException;
import interfaces.Executable;
import interfaces.ValidatableCommand;
import main_classes.Main;
import utility.HistoryParser;
import utility.InputManager;

public class History extends Command implements Executable, ValidatableCommand {
    private static final String FILE_PATH = "C:\\Users\\minec\\IdeaProjects\\Studing\\src\\lab\\utility\\history.txt";
    int startIndex;

    public History(Object parameter) {
        super(parameter);
        this.startIndex = Math.max(0, Main.commandsList.size() - 8);
    }

    public boolean validate() {
        try {
            if (this.parameter == null) {
                return true;
            } else {
                throw new InvalidInputException("У history не должно быть аргументов!");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void execute() {
        Main.commandsList.add("history");
        HistoryParser.parseToFile();

        for (int i = Main.commandsList.size() - 1; i >= this.startIndex; --i) {
            System.out.println(Main.commandsList.get(i));
        }

        System.out.println();
    }
}
