package multithreading_in_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static final int PASSWORD_UPPER_RANGE = 9999;

    public static void main(String[] args) {

        Random random = new Random();
        Vault vault = new Vault(random.nextInt(PASSWORD_UPPER_RANGE));

        List<Thread> threadList = new ArrayList<>();

        threadList.add(new AscendingHackerThread(vault));
        threadList.add(new DescendingHackerThread(vault));
        threadList.add(new PoliceThread());

        for(Thread thread : threadList) {
            thread.start();
        }
    }


    private static class Vault {
        private final int passcode;
        public Vault(int passcode) {
            this.passcode = passcode;
        }
        public boolean isCorrectPassword(int inputPasscode){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return this.passcode == inputPasscode;
        }
    }

    private static abstract class HackerThread extends Thread {
        protected Vault vault;
        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }
        @Override
        public void start() {
            System.out.println("Starting thread : " + this.getName());
            super.start();
        }
    }

    private static class AscendingHackerThread extends HackerThread {

        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
           for(int i=0; i<PASSWORD_UPPER_RANGE; i++) {
               if(vault.isCorrectPassword(i)) {
                   System.out.println(this.getName()+" guessed the password : "+i);
                   System.exit(0);
               }
           }
        }
    }

    private static class DescendingHackerThread extends HackerThread {

        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for(int i=PASSWORD_UPPER_RANGE; i>=0; i++) {
                if(vault.isCorrectPassword(i)) {
                    System.out.println(this.getName()+" guessed the password : "+i);
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread {
        @Override
        public void run() {
            for(int i = 10; i > 0 ; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(i);
            }
            System.out.println("Game over for hackers police arrived");
        }
    }

}
