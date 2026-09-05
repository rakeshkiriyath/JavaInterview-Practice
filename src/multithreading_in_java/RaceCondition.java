package multithreading_in_java;

public class RaceCondition {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Counter before thread : "+counter);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter++;
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter after thread : "+counter);

    }

}
