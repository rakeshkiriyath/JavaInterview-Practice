package revise;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BiConsumerEx {

    public static BiConsumer<String, String> biConsumer = (a,b) -> {
      System.out.println("a : "+a+" "+"b : "+b);
    };

    public static BiConsumer<Integer, Integer> integerBiConsumer = (a,b) -> {
        System.out.println("a * b : "+a*b);
    };

    public static BiConsumer<Integer, Integer> integerDivisionBiConsumer = (a,b) -> {
        System.out.println("a div b : "+a/b);
    };

    public static void printNameAndActivities() {
        List<Student> allStudents = StudentDatabase.getAllStudents();

        BiConsumer<String, List<String>> listBiConsumer = (name, activities) -> {
            System.out.println(name+" "+activities);
        };

        // Manual creation
        Consumer<Student> consumer = student -> listBiConsumer.accept(student.getName(), student.getActivities());
        allStudents.forEach(consumer);

        //Without LAMBDA
        allStudents.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                listBiConsumer.accept(student.getName(), student.getActivities());
            }
        });


        /*

        That entire expression
                (student -> { listBiConsumer.accept(student.getName(), student.getActivities()); })
        is a Consumer<Student> because:

        It takes one argument: Student student

        It returns nothing (void)

        It performs some operation (calls your BiConsumer)

        */


        // With LAMBDA
        allStudents.forEach(student -> {
            listBiConsumer.accept(student.getName(), student.getActivities());
        });


    }

    public static void main(String[] args) {
//        biConsumer.accept("Java7","Java8");
//        integerBiConsumer.accept(10,10);
//        integerBiConsumer.andThen(integerDivisionBiConsumer).accept(10,5);
          printNameAndActivities();
    }
}
