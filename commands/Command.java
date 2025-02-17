package commands;

import interfaces.Executable;
import interfaces.ValidatableCommand;
import utility.InputManager;

public class Command implements Executable, ValidatableCommand {
    public Object parameter;

    public Command(Object parameter) {
        this.parameter = parameter;
    }

    public boolean validate() {
        return true;
    }

    public void execute() {
        System.out.println("Такой команды нет! Используйте команду help, чтобы посмотреть список команд");
    }
}