package revise;

public class RunnableInt_old implements Runnable{
    public static void main(String[] args) {
        RunnableInt_old obj = new RunnableInt_old();
        obj.run();
    }

    @Override
    public void run() {
        System.out.println("Thread_1");
    }
}
