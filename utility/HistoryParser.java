package utility;

import java.io.*;
import java.util.List;
import main_classes.Main;

public class HistoryParser {

    // Метод для считывания команд из файла в список
    public static void parseToList() {
        File file = new File("C:\\Users\\minec\\IdeaProjects\\Studing\\src\\utility\\history.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    Main.commandsList.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static void parseToFile() {
        File file = new File("C:\\Users\\minec\\IdeaProjects\\Studing\\src\\utility\\history.txt");

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            List<String> commands = Main.commandsList;

            for (String command : commands) {
                writer.println(command);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
