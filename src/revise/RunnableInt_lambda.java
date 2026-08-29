package revise;

public class RunnableInt_lambda {
    public static void main(String[] args) {

        Runnable runnable = () -> System.out.println("Runnable lambda");

        runnable.run();

        new Thread(() -> System.out.println("Runnable lambda 1")).start();
    }
}
