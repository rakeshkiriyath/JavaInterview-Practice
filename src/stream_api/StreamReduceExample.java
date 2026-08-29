package stream_api;

import java.util.Arrays;
import java.util.List;

public class StreamReduceExample {

    public static Integer performMultiplication(List<Integer> integerList) {
        return integerList
                .stream() // 1, 3, 5, 7
                // a = 1 (initial value), b = 1 (from stream) => result 1 is returned
                // a = 1 (result of a*b), b = 3 (from stream) => result 3 is returned
                // a = 3 (result of a*b), b = 5 (from stream) => result 15 is returned
                // a = 15 (result of a*b), b = 7 (from stream) => result 105 is returned
                .reduce(1, (a, b) -> a * b);
    }

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1,3,5,7);

        System.out.println(performMultiplication(integerList));

    }
}
