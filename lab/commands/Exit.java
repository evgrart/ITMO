package lab.commands;

import lab.interfaces.Executable;

public class Exit extends Command implements Executable {
    public boolean execute() {
        System.out.println("Программа завершена");
        return false;
    }
}
