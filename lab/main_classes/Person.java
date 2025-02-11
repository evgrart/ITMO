package lab.main_classes;

import java.time.LocalDateTime;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDateTime birthday; //Поле не может быть null
    private long height; //Значение поля должно быть больше 0
    private int weight; //Значение поля должно быть больше 0
    private String passportID; //Длина строки не должна быть больше 47, Строка не может быть пустой, Поле не может быть null

    public Person(String name, LocalDateTime birthday, long height, int weight, String passportID) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {
        private String name;
        private java.time.LocalDateTime birthday;
        private long height;
        private int weight;
        private String passportID;

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder birthday(java.time.LocalDateTime birthday) {
            this.birthday = birthday;
            return this;
        }

        public PersonBuilder height(long height) {
            this.height = height;
            return this;
        }

        public PersonBuilder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public PersonBuilder passportID(String passportID) {
            this.passportID = passportID;
            return this;
        }

        public Person build() {
            return new Person(this.name, this.birthday, this.height, this.weight, this.passportID);
        }
    }

}


