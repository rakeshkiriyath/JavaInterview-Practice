package revise;

import data.Student;
import data.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;


public class BiFunctionEx {

    public static Map<String,Double> studentMap = new HashMap<>();

    public static BiFunction<List<Student>, Predicate<Student>, Map<String,Double>> biFunction =
            (students, studentPredicate) -> {
        students.forEach(student -> {
            if(studentPredicate.test(student))
                studentMap.put(student.getName(), student.getGpa());
        });
        return studentMap;
    };

    public static void main(String[] args) {
        biFunction.apply(StudentDatabase.getAllStudents(), PredicateEx_two.p2);
        System.out.println(studentMap);
    }
    
}
