package practice;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGrouping {

    public static void groupStudentByGender(){
        Map<String, List<Student>> collect = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));

        System.out.println(collect);
    }

    public static void groupStudentByGPA(){
        Map<String, List<Student>> collect = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));

        System.out.println(collect);
    }

    public static void twoLevelGrouping_1() {

        Map<Integer, Map<String, List<Student>>> collect = StudentDatabase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel, Collectors.groupingBy(Student::getGender)));
        System.out.println(collect);

    }

    public static void main(String[] args) {
        //groupStudentByGender();
        //groupStudentByGPA();
        twoLevelGrouping_1();
    }


}
