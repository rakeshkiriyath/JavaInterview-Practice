package method_reference;

// syntax
// object::methodName

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

public class Test {

    public static void main(String[] args) {

        List<Student> studentList = StudentDatabase.getAllStudents();

        studentList.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                student.printNameAndGender();
            }
        });

        studentList.forEach(student -> student.printNameAndGender());

        studentList.forEach(Student::printNameAndGender);

    }
}
