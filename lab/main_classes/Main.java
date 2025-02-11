package lab.main_classes;


import lab.utility.HistoryParser;
import lab.utility.InputManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static ArrayList<String> commandsList = new ArrayList<>();
    public static LinkedList<StudyGroup> groups = new LinkedList<>();
    public static HashMap<Integer, StudyGroup> ids = new HashMap<>();

    public static void main(String[] args) {
        HistoryParser.parseToList();
        InputManager.create();
    }
}



