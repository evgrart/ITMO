package lab.commands;

import lab.exceptions.InvalidInputException;
import lab.interfaces.Executable;
import lab.interfaces.ValidatableCommand;
import lab.utility.InputManager;
import lab.main_classes.StudyGroup;


public class Add extends Command implements Executable, ValidatableCommand {
    public Add(Object parameter) {
        super(parameter);
    }

    public boolean validate() {
        try {
            if (this.parameter.equals("{element}")) {
                return true;
            }
            else {
                throw new InvalidInputException("У add должен быть токен {element}!");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void execute() {
        InputManager.runningCommand = false;
        StudyGroup.StudyGroupBuilder group = StudyGroup.builder();
        System.out.println("Введите имя группы:");
        String consoleRead = InputManager.consoleRead.nextLine();
    }
}
