package new_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LimitAndSkip {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(9,8,9,10);

        integerList
                .stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("********************");

        integerList
                .stream()
                .skip(3)
                .forEach(System.out::println);

        System.out.println("********************");

        System.out.println(integerList
                .stream()
                .allMatch(x -> x % 2 == 0));

        System.out.println("********************");

        System.out.println(
                integerList.stream().anyMatch(x -> x % 2 == 0)
        );

        System.out.println(
                integerList
                        .stream()
                        .filter(x -> x % 2 == 0)
                        .findAny()
                        .get()
        );

        System.out.println(
                integerList
                        .stream()
                        .filter(x -> x % 2 == 0)
                        .findFirst()
                        .get()
        );

    }
}
