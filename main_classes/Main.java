package main_classes;


import utility.HistoryParser;
import reader_manager.InputManager;
import utility.Parser;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static ZonedDateTime time = ZonedDateTime.now();
    public static ArrayList<String> commandsList = new ArrayList<>();
    public static LinkedList<StudyGroup> groups = new LinkedList<>();
    public static HashMap<Integer, StudyGroup> ids = new HashMap<>();

    public static void main(String[] args) {
        Parser.fromJson();
        HistoryParser.parseToList();
        InputManager.startInput();
    }
}