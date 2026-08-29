package stream_api;

import data.Student;
import data.StudentDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class StreamsMapExample {

    public static List<String> namesList() {
        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static List<String> namesManualList() {
        List<Student> allStudents = StudentDatabase.getAllStudents();
        List<String> studentNamesList = new ArrayList<>();
        for(Student student : allStudents) {
            studentNamesList.add(student.getName().toUpperCase());
        }
        return studentNamesList;
    }

    public static Set<String> namesSet() {

        StudentDatabase.getAllStudents()
                .stream()
                .map(student -> student.getName())
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());


        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {



    }
}
