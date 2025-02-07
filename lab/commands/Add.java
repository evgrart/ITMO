package lab.commands;

import lab.interfaces.Executable;
import lab.main_classes.*;
import java.util.Scanner;


public class Add extends Command implements Executable {
    public boolean execute() {
        Scanner sc = new Scanner(System.in);
        StudyGroup.StudyGroupBuilder group = StudyGroup.builder();
        boolean flag = true;
        System.out.println("Введите имя группы:");
        return true;
    }
}
