package data;

import java.util.Arrays;
import java.util.List;

public class StudentDatabase {

    public static List<Student> getAllStudents() {
        Student student1 = new Student(11,"Adam",2,3.6,"male", Arrays.asList("swimming","basketball","volleyball"));

        Student student2 = new Student(12,"Jenny",2,3.8,"female", Arrays.asList("swimming","gymnastics","soccer"));

        Student student3 = new Student(10,"Emily",3,4.0,"female", Arrays.asList("swimming","gymnastics","aerobics"));

        Student student4 = new Student(9,"Dave",3,3.9,"male", Arrays.asList("swimming","gymnastics","soccer"));

        Student student5 = new Student(15,"Sophia",1,3.8,"female", Arrays.asList("swimming","dancing","football"));

        Student student6 = new Student(14,"James",4,3.9,"male", Arrays.asList("swimming","basketball","baseball","football"));

        List<Student> students = Arrays.asList(student1,student2,student3,student4,student5,student6);

        return students;

    }
}
