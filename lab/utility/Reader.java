package lab.utility;


import lab.exceptions.InvalidInputException;

public class Reader {
    public static void getLine(String[] line) {
        try {
            if (line.length == 1) {
                Reader.toCommand((String) line[0], null);
            } else if (line.length == 2) {
                if (line[0].equals("update")) {
                    throw new InvalidInputException("Команда update должна быть формата update id {element}");
                }
                Reader.toCommand((String) line[0], (String) line[1]);
            } else if (line.length == 3) {
                if (line[0].equals("update") && line[1].matches("\\d+") && line[2].equals("{element}")) {
                    Reader.toCommand((String) line[0], (String) line[1]);
                } else {
                    throw new InvalidInputException("Команда update должна быть формата update id {element}");
                }
            } else {
                throw new InvalidInputException("Такой команды нет! Используйте команду help, чтобы посмотреть список команд");
            }
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void toCommand(String command, Object parameter) {
        CommandReader executableCommand = new CommandReader(parameter);
        executableCommand.runCommand(command);
    }
}
