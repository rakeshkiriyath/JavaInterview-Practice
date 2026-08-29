package method_ref;

import functionalInterfaces_ex.StudentFunInt;

import java.util.function.Predicate;

public class RefactorMethodRef {

    public static Predicate<StudentFunInt> p1 = student -> student.getGpa() >= 9.0;

    public static Predicate<StudentFunInt> p2 = RefactorMethodRef::greaterThanGPALevel;

    public static boolean greaterThanGPALevel(StudentFunInt studentFunInt) {
        return studentFunInt.getGpa() >= 9.0;
    }

    public static void main(String[] args) {

        System.out.println(p1.test(StudentFunInt.studentSupplier.get()));
    }
}
