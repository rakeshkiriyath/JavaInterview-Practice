package practice;

import data.Student;
import data.StudentDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TerminalOperations {

    public static String joining_1() {
        return StudentDatabase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining());
    }

    public static String joining_2() {
        return StudentDatabase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining("-"));
    }

    public static String joining_3() {
        return StudentDatabase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining("-","(",")"));
    }

    public static Long counting() {
        return StudentDatabase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.counting());
    }

    public static void main(String[] args) {
        System.out.println(joining_1());
        System.out.println(joining_2());
        System.out.println(joining_3());





    }
}
