package TerminalOp;

import data.StudentDatabase;

import java.util.stream.Collectors;

public class StreamCounting {

    public static long count() {

        return StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa() >= 3.9)
                .collect(Collectors.counting());
    }

    public static void main(String[] args) {

        System.out.println("Total count : "+count());

    }
}
