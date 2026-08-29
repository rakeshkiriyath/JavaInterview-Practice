package multithreading_in_java;

import java.math.BigInteger;

public class ThreadIntrupt {

    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("2"),10));
        thread.start();
    }

    private static class LongComputationTask implements Runnable {

        private BigInteger base;
        private Integer pow;

        public LongComputationTask(BigInteger base, Integer pow) {
            this.base = base;
            this.pow = pow;
        }

        @Override
        public void run() {
            System.out.println(base+"^"+pow+" = "+getPow(base,pow));
        }

        private BigInteger getPow(BigInteger base, Integer pow) {
            BigInteger result = BigInteger.ONE;
            result = base.pow(pow);
            return result;
        }
    }
}
