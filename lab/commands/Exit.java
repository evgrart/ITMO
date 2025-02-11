package lab.commands;

import lab.exceptions.InvalidInputException;
import lab.interfaces.Executable;
import lab.interfaces.ValidatableCommand;
import lab.main_classes.Main;
import lab.utility.InputManager;

public class Exit extends Command implements Executable, ValidatableCommand {
    public Exit(Object parameter) {
        super(parameter);
    }

    public boolean validate() {
        try {
            if (this.parameter == null) {
                return true;
            } else {
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
        Main.commandsList.add("exit");
        lab.utility.HistoryParser.parseToFile();
        System.out.println("Программа завершена");

        System.exit(0);
    }
}
