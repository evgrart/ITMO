package utility;

import main_classes.Main;

import java.io.*;
import java.util.List;

/**
 * Сериализует в {@link Main#commandsList} / десериализует в файлик .txt (для хранения истории за предыдущие сеансы) предыдущие команды юзера
 *
 * @see commands.History
 */

public class HistoryParser {

    /**
     * Десериализация в {@link Main#commandsList}
     */
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

    /**
     * Парсим из {@link Main#commandsList} в файл-буфер
     */
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
