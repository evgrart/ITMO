package lab.commands;

import lab.exceptions.InvalidInputException;
import lab.interfaces.Executable;
import lab.interfaces.ValidatableCommand;
import lab.main_classes.Main;
import lab.main_classes.StudyGroup;
import lab.utility.InputManager;
import lab.utility.GroupCreature;



public class Add extends Command implements Executable, ValidatableCommand {
    public Add(Object parameter) {
        super(parameter);
    }

    public boolean validate() {
        try {
            if (this.parameter.equals("{element}")) {
                return true;
            } else {
                throw new InvalidInputException("У add должен быть токен {element}!");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void execute() {
        InputManager.runningCommand = false;
        Main.commandsList.add("add {element}");
        lab.utility.HistoryParser.parseToFile();
        System.out.println("Инициализировано создание объекта для добавления его в коллекцию");
        StudyGroup result = GroupCreature.createGroup();
        Main.groups.add(result);
        System.out.println("Создание StudyGroup завершено! Его id: " + result.getId() + "\n");
        Main.ids.put(result.getId(), result);
    }
}
