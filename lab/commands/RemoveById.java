package lab.commands;

import lab.interfaces.Executable;
import lab.main_classes.Main;
import lab.main_classes.StudyGroup;
import lab.utility.InputManager;

public class RemoveById extends Command implements Executable {
    public RemoveById(Object parameter) {
        super(parameter);
    }

    @Override
    public boolean validate() {
        try {
            Integer.parseInt((String) this.parameter);
            return true;
        } catch (NumberFormatException e) {
            if (parameter == null) {
                System.out.println("Добавьте id, где id - число");
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
        } else {
            Main.commandsList.add("remove_by_id");
            StudyGroup target = Main.ids.get(id);
            Main.groups.removeIf(group -> group.getId() == id);
            Main.ids.remove(id);
        }
    }
}
