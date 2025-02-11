package lab.commands;

import lab.interfaces.Executable;
import lab.main_classes.Main;
import lab.utility.InputManager;

public class RemoveAllByGroupAdmin extends Command implements Executable {
    public RemoveAllByGroupAdmin(Object parameter) {
        super(parameter);
    }

    @Override
    public void execute() {
        InputManager.runningCommand = false;
        Main.commandsList.add("remove_all_by_group_admin");
        lab.utility.HistoryParser.parseToFile();
    }
}
