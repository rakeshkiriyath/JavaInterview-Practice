package practice;

import data.Student;
import data.StudentDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FuncInt {

    public static Function<Student,String> studentNameFunction = (student) -> {
        return student.getName();
    };

    public static Function<Student, List<String>> studentActivities = (student) -> {
      return student.getActivities();
    };

    public static void main(String[] args) {

        List<Student> allStudents = StudentDatabase.getAllStudents();

        allStudents.stream().collect(Collectors.toMap(studentNameFunction,studentActivities));

        allStudents.stream().collect(Collectors.toMap(student -> student.getName(),student -> student.getActivities()));

        allStudents.stream()
                .filter(student -> student.getGradeLevel() >= 3) // Stream<Students>
                .filter(student -> student.getGpa() >= 3.5) // Stream<Students>
                .collect(Collectors.toMap(Student::getName,Student::getActivities)); // Map

    }
}
