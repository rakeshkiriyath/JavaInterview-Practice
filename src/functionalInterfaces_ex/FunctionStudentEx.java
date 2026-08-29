package functionalInterfaces_ex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudentEx {

    private static Function<List<StudentFunInt>, Map<String,Double>> fetchStudentGPA = (studentList -> {
        Map<String, Double> resultMap = new HashMap<>();
        studentList.forEach(student -> {
            resultMap.put(student.getName(),student.getGpa());
        });
        return resultMap;
    });

    public static void main(String[] args) {
        System.out.println(fetchStudentGPA.apply(StudentFunInt.getAllStudent()));
    }
}
