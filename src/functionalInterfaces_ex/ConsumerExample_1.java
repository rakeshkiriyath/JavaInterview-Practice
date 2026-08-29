package functionalInterfaces_ex;

import java.util.function.Consumer;

public class ConsumerExample_1 implements Consumer<String>{

    public static void main(String[] args) {

        ConsumerExample_1 con = new ConsumerExample_1();
        con.accept("Hello");

    }

    @Override
    public void accept(String s)
    {
        System.out.println(s.toUpperCase());
    }
}
