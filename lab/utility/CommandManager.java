package lab.utility;

import lab.commands.*;

import java.util.HashMap;

public class CommandManager {
    HashMap<String, Command> commands = new HashMap<>();

    public CommandManager(Object parameter) {
        commands.put("help", new Help(parameter));
        commands.put("info", new Info(parameter));
        commands.put("show", new Show(parameter));
        commands.put("add", new Add(parameter));
        commands.put("update", new Update(parameter));
        commands.put("remove_by_id", new RemoveById(parameter));
        commands.put("clear", new Clear(parameter));
        commands.put("save", new Save(parameter));
        commands.put("execute_script", new ExecuteScript(parameter));
        commands.put("exit", new Exit(parameter));
        commands.put("remove_head", new RemoveHead(parameter));
        commands.put("remove_lower", new RemoveLower(parameter));
        commands.put("history", new History(parameter));
        commands.put("remove_all_by_group_admin", new RemoveAllByGroupAdmin(parameter));
        commands.put("count_greater_than_group_admin", new CountGreaterThanGroupAdmin(parameter));
        commands.put("filter_greater_than_form_of_education", new FilterGreaterThanFormOfEducation(parameter));
    }

    void runCommand(String cm) {
        if (commands.containsKey(cm)) {
            Command command = commands.get(cm);
            if (command.validate()) {
                command.execute();
            } else {
                InputManager.create();
            }
        } else {
            Command command = new Command(null);
            InputManager.runningCommand = true;
            command.execute();
        }
    }

}
