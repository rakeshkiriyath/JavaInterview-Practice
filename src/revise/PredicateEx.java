package revise;

import java.util.function.Predicate;

public class PredicateEx {

    // Syntax applicable for single line statements
    public static Predicate<Integer> p1 = (number) -> number % 2 == 0;

    public static Predicate<Integer> p2 = (number) -> number % 5 == 0;

    public static void predicateAnd() {
        System.out.println(p1.and(p2).test(9));
    }

    public static void predicateOr() {
        System.out.println(p1.or(p2).test(4));
    }

    // It is the not equal condition, it will change the result of true to false, vice versa.
    public static void predicateNegate() {
        System.out.println(p1.or(p2).negate().test(4));
    }

    public static void main(String[] args) {

        predicateAnd();
        predicateOr();
        predicateNegate();

    }
}

