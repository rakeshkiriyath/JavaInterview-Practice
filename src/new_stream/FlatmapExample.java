package new_stream;

import data.Student;
import data.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FlatmapExample {
    public static void main(String[] args) {

        StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .toList()
                .forEach(System.out::println);

        long count = StudentDatabase.getAllStudents()
                .stream()
                .count();
        System.out.println(count);

        List<String> collect = StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getGender)
                .distinct()
                .collect(Collectors.toList());

        collect.forEach(System.out::println);

        StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getGpa)
                .sorted()
                .forEach(System.out::println);

        StudentDatabase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);

    }
}
