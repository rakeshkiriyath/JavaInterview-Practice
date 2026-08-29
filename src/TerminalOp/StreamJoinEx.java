package TerminalOp;

import data.Student;
import data.StudentDatabase;

import java.util.stream.Collectors;

public class StreamJoinEx {

    public static String joining_1 () {

        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining());

    }

    public static String joining_2 () {

        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining("-"));

    }

    public static String joining_3 () {

        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining("-","(",")"));

    }

    public static String joining_4 () {

        return StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getName)
                .reduce(" ", String::concat);

    }


    public static void main(String[] args) {
        System.out.println("joining 1 :"+joining_1());
        System.out.println("joining 2 :"+joining_2());
        System.out.println("joining 3 :"+joining_3());
        System.out.println("joining 4 :"+joining_4());
    }
}
