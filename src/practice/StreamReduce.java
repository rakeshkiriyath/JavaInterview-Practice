package practice;

import data.Student;
import data.StudentDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamReduce {

    public static void highestGPA() {
        Optional<Student> reduce = StudentDatabase.getAllStudents()
                .stream()
                .reduce((s1, s2) -> {
                    if (s1.getGpa() > s2.getGpa())
                        return s1;
                    return s2;
                });

        List<Integer> nums = Arrays.asList(1,2,3,4,5);

        nums.stream()
                .filter(num -> num % 2 == 0)
                .map(filteredNum -> filteredNum + 2)
                .filter(filteredNum -> filteredNum % 2 == 0)
                .count();



    }


    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1,3,5,7);

        Integer result = integers.stream()
                //1
                //3
                //5
                //7
                // a=1,b=1(from stream) -> result 1 is returned
                // a=1,b=3(from stream) -> result 3 is returned
                // a=3,b=5(from stream) -> result 15 is returned
                // a=15,b=7(from stream) -> result 105 is returned
                .reduce(1, (a, b) -> a * b);

        //System.out.println(result);

        TestStream testStream = new TestStream();

        List<TestStream> testStreamList = new ArrayList<>();
        testStreamList.add(testStream);

        // only after a terminal operation is called, the map is invoked
        testStreamList.stream()
                .map(testStream1 -> {
                    System.out.println("Map invoked");
                    return testStream1.getNumber();
                })
                .collect(Collectors.toList());

        testStreamList.stream()
                .map(TestStream::getNumber);

        integers.stream()
                // only first 2 elemenets are processed
                .limit(2)
                .reduce(0,(a,b)-> a+b);

        integers.stream()
                // first 2 elements are skipped and it processes other
                .skip(2)
                .reduce(0,(a,b) -> a+b);



    }

}
