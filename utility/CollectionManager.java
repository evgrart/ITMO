package utility;

import main_classes.Main;
import main_classes.StudyGroup;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionManager {
    static LinkedList<StudyGroup> list = Main.groups;

    public static void remove_by_id(Integer id) {
        list.removeIf(group -> group.getId() == id);
        Main.ids.remove(id);
    }

    public static void info() {
        System.out.println("Тип: LinkedList");
        System.out.println("Дата инициализации: " + Main.time.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        System.out.println("Количество элементов: " + list.size() + "\n");
    }

    public static void add(StudyGroup result) {
        Main.groups.add(result);
        Main.ids.put(result.getId(), result);
    }

    public static void show(StudyGroup el) {
        System.out.println(el);
    }

    public static void clear() {
        Main.groups.clear();
        Main.ids.clear();
    }

    public static void remove_head() {
        if (!Main.groups.isEmpty()) {
            StudyGroup head = Main.groups.get(0);
            Integer id = head.getId();
            show(head);
            remove_by_id(id);
        } else {
            System.out.println("Коллекция пуста!");
        }
    }

    public static void update(Integer id) {
        StudyGroup group = GroupCreature.createGroup();
        Main.ids.remove(id);

        int index = -1;
        for (int i = 0; i < Main.groups.size(); i++) {
            StudyGroup el = Main.groups.get(i);
            if (el.getId() == id) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            Main.groups.set(index, group);
            Main.ids.put(group.getId(), group);
            System.out.println("Объект под старым id " + id + " был изменён.\nНовый id объекта - " + group.getId() + "\n");
        } else {
            System.out.println("Объект с указанным id не найден.");
        }
    }

    public static void remove_lower(Integer id) {
        if (!Main.ids.containsKey(id)) {
            System.out.println("Объект по заданному id не найден\n");
        } else {
            List<StudyGroup> toRemove = new ArrayList<>();
            boolean isRemoved = false;

            for (StudyGroup el : list) {
                if (el.getId() < id) {
                    System.out.println("Элемент с id " + el.getId() + " был удалён");
                    toRemove.add(el);
                    Main.ids.remove(el.getId());
                    isRemoved = true;
                }
            }

            if (!isRemoved) {
                System.out.println("Введённый элемент является минимальным в коллекции");
            }

            Main.groups.removeAll(toRemove);
            System.out.println();
        }
    }
}
