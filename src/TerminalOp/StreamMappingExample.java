package TerminalOp;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamMappingExample {

    public static void main(String[] args) {

        List<String> namesList = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toList()));

        // another way
        List<String> namesList_1 = StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.toList());

    }

}
