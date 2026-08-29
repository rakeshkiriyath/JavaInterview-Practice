package revise;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerEx {

    static Consumer<Student> c2 = (student) -> System.out.println(student);
    static Consumer<Student> c3 = (student) -> System.out.print(student.getName());
    static Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());

    public static void printStudents() {

        List<Student> allStudents = StudentDatabase.getAllStudents();

        allStudents.forEach(c2); // Java will call consumer.accept(x)

        // Inside that lambda, you control what happens for each student.
        // So if you want to execute the consumer, you must manually invoke it using .accept(student)
        allStudents.forEach(student -> c2.accept(student)); // You call accept(x) manually

    }

    public static void printNameAndActivities() {

        List<Student> allStudents = StudentDatabase.getAllStudents();

        allStudents.forEach(c3.andThen(c4)); //consumer chain

    }

    public static void printNameAndActivitesCondition() {
        List<Student> allStudents = StudentDatabase.getAllStudents();

        allStudents.forEach(student -> {
            if(student.getGradeLevel() >= 3 && student.getGpa() >= 3.9)
                c3.andThen(c4).accept(student);
        });
    }

    public static void main(String[] args) {

        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
        //c1.accept("java 8");

        //printStudents();

        //printNameAndActivities();

        printNameAndActivitesCondition();
    }
}
