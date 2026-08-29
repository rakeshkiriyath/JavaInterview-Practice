package method_ref;

import java.util.function.Function;

public class FunctionMethodRef {

    public static Function<String,String > toUppercaseLambda = str -> str.toUpperCase();

    public static Function<String,String > toUppercaseMethodRef = String::toUpperCase;

    public static void main(String[] args) {
        System.out.println(toUppercaseLambda.apply("Java 8"));
        System.out.println(toUppercaseMethodRef.apply("Java 8"));
    }

}
