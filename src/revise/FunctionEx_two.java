package revise;

public class FunctionEx_two {

    public static String  performConcat(String str) {
        return FunctionEx.addSomeString.apply(str);
    }

    public static void main(String[] args) {
        String result = performConcat("java8");
        System.out.println(result);
    }
}
