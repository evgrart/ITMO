package lab.utility;


import lab.exceptions.InvalidInputException;

public class Reader {
    public static void getLine(String[] line) {
        try {
            if (line.length == 1) {
                Reader.toCommand((String) line[0]);
            } else if (line.length == 2) {
                Reader.toCommand((String) line[0]);
            } else if (line.length == 3) {
                Reader.toCommand((String) line[0]);
            } else {
                throw new InvalidInputException("Такой команды нет! Используйте команду help, чтобы посмотреть список команд");
            }
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void toCommand(String command) {
        CommandReader executableCommand = new CommandReader();
        executableCommand.runCommand(command);
    }
}
