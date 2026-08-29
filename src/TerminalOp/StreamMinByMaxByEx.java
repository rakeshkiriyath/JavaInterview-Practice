package TerminalOp;

import data.Student;
import data.StudentDatabase;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamMinByMaxByEx {

    public static Optional<Student> minBy() {

        Optional<Student> minStudent = StudentDatabase.getAllStudents()
                .stream()
                .min(Comparator.comparing(Student::getGpa));



        return StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));


    }

    public static void main(String[] args) {


    }
}
