package method_ref;

import functionalInterfaces_ex.StudentFunInt;

import java.util.function.Consumer;

public class ConsumerMethodRef {

    public static Consumer<StudentFunInt> consumerLambda = student -> System.out.print(student.getName()+" ");

    public static Consumer<StudentFunInt> consumerMethodRef = System.out::println;

    public static Consumer<StudentFunInt> consumerGenderRef = StudentFunInt::printStudentGeneder;

    public static void main(String[] args) {
       //Student.getAllStudent().forEach(consumerLambda);

        StudentFunInt.getAllStudent().forEach(student -> consumerGenderRef.accept(student));

        System.out.println();

        StudentFunInt.getAllStudent().forEach(consumerGenderRef);

        System.out.println();

        StudentFunInt.getAllStudent().forEach(StudentFunInt::printStudentGeneder);


    }
}
