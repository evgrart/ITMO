package lab.commands;

import lab.interfaces.Executable;
import lab.interfaces.ValidatableCommand;
import lab.main_classes.Main;
import lab.main_classes.StudyGroup;
import lab.utility.InputManager;
import lab.utility.GroupCreature;

public class Update extends Command implements Executable, ValidatableCommand {
    public Update(Object parameter) {
        super(parameter);
    }

    @Override
    public boolean validate() {
        try {
            Integer.parseInt((String) this.parameter);
            return true;
        } catch (NumberFormatException e) {
            if (parameter == null) {
                System.out.println("Добавьте id {element}, где id - число");
            } else {
                System.out.println("id должен быть числом! Введите команду ещё раз");
            }
            return false;
        }
    }

    @Override
    public void execute() {
        InputManager.runningCommand = false;
        Integer id = Integer.parseInt((String) this.parameter);
        if (!Main.ids.containsKey(id)) {
            System.out.println("Объект по заданному id не найден\n");
        }
        else {
            Main.commandsList.add("update");
            lab.utility.HistoryParser.parseToFile();
            StudyGroup group = GroupCreature.createGroup();
            Main.ids.remove(id);
            Main.ids.put(group.getId(), group);
            System.out.println("Объект под старым id " + id + " был изменён.\n" +
                    "id нового объекта - " + group.getId() + "\n");
        }
    }
}
