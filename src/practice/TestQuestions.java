package practice;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestQuestions {

    public static void evenNumbersList(List<Integer> numbers) {
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    public static void maxNumber(List<Integer> numbers) {
        OptionalInt max = numbers.stream().mapToInt(Integer::intValue).max();
        if(max.isPresent())
            System.out.println(max.getAsInt());

        //approach 2:
        Integer i = numbers.stream().max(Integer::compareTo).orElseThrow();
        System.out.println(i);
    }

    public static void sortedListInDescendingOrder(List<Integer> numbers) {
        numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static void countStringWithPrefix_A(List<String> strings) {
        strings.stream()
                .filter(str -> str.startsWith("A"))
                .count();
    }

    public static void main(String[] args) {

    }
}
