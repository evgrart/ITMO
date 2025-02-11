package lab.commands;

import lab.interfaces.Executable;
import lab.main_classes.Main;
import lab.utility.InputManager;

public class CountGreaterThanGroupAdmin extends Command implements Executable {
    public CountGreaterThanGroupAdmin(Object parameter) {
        super(parameter);
    }

    @Override
    public void execute() {
        InputManager.runningCommand = false;
        Main.commandsList.add("count_greater_than_group_admin");
        lab.utility.HistoryParser.parseToFile();
    }
}
