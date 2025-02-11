package lab.commands;

import lab.interfaces.Executable;
import lab.main_classes.Main;
import lab.utility.InputManager;

public class RemoveLower extends Command implements Executable {
    public RemoveLower(Object parameter) {
        super(parameter);
    }

    @Override
    public void execute() {
        InputManager.runningCommand = false;
        Main.commandsList.add("remove_lower");
        lab.utility.HistoryParser.parseToFile();
    }
}
