package revise;

import java.util.function.Function;

public class FunctionEx {

    public static Function<String,String> stringFunction = (name) -> name.toUpperCase();

    public static Function<String,String> addSomeString = (name) -> name.concat("_default");

    public static void main(String[] args) {

        System.out.println(stringFunction.apply("java8"));

        //java8 -- passed to stringFunction = JAVA8 -- is now passed to addSomeString = JAVA8_default
        System.out.println(stringFunction.andThen(addSomeString).apply("java8"));

        //java8 -- passed to addSomeString = java8_default -- is now passed to stringFunction = JAVA8_DEFAULT
        System.out.println(stringFunction.compose(addSomeString).apply("java8"));


    }
}
