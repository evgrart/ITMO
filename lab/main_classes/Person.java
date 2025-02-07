package lab.main_classes;

import lab.interfaces.Validatable;

import java.time.LocalDateTime;

public class Person implements Validatable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDateTime birthday; //Поле не может быть null
    private long height; //Значение поля должно быть больше 0
    private int weight; //Значение поля должно быть больше 0
    private String passportID; //Длина строки не должна быть больше 47, Строка не может быть пустой, Поле не может быть null

    @Override
    public boolean validate() {
        if (this.name == null || this.name.isEmpty()) return false;
        else if (this.birthday == null) return false;
        else if (height <= 0) return false;
        else if (weight <= 0) return false;
        else if (this.passportID == null || this.passportID.isEmpty() || this.passportID.length() > 47) return false;
        return true;
    }

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


