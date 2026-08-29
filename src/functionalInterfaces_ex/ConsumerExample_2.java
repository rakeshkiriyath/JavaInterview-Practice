package functionalInterfaces_ex;

import java.util.function.Consumer;

public class ConsumerExample_2 {

    public static void main(String[] args) {

        Consumer<String> con = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println(s.toUpperCase());
            }
        };
        con.accept("Hello");
    }
}
