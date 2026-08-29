package practice;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class NumericStreams {

    public static void sumOfNNumbers() {

        IntStream.rangeClosed(1,6).sum();

        List<Integer> arr = Arrays.asList(1,10,3,4,6);

        OptionalInt max = arr.stream().mapToInt(Integer::intValue).max();
        if(max.isPresent())
            System.out.println(max.getAsInt());

        OptionalInt sum = arr.stream().mapToInt(x -> {
           return x.intValue();
        }).max();
        if(sum.isPresent())
            System.out.println(sum.getAsInt());

    }

    public static void main(String[] args) {
        sumOfNNumbers();
    }

}
