package practice;

import data.Student;
import data.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamMap {

    public static List<String> nameList() {

        return StudentDatabase.getAllStudents().stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static void activitiesList() {
        List<String> activites = StudentDatabase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(activites);

    }

    public static void activitiesListDistinct() {
        List<String> activites = StudentDatabase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(activites);

    }

    public static void activitiesListDistinctCount() {
        long activites = StudentDatabase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream)
                .distinct()
                .count();
        System.out.println(activites);

    }

    public static void activitiesListDistinctSorted() {
        List<String> activites = StudentDatabase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(activites);
    }

    public static void activitiesListDistinctSortedReverse() {
        List<String> activites = StudentDatabase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities) // Stream<List<String>>
                .flatMap(List::stream)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(activites);
    }

    public static Predicate<Student> gpaPredicate = (student) -> {
      return student.getGpa() > 3.8;
    };
    public static Predicate<Student> genderPredicate = (student) -> {
        return "female".equals(student.getGender());
    };

    public static Predicate<Student> gpaGenderPredicate = (student) -> {
        return student.getGpa() > 3.8 && "female".equals(student.getGender());
    };


    public static void activitiesListDistinctSortedName() {

        List<String> collect = StudentDatabase.getAllStudents().stream()
                .filter(gpaGenderPredicate)
                .sorted(Comparator.comparing(Student::getName).reversed())
                .map(Student::getName)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }


    public static void main(String[] args) {
//        activitiesListDistinct();
//        activitiesListDistinctCount();
//        activitiesListDistinctSorted();
//        activitiesListDistinctSortedReverse();
        activitiesListDistinctSortedName();
    }
}
