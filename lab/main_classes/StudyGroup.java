package lab.main_classes;

import lab.interfaces.Validatable;

import java.time.ZonedDateTime;


public class StudyGroup {

    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long studentsCount; //Значение поля должно быть больше 0
    private int expelledStudents; //Значение поля должно быть больше 0
    private long shouldBeExpelled; //Значение поля должно быть больше 0
    private FormOfEducation formOfEducation; //Поле может быть null
    private Person groupAdmin; //Поле может быть null

    private StudyGroup(int id, String name, Coordinates coordinates, ZonedDateTime creationDate, long studentsCount, int expelledStudents, long shouldBeExpelled, FormOfEducation formOfEducation, Person groupAdmin) {
        this.creationDate = ZonedDateTime.now();
        this.id = this.hashCode();
        this.name = name;
        this.coordinates = coordinates;
        this.studentsCount = studentsCount;
        this.expelledStudents = expelledStudents;
        this.shouldBeExpelled = shouldBeExpelled;
        this.formOfEducation = formOfEducation;
        this.groupAdmin = groupAdmin;
    }

    public static StudyGroupBuilder builder() {
        return new StudyGroupBuilder();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

//        else if (this.groupAdmin != null && !this.groupAdmin.validate()) return false;


    public static class StudyGroupBuilder {
        private int id;
        private String name;
        private Coordinates coordinates;
        private java.time.ZonedDateTime creationDate;
        private long studentsCount;
        private int expelledStudents;
        private long shouldBeExpelled;
        private FormOfEducation formOfEducation;
        private Person groupAdmin;

        public StudyGroupBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudyGroupBuilder coordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        public StudyGroupBuilder studentsCount(long studentsCount) {
            this.studentsCount = studentsCount;
            return this;
        }

        public StudyGroupBuilder expelledStudents(int expelledStudents) {
            this.expelledStudents = expelledStudents;
            return this;
        }

        public StudyGroupBuilder shouldBeExpelled(long shouldBeExpelled) {
            this.shouldBeExpelled = shouldBeExpelled;
            return this;
        }

        public StudyGroupBuilder formOfEducation(FormOfEducation formOfEducation) {
            this.formOfEducation = formOfEducation;
            return this;
        }

        public StudyGroupBuilder groupAdmin(Person groupAdmin) {
            this.groupAdmin = groupAdmin;
            return this;
        }

        public StudyGroup build() {
            return new StudyGroup(id, name, coordinates, creationDate, studentsCount, expelledStudents, shouldBeExpelled, formOfEducation, groupAdmin);
        }
    }
}