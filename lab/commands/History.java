package lab.commands;

import lab.exceptions.InvalidInputException;
import lab.interfaces.Executable;
import lab.main_classes.Main;
import lab.utility.InputManager;

public class History extends Command implements Executable {
    public History(Object parameter) {
        super(parameter);
    }

    public boolean validate() {
        try {
            if (this.parameter == null) {
                return true;
            }
            else {
                throw new InvalidInputException("У history не должно быть аргументов!");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static final String FILE_PATH = "C:\\Users\\minec\\IdeaProjects\\Studing\\src\\lab\\utility\\history.txt";
    int startIndex = Math.max(0, Main.commandsList.size() - 8);

    @Override
    public void execute() {
        Main.commandsList.add("history");
        InputManager.runningCommand = false;
        for (int i = Main.commandsList.size() - 1; i >= startIndex; i--) {
            System.out.println(Main.commandsList.get(i));
        }
        System.out.println();
    }
}
