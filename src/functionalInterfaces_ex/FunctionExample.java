package functionalInterfaces_ex;

import java.util.function.Function;

public class FunctionExample {

    private static Function<String,String> stringFunction = (name) -> name.toUpperCase();

    private static Function<String,String> addStringFunction = (name) -> name.concat("_default");

    private static Function<String,String> lowerStringFunction = (name) -> name.toLowerCase();


    public static void main(String[] args) {

        System.out.println(stringFunction.apply("Java8"));

        System.out.println(stringFunction.andThen(addStringFunction).apply("Java8"));

        System.out.println(stringFunction.compose(addStringFunction).compose(lowerStringFunction).andThen(addStringFunction).apply("Java-8"));

    }

}
