package lab.commands;

import lab.interfaces.Executable;
import lab.main_classes.*;
import java.util.Scanner;


public class Add extends Command implements Executable {
    public void execute() {
        Scanner sc = new Scanner(System.in);
        StudyGroup.StudyGroupBuilder group = StudyGroup.builder();
        System.out.println("Введите имя группы:");
    }
}
