package functionalInterfaces_ex;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class StudentFunInt {
    private Integer id;
    private String name;
    private double gpa;
    private String gender;

    public static List<StudentFunInt> getAllStudent() {
        return Arrays.asList(
                new StudentFunInt(1,"Mark",9.2,"Male"),
                new StudentFunInt(2,"Princy",9.1,"Female"),
                new StudentFunInt(3,"Tony",8.8,"Male"),
                new StudentFunInt(4,"Mrick",9.4,"Male"),
                new StudentFunInt(5,"Rosy",6.8,"Female")
        );
    }

    public static Supplier<StudentFunInt> studentSupplier = () -> {
        return new StudentFunInt(1,"Mark",9.7,"Male");
    };

    public static void printStudentGeneder(StudentFunInt studentFunInt) {
        System.out.print(studentFunInt.getName()+" - "+ studentFunInt.getGender()+" ");
    }

    public StudentFunInt(Integer id, String name, double gpa, String gender) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                ", gender='" + gender + '\'' +
                '}';
    }

}
