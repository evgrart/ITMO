package lab.commands;

import lab.interfaces.Executable;
import lab.main_classes.StudyGroup;

import java.util.Scanner;


public class Add extends Command implements Executable {
    public Add(Object parameter) {
        super(parameter);
    }

    public void execute() {
        Scanner sc = new Scanner(System.in);
        StudyGroup.StudyGroupBuilder group = StudyGroup.builder();
        System.out.println("Введите имя группы:");
    }
}
