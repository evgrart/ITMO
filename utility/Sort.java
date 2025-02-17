package utility;

import main_classes.Main;

import java.util.Comparator;

public class Sort {
    public static void sort() {
        Main.groups.sort(Comparator.comparingInt(p -> p.getId()));
    }
}
