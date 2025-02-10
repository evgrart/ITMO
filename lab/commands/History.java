package lab.commands;

import lab.interfaces.Executable;
import lab.main_classes.Main;

public class History extends Command implements Executable {
    public History(Object parameter) {
        super(parameter);
    }

    private static final String FILE_PATH = "C:\\Users\\minec\\IdeaProjects\\Studing\\src\\lab\\utility\\history.txt";
    int startIndex = Math.max(0, Main.commandsList.size() - 8);

    public void execute() {
        for (int i = Main.commandsList.size() - 1; i >= startIndex; i--) {
            System.out.println(Main.commandsList.get(i));
        }
    }
}
