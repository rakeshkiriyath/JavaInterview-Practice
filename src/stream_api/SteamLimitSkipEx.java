package stream_api;

import data.Student;
import data.StudentDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SteamLimitSkipEx {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,3,7,9,11,13);

        List<Integer> collect = integerList.stream().limit(2).collect(Collectors.toList());

        // 1 and 5
        //collect.forEach(System.out::println);

        List<Integer> collect1 = integerList.stream().skip(2).collect(Collectors.toList());

        // 10 and 20
        //collect1.forEach(System.out::println);

        boolean anyMatchResult = integerList.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(anyMatchResult);

        boolean anyMatchResult1 = integerList.stream().allMatch(x -> x % 2 != 0);
        System.out.println(anyMatchResult1);

        StudentDatabase.getAllStudents()
                .stream()
                .anyMatch(student -> student.getGpa() >= 9.5);

        StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa() >= 9.5)
                .collect(Collectors.toList());

        Optional<Student> optionalStudent = StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findAny();


    }
}
