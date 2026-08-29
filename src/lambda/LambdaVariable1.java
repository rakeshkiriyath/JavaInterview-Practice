package lambda;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class LambdaVariable1 {
    static Integer number = 10;
    public static void main(String[] args) {
        Consumer<Integer> consumer = (integer -> {
           integer += 10;
           number = integer;
           System.out.println(number);
        });
        consumer.accept(number);
    }

}
