package new_stream;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorEx {
    public static void main(String[] args) {

        Function<String,String> stringFunction = s -> s.concat("_default");

        // same as function, if your function takes a string and returns a string, then use unary operator
        UnaryOperator<String> unaryOperator = s -> s.concat("_default");

        System.out.println(
                unaryOperator.apply("Java8")
        );

        BiFunction<Integer,Integer,Integer> biFunction = (a,b) -> a * b;


        // same as bifunction, if the inputs and outputs are of same type then use binary operator
        BinaryOperator<Integer> binaryOperator = (a,b) -> a * b;

        System.out.println(
                binaryOperator.apply(5,5)
        );

        Comparator<Integer> comparator = (a,b) -> a.compareTo(b);

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println(
                maxBy.apply(4,5)
        );

    }
}
