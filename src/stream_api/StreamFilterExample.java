package stream_api;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class StreamFilterExample {

    public static List<Student> filterStudentsByGender(String gender) {

        return StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> student.getGender().equals(gender.toLowerCase()))
                .collect(Collectors.toList());
    }

    public static List<Student> filterStudentsByGenderAndGPA(String gender) {

        return StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> student.getGender().equals(gender.toLowerCase()))
                .filter(student -> student.getGpa() >= 4.0)
                .collect(Collectors.toList());
    }

    public static List<Student> filterStudentsBIGenderAndGPA(String gender) {

        BiPredicate<String, Double> bp1 = (name, gpa) -> gender.equals(name) && gpa >= 3.9;

        return StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> bp1.test(student.getGender(), student.getGpa()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        filterStudentsByGenderAndGPA("female").forEach(System.out::println);
    }
}
