package lab.main_classes;


import lab.utility.HistoryParser;
import lab.utility.InputManager;

import java.util.ArrayList;

public class Main {
    public static ArrayList<String> commandsList = new ArrayList<>();

    public static void main(String[] args) {
        HistoryParser.parse();
        InputManager.create();
    }
}

//TODO: история должна сохраняться без exit

