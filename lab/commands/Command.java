package lab.commands;

import lab.interfaces.Executable;
import lab.utility.InputManager;

public class Command implements Executable {
    public Object parameter;

    public Command(Object parameter) {
        this.parameter = parameter;
    }

    public boolean validate() {
        return true;
    }

    public void execute() {
        InputManager.runningCommand = false;
        System.out.println("Такой команды нет! Используйте команду help, чтобы посмотреть список команд");
    }
}
