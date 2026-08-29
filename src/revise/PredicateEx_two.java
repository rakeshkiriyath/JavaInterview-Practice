package revise;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateEx_two {

    public static Predicate<Student> p1 = student -> student.getGradeLevel() >= 3;

    public static Predicate<Student> p2 = student -> student.getGpa() >= 3.9;

    public static BiPredicate<Integer, Double> bp1 = (grade, gpa) -> grade >= 3 && gpa >= 3.9;

    public static void filterStudentByGradeLevel() {
        List<Student> allStudents = StudentDatabase.getAllStudents();

        allStudents.forEach(student -> {
            if (p1.and(p2).test(student))
                System.out.println(student.getName());
        });

        System.out.println();

        allStudents.forEach(student -> {
            if(bp1.test(student.getGradeLevel(),student.getGpa()))
                System.out.println(student.getName());
        });
    }

    public static void main(String[] args) {
        filterStudentByGradeLevel();
    }
}
