package TerminalOp;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamGroupBy {

    public static void main(String[] args) {

        Map<String, List<Student>> collect = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));

        //System.out.println(collect);

        // Customized key names
        Map<String, List<Student>> collect1 = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "GOOD" : "BAD"));


        collect1.forEach(((s, students) -> {
            students.forEach(
                    student -> System.out.println(s+":"+student.getName())
            );
        }));



    }

}
