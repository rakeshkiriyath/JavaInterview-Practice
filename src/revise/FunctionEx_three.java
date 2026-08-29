package revise;

import data.Student;
import data.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionEx_three {

    public static Map<String,Double> studentMap = new HashMap<>();

    public static Function<List<Student>, Map<String, Double>> studentFunction = (students -> {
        students.forEach(student -> {
            studentMap.put(student.getName(),student.getGpa());
        });
        return studentMap;
    });

    public static void main(String[] args) {
        System.out.println(studentFunction.apply(StudentDatabase.getAllStudents()));
    }
}
