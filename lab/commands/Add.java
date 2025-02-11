package lab.commands;

import lab.exceptions.InvalidInputException;
import lab.interfaces.Executable;
import lab.interfaces.ValidatableCommand;
import lab.main_classes.Coordinates;
import lab.main_classes.FormOfEducation;
import lab.main_classes.Main;
import lab.main_classes.StudyGroup;
import lab.utility.InputManager;
import lab.utility.PersonCreature;


public class Add extends Command implements Executable, ValidatableCommand {
    public Add(Object parameter) {
        super(parameter);
    }

    public boolean validate() {
        try {
            if (this.parameter.equals("{element}")) {
                return true;
            } else {
                throw new InvalidInputException("У add должен быть токен {element}!");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void execute() {
        InputManager.runningCommand = false;
        Main.commandsList.add("add {element}");
        boolean flag = true;
        System.out.println("Инициализировано создание объекта для добавление в коллекцию");
        String consoleRead;
        StudyGroup.StudyGroupBuilder group = StudyGroup.builder();

        do {
            try {
                System.out.print("Введите имя группы: ");
                consoleRead = InputManager.consoleRead.nextLine();
                if (consoleRead == null || consoleRead.isEmpty()) {
                    throw new InvalidInputException("Поле name должно быть отличным от null и пустой строки!");
                }
                group.name(consoleRead);
                flag = false;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);

        flag = true;
        do {
            try {
                System.out.print("Введите координату x группы: ");
                Coordinates.CoordinatesBuilder coordinates = Coordinates.builder();
                consoleRead = InputManager.consoleRead.nextLine();
                Double x = Double.parseDouble(consoleRead);
                if (x < Double.MIN_VALUE || x > Double.MAX_VALUE) {
                    throw new InvalidInputException("");
                }
                coordinates.x(x);
                flag = false;
            } catch (InvalidInputException | NumberFormatException e) {
                System.out.println("Координата должна быть типа double (>= -2^63 и <= 2^63 - 1) и не могут быть null!");
            }
        } while (flag);

        flag = true;
        do {
            try {
                System.out.print("Введите координату y группы: ");
                Coordinates.CoordinatesBuilder coordinates = Coordinates.builder();
                consoleRead = InputManager.consoleRead.nextLine();
                Double y = Double.parseDouble(consoleRead);
                if (y < Double.MIN_VALUE || y > Double.MAX_VALUE) {
                    throw new InvalidInputException("");
                }
                coordinates.y(y);
                flag = false;
            } catch (InvalidInputException | NumberFormatException e) {
                System.out.println("Координата должна быть типа double (>= -2^63 и <= 2^63 - 1) и не могут быть null!");
            }
        } while (flag);

        flag = true;
        do {
            try {
                System.out.print("Введите значение studentsCount группы: ");
                consoleRead = InputManager.consoleRead.nextLine();
                Long studentsCount = Long.parseLong(consoleRead);
                if (studentsCount <= 0 || studentsCount > Long.MAX_VALUE) {
                    throw new InvalidInputException("Поле studentsCount должно быть целым положительным числом до 2^31 - 1 (тип long)!");
                }
                group.studentsCount(studentsCount);
                flag = false;
            } catch (InvalidInputException | NumberFormatException e) {
                System.out.println("Введите корректное положительное целое число до 2^31 - 1 (тип long)!");
            }
        } while (flag);

        flag = true;
        do {
            try {
                System.out.print("Введите значение expelledStudents группы: ");
                consoleRead = InputManager.consoleRead.nextLine();
                Integer expelledStudents = Integer.parseInt(consoleRead);
                if (expelledStudents <= 0 || expelledStudents > Integer.MAX_VALUE) {
                    throw new InvalidInputException("Поле expelledStudents должно быть целым положительным числом!");
                }
                group.expelledStudents(expelledStudents);
                flag = false;
            } catch (InvalidInputException | NumberFormatException e) {
                System.out.println("Введите корректное положительное целое число!");
            }
        } while (flag);

        flag = true;
        do {
            try {
                System.out.print("Введите значение shouldBeExpelled группы: ");
                consoleRead = InputManager.consoleRead.nextLine();
                Long shouldBeExpelled = Long.parseLong(consoleRead);
                if (shouldBeExpelled <= 0 || shouldBeExpelled > Long.MAX_VALUE) {
                    throw new InvalidInputException("Поле shouldBeExpelled должно быть целым положительным числом до 2^31 - 1 (тип long)!");
                }
                group.shouldBeExpelled(shouldBeExpelled);
                flag = false;
            } catch (InvalidInputException | NumberFormatException e) {
                System.out.println("Введите корректное положительное целое число до 2^31 - 1 (тип long)!");
            }
        } while (flag);

        flag = true;
        do {
            try {
                System.out.print("Введите значение formOfEducation группы (DISTANCE_EDUCATION, FULL_TIME_EDUCATION, EVENING_CLASSES): ");
                consoleRead = InputManager.consoleRead.nextLine();
                if (consoleRead.isEmpty()) {
                    group.formOfEducation(null);
                } else {
                    group.formOfEducation(FormOfEducation.valueOf(consoleRead));
                }
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Такого значения нет!");
            }
        } while (flag);

        System.out.print("Нажмите enter, если НЕ хотите создать groupAdmin (иначе - любой символ): ");
        consoleRead = InputManager.consoleRead.nextLine();
        if (!consoleRead.isEmpty()) {
            group.groupAdmin(PersonCreature.createPerson());
        }

        StudyGroup result = group.build();
        System.out.println("Создание StudyGroup завершено! Его id: " + result.getId() + "\n");
    }
}
