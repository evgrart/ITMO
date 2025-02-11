package lab.commands;

import lab.interfaces.Executable;
import lab.main_classes.Main;
import lab.utility.InputManager;

public class Clear extends Command implements Executable {
    public Clear(Object parameter) {
        super(parameter);
    }

    @Override
    public void execute() {
        InputManager.runningCommand = false;
        Main.commandsList.add("clear");
        lab.utility.HistoryParser.parseToFile();
    }
}
