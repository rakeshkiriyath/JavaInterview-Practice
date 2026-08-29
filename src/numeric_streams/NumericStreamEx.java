package numeric_streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamEx {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(2,4,6,8);

        System.out.println(IntStream.rangeClosed(1,6).sum());

        int sum = IntStream.rangeClosed(1,50).sum();
        System.out.println("Sum is : "+sum);

        OptionalInt maxValue = IntStream.rangeClosed(1,50).max();
        System.out.println("Max value is : "+maxValue.getAsInt());

        // Converting the primitive to wrapper class
        IntStream.rangeClosed(1,10)
                //int
                .boxed()
                //integer
                .collect(Collectors.toList());

        integerList
                .stream()
                //wrapper Integer values to primitive
                .mapToInt(Integer::intValue)
                .sum();

        IntStream.rangeClosed(1,5)
                .mapToObj((x) -> {
                    return new Integer(x);
                });


    }
}
