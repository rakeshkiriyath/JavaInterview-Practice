package new_stream;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MapStreamExample {

    public static List<String> namesList() {

        List<String> names =  StudentDatabase.getAllStudents()
                .stream()
                .map(student -> student.getName())
                .collect(Collectors.toList());

        List<String> namesTwo = StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        return names;
    }

    public static void main(String[] args) {
        namesList().forEach(System.out::println);
    }
}
