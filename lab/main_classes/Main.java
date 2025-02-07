package lab.main_classes;

import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        StudyGroup group = StudyGroup.builder()
                .id(1)
                .name("Group A")
                .coordinates(new Coordinates())
                .creationDate(ZonedDateTime.now())
                .studentsCount(50)
                .expelledStudents(2)
                .shouldBeExpelled(5)
                .formOfEducation(FormOfEducation.FULL_TIME_EDUCATION)
                .build();


    }
}