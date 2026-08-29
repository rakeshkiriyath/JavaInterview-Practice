package stream_api;

import data.Student;
import data.StudentDatabase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamFlatMapExample {

    public static List<String> printStudentActivities() {

        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static long printStudentCount() {

        return StudentDatabase.getAllStudents()
                .stream()
                .count();
    }

    public static long printDistinctStudentCount() {

        return StudentDatabase.getAllStudents()
                .stream()
                .distinct()
                .count();
    }

    public static List<Student> sortStudents() {

        return StudentDatabase.getAllStudents()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByGPA() {

        return StudentDatabase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByGPAAndThenGrade() {

        return StudentDatabase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa).thenComparing(Student::getGradeLevel))
                .collect(Collectors.toList());
    }

    public static List<Student> sortStudentsByGPADesc() {

        return StudentDatabase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }



    public static void main(String[] args) {
        sortStudentsByGPA().forEach(System.out::println);

        System.out.println("**********************************************");

        sortStudentsByGPAAndThenGrade().forEach(System.out::println);
    }
}
