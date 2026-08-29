package new_stream;

import data.Student;
import data.StudentDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduce {

    public static void main(String[] args) {

        Optional<Student> maxGPAStudent = StudentDatabase.getAllStudents()
                .stream()
                // students one by one
                .reduce((student, student2) -> {
                    if (student.getGpa() > student2.getGpa())
                        return student;
                    else
                        return student2;
                });

        Optional<Student> maxGPAStudent_simple = StudentDatabase.getAllStudents()
                .stream()
                // students one by one
                .reduce((student, student2) -> (student.getGpa() > student2.getGpa()) ? student : student2);


        System.out.println(maxGPAStudent.get());


        List<Integer> integerList = Arrays.asList(1,2);

        // no initial value
        // 1 * 2 = 2
        Optional<Integer> multiplication = integerList
                .stream()
                .reduce((a, b) -> a * b);

        // identity - 3 is the initial value
        // 3 * 1 = 3
        // 3 * 2 = 6
        Integer reduce = integerList
                .stream()
                .reduce(3, (a, b) -> a * b);

        System.out.println(multiplication.get());

        System.out.println(reduce);

    }
}
