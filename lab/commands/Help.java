package lab.commands;

import lab.interfaces.Executable;
import lab.interfaces.ValidatableCommand;
import lab.exceptions.InvalidInputException;
import lab.main_classes.Main;
import lab.utility.InputManager;

public class Help extends Command implements Executable, ValidatableCommand {
    public Help(Object parameter) {
        super(parameter);
    }

    public boolean validate() {
        try {
            if (this.parameter == null) {
                return true;
            }
            else {
                throw new InvalidInputException("У help не должно быть аргументов!");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private final String helpMessage =
            "help : вывести справку по доступным командам\n" +
                    "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                    "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                    "add {element} : добавить новый элемент в коллекцию\n" +
                    "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                    "remove_by_id id : удалить элемент из коллекции по его id\n" +
                    "clear : очистить коллекцию\n" +
                    "save : сохранить коллекцию в файл\n" +
                    "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                    "exit : завершить программу (без сохранения в файл)\n" +
                    "remove_head : вывести первый элемент коллекции и удалить его\n" +
                    "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                    "history : вывести последние 8 команд (без их аргументов)\n" +
                    "remove_all_by_group_admin groupAdmin : удалить из коллекции все элементы, значение поля groupAdmin которого эквивалентно заданному\n" +
                    "count_greater_than_group_admin groupAdmin : вывести количество элементов, значение поля groupAdmin которых больше заданного\n" +
                    "filter_greater_than_form_of_education formOfEducation : вывести элементы, значение поля formOfEducation которых больше заданного";

    @Override
    public void execute() {
        InputManager.runningCommand = false;
        Main.commandsList.add("help");
        System.out.println(helpMessage);
    }
}
