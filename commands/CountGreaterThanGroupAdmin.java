package commands;

import exceptions.InvalidInputException;
import interfaces.Executable;
import interfaces.ValidatableCommand;
import main_classes.Main;
import main_classes.StudyGroup;
import utility.HistoryParser;
import utility.PersonCreature;

public class CountGreaterThanGroupAdmin extends Command implements Executable, ValidatableCommand {
    public CountGreaterThanGroupAdmin(Object parameter) {
        super(parameter);
    }

    public boolean validate() {
        try {
            if (this.parameter == null) {
                return true;
            } else {
                throw new InvalidInputException("У count_greater_than_group_admin не должно быть аргументов!\nНачните инициализировать groupAdmin с новой строки");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void execute() {
        
        Main.commandsList.add("count_greater_than_group_admin");
        int count = 0;
        HistoryParser.parseToFile();
        String adminId = PersonCreature.createPerson().getPassportID();
        int target = 0;
        for (char c : adminId.toCharArray()) {
            target += (int) c;
        }
        for (StudyGroup group : Main.groups) {
            String id = group.getGroupAdmin().getPassportID();
            int sum = 0;
            for (char c : id.toCharArray()) {
                sum += (int) c;
            }
            if (sum > target) {
                count++;
            }
        }
        System.out.println("Выявлено совпадений: " + count + "\n");
    }
}
