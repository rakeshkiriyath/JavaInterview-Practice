package new_stream;

import data.Student;
import data.StudentDatabase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

public class ReduceStreamAdv {

    public static void main(String[] args) {

        Integer noOfNotebooks = StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getNoteBooks)
                .reduce(0, (a, b) -> a + b);

        Integer noOfNotebooks_new = StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getNoteBooks)
                .reduce(0, Integer::sum);

        Optional<Integer> maxNotebook = StudentDatabase.getAllStudents()
                .stream()
                .map(Student::getNoteBooks)
                .reduce((a, b) -> a > b ? a : b);

        System.out.println(maxNotebook.get());

        Optional<Student> maxStudentInfoNotebook = StudentDatabase.getAllStudents()
                .stream()
                .reduce((student, student2) -> student.getNoteBooks() > student2.getNoteBooks() ? student : student2);

        System.out.println(maxStudentInfoNotebook.get());

        StudentDatabase.getAllStudents()
                .stream()
                .max(Comparator.comparing(student -> student.getNoteBooks()));

        /*
        ⭐ Final Remember Trick
            If your lambda body is only a single method call, you can convert it.
            If not — you can’t.
         */
        StudentDatabase.getAllStudents()
                .stream()
                .max(Comparator.comparing(Student::getNoteBooks));


    }
}
