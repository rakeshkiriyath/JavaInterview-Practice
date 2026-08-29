package functionalInterfaces_ex;

import java.util.function.Consumer;

public class ConsumerExample_3 {

    public static void main(String[] args) {
        Consumer<String> con = (s) -> System.out.println(s.toUpperCase());
        con.accept("Hello");

    }
}
