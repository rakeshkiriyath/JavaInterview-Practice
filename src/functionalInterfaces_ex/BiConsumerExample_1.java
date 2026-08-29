package functionalInterfaces_ex;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample_1 {

    public static void main(String[] args) {

        List<StudentFunInt> studentFunInts = StudentFunInt.getAllStudent();

        BiConsumer<String,String> biConsumer = (name, gender) -> System.out.println(name +" : "+gender);

        BiConsumer<StudentFunInt, StudentFunInt> biConsumer1 = (student_1, student_2) -> {
            if("Male".equals(student_1.getGender()) && student_2.getGpa() > 9.0)
                System.out.println(student_1.getName());
        };

        //students.forEach(student -> biConsumer.accept(student.getName(), student.getGender()));

        studentFunInts.forEach((student) -> biConsumer1.accept(student,student));

    }
}
