package lab.commands;

import lab.interfaces.Executable;
import lab.interfaces.ValidatableCommand;
import lab.utility.InputManager;

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
    }
}
