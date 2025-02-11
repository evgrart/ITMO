package lab.commands;

import lab.interfaces.Executable;
import lab.main_classes.Main;
import lab.utility.InputManager;

public class FilterGreaterThanFormOfEducation extends Command implements Executable {
    public FilterGreaterThanFormOfEducation(Object parameter) {
        super(parameter);
    }

    @Override
    public void execute() {
        InputManager.runningCommand = false;
        Main.commandsList.add("filter_greater_than_form_of_education");
        lab.utility.HistoryParser.parseToFile();
    }
}
