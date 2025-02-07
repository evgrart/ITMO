package lab.utility;

import lab.commands.*;

import java.util.HashMap;

public class CommandReader {
    HashMap<String, Command> commands = new HashMap<>();

    public CommandReader() {
        commands.put("help", new Help());
        commands.put("info", new Info());
        commands.put("show", new Show());
        commands.put("add", new Add());
        commands.put("update", new Update());
        commands.put("remove_by_id", new RemoveById());
        commands.put("clear", new Clear());
        commands.put("save", new Save());
        commands.put("execute_script", new ExecuteScript());
        commands.put("exit", new Exit());
        commands.put("remove_head", new RemoveHead());
        commands.put("remove_lower", new RemoveLower());
        commands.put("history", new History());
        commands.put("remove_all_by_group_admin", new RemoveAllByGroupAdmin());
        commands.put("count_greater_than_group_admin", new CountGreaterThanGroupAdmin());
        commands.put("filter_greater_than_form_of_education", new FilterGreaterThanFormOfEducation());
    }

    boolean runCommand(String line) {
        if (commands.containsKey(line)) {
            Command command = commands.get(line);
            return command.execute();
        } else {
            Command command = new Command();
            return command.execute();
        }
    }

}
