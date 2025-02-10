package lab.commands;

public class Command {
    public Object parameter;

    public Command(Object parameter) {
        this.parameter = parameter;
    }

    public void execute() {
        System.out.println("Такой команды нет! Используйте команду help, чтобы посмотреть список команд");
    }
}
