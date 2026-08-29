package functionalInterfaces_ex;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerExample_4 {
    public static void main(String[] args) {

        List<StudentFunInt> studentFunInts = StudentFunInt.getAllStudent();

        Predicate<StudentFunInt> predicate = (student) -> "Male".equals(student.getGender());

        studentFunInts.stream().filter(predicate).forEach(System.out::println);

        studentFunInts.stream().filter(student -> {
            return "Male".equals(student.getGender());
        }).forEach(System.out::println);

        for(StudentFunInt studentFunInt : studentFunInts) {
            System.out.println(studentFunInt);
        }

        Consumer<StudentFunInt> studentConsumer = (student) -> System.out.println(student);
        studentFunInts.forEach(studentConsumer);

        studentFunInts.forEach((student) -> System.out.println(student));

        studentFunInts.forEach(new Consumer<StudentFunInt>() {
            @Override
            public void accept(StudentFunInt studentFunInt) {
                System.out.println(studentFunInt);
            }
        });

        studentFunInts.forEach(
                (student) -> System.out.println(student.getName())
        );


        studentFunInts.forEach(
                ((Consumer<StudentFunInt>) (student) -> System.out.print(student.getName())).andThen(student -> System.out.println(student.getGender()))
        );



    }
}
