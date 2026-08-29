package revise;

public class RunnableInt_ano {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 in anonymous inner class");
            }
        };
        runnable.run();
    }
}
