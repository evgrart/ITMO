package lab.utility;


import lab.exceptions.InvalidInputException;

public class Reader {
    public static void getLine(String[] line) {
        try {
            if (line[0].equals("")) {
                InputManager.create();
            } else if (line.length == 1) {
                Reader.toCommand((String) line[0], null);
            } else if (line.length == 2) {
                if (line[0].equals("update")) {
                    System.out.println("Добавьте токен {element}");
                    InputManager.create();
                }
                Reader.toCommand((String) line[0], (String) line[1]);
            } else {
                if (line[0].equals("update") && line[1].matches("\\d+") && line[2].equals("{element}")) {
                    Reader.toCommand((String) line[0], (String) line[1]);
                } else if (line[0].equals("update")) {
                    throw new InvalidInputException("Команда update должна быть вида update id {element}, где id - число");
                } else {
                    throw new InvalidInputException("Слишком длинная команда, используйте help для вывода списка команд");
                }
            }
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void toCommand(String command, Object parameter) {
        CommandManager executableCommand = new CommandManager(parameter);
        executableCommand.runCommand(command);
    }
}
