package lab.utility;


import lab.InvalidInputException;

public class Reader {
    public static boolean getLine(String[] line) {
        if (line.length == 1) {
            return Reader.toCommand((String) line[0]);
        }
        else if (line.length == 2) {
            return Reader.toCommand((String) line[0]);
        }
        return true;
//        else {
//            throw new InvalidInputException("Invalid number of arguments");
//        }
    }

    private static boolean toCommand(String command) {
        CommandReader executableCommand = new CommandReader();
        return executableCommand.runCommand(command);
    }
}
