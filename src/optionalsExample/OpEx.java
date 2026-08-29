package optionalsExample;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.Optional;

public class OpEx {

    private String name;

    public String getName() {
        return this.name;
    };

    public OpEx(){
        this.name = "Adam";
        System.out.println("Constructor is called");
    }

    public static void filterOptional() {

        Optional<Student> student = Optional.ofNullable(StudentDatabase.getAllStudents().getFirst());

//        student.filter(s -> s.getGpa() > 3.3)
//                .ifPresent(student1 -> System.out.println(student1.getName()));

        student.filter(s -> s.getGpa() > 4.0)
                .ifPresentOrElse(
                        s -> System.out.println(s.getName()),
                        () -> { throw new RuntimeException("asd"); }
                );
    }

    public static void testOptional() {
        System.out.println("---- CASE 1: Optional has value ----");
        Optional<OpEx> optional1 = Optional.of(new OpEx());

        System.out.println("Using orElse()");
        OpEx a = optional1.orElse(new OpEx());  // fallback constructed anyway

        System.out.println("Using orElseGet()");
        OpEx b = optional1.orElseGet(() -> new OpEx()); // fallback NOT constructed

        System.out.println("\n---- CASE 2: Optional is empty ----");
        Optional<OpEx> optional2 = Optional.ofNullable(null);

        System.out.println("Using orElse()");
        OpEx c = optional2.orElse(new OpEx());  // fallback constructed

        System.out.println("Using orElseGet()");
        OpEx d = optional2.orElseGet(() -> new OpEx()); // fallback constructed
    }

    public static void optionalOrElse() {

        //Optional<Student> firstStudent = Optional.ofNullable(StudentDatabase.getAllStudents().getFirst());

        //Optional<Student> firstStudent = Optional.ofNullable(null);

        //Optional<OpEx> firstStudent = Optional.ofNullable(null);

        Optional<OpEx> firstStudent = Optional.ofNullable(new OpEx());

        //OpEx name = firstStudent.orElse(new OpEx());

        OpEx name1 = firstStudent.orElseGet(() -> new OpEx());

        //String name2 = firstStudent.map(OpEx::getName).orElseThrow(() -> new RuntimeException(("Do data avilable")));

        System.out.println(name1.getName());

    }


    public static String getStudentName() {
        List<Student> allStudents = StudentDatabase.getAllStudents();

        Student student = allStudents.getFirst();

        if(student != null) {
            return student.getName();
        }

        return null;
    }

    public static Optional<String> getStudentNameOptional() {
        List<Student> allStudents = StudentDatabase.getAllStudents();

        Optional<Student> student = Optional.of(allStudents.getFirst());

        Optional<Student> student1 = Optional.of(null);

        if(student.isPresent()) {
            Optional<String> studentName = student.map(Student::getName);
            return studentName;
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        filterOptional();
    }
}
