package multithreading_in_java;

public class ThreadJonins {

    public static void main(String[] args) throws InterruptedException {
        Thread thread_A = new Thread(new AdditionThread(10,1000l));
        thread_A.setName("Thread A");
        Thread thread_B = new Thread(new AdditionThread(5,0l));
        thread_B.setName("Thread B");
        thread_A.start();
        thread_A.join();
        thread_B.start();
    }

    private static class AdditionThread implements Runnable{
        private final static Integer defaultValueToBeAdded = 10;
        private Integer userInput;
        private Long sleepms;
        public AdditionThread(Integer userInput, Long sleepms) {
            this.userInput = userInput;
            this.sleepms = sleepms;
        }
        private void performDefaultAddition(Integer userInput) {
            try {
                Thread.sleep(sleepms);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.userInput += defaultValueToBeAdded;
        }

        @Override
        public void run() {
            performDefaultAddition(userInput);
            System.out.println("Addition performed result : "+this.userInput+" by "+Thread.currentThread().getName());
        }
    }

}
