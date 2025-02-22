package utility;

import main_classes.Coordinates;
import main_classes.FormOfEducation;
import main_classes.Person;
import main_classes.StudyGroup;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static main_classes.Main.groups;

/**
 * Парсер из/в json
 *
 * @see commands.Save
 */
public class Parser {
    private static String FILE_NAME = "C:\\Users\\minec\\IdeaProjects\\Studing\\src\\utility\\collection.json";

    /**
     * Парсим в json
     */
    public static void toJson() {
        StringBuilder json = new StringBuilder("[");

        for (int i = 0; i < groups.size(); i++) {
            json.append(groups.get(i).toJson());
            if (i < groups.size() - 1) {
                json.append(",");
            }
        }
        json.append("\n]");

        try (PrintWriter writer = new PrintWriter(new File(FILE_NAME))) {
            writer.println(json);
            System.out.println("Коллекция записана в json");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    /**
     * Парсим из json
     */
    public static void fromJson() {
        StudyGroup.StudyGroupBuilder group = null;
        Coordinates.CoordinatesBuilder coordinates = null;
        Person.PersonBuilder person = Person.builder();
        StringBuilder file = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while (!(line = reader.readLine()).equals("]")) {
                file.append(line.trim());

            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        String[] json = String.valueOf(file).substring(1).trim().split(",");
        if (json.length > 1) {
            for (String s : json) {
                String key = s.split(":", 2)[0].trim().replaceAll("[{},:\"]", "");
                String value = s.split(":", 2)[1].trim();
                if (key.equals("id")) {
                    group = StudyGroup.builder();
                    group.id(Integer.parseInt(value));
                } else {
                    switch (key) {
                        case "name":
                            group.name(value.substring(1, value.length() - 1).trim());
                            break;
                        case "coordinates":
                            coordinates = Coordinates.builder();
                            coordinates.x(Double.parseDouble(value.split(" ")[1].trim()));
                            break;
                        case "y":
                            coordinates.y(Double.parseDouble(value.substring(0, value.length() - 1)));
                            group.coordinates(coordinates.build());
                            break;
                        case "creationDate":
                            ZonedDateTime date = ZonedDateTime.parse(value.substring(1, value.length() - 1));
                            group.creationDate(date);
                            break;
                        case "studentsCount":
                            group.studentsCount(Integer.parseInt(value));
                            break;
                        case "expelledStudents":
                            group.expelledStudents(Integer.parseInt(value));
                            break;
                        case "shouldBeExpelled":
                            group.shouldBeExpelled(Integer.parseInt(value));
                            break;
                        case "formOfEducation":
                            if (value.equals("null")) {
                            } else {
                                group.formOfEducation(FormOfEducation.valueOf(value.substring(1, value.length() - 1)));
                            }
                            break;
                        case "groupAdmin":
                            if (!value.equals("null}")) {
                                person.name(value.split(":")[1].replaceAll("[\"]", "").trim());
                            } else {
                                CollectionManager.add(group.build());
                            }
                            break;
                        case "birthday":
                            String line = value.split("T")[0] + " " + value.split("T")[1];
                            LocalDateTime dateTime = LocalDateTime.parse(line.substring(1, line.length() - 1), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                            person.birthday(dateTime);
                            break;
                        case "height":
                            person.height(Integer.parseInt(value));
                            break;
                        case "weight":
                            person.weight(Integer.parseInt(value));
                            break;
                        case "passportID":
                            person.passportID(value.substring(1, value.length() - 3));
                            group.groupAdmin(person.build());
                            CollectionManager.add(group.build());
                            break;
                    }
                }
            }
        }
    }
}

