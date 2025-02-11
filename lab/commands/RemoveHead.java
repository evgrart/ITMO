package lab.commands;

import lab.interfaces.Executable;
import lab.main_classes.Main;
import lab.utility.InputManager;

public class RemoveHead extends Command implements Executable {
    public RemoveHead(Object parameter) {
        super(parameter);
    }

    @Override
    public void execute() {
        InputManager.runningCommand = false;
        Main.commandsList.add("remove_head");
        lab.utility.HistoryParser.parseToFile();
    }
}
