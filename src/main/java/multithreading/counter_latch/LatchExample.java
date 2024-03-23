package multithreading.counter_latch;

import java.util.concurrent.CountDownLatch;

public class LatchExample {
    public static void main(String[] args) throws InterruptedException {

        //Initialize latch with count 3
        CountDownLatch latch = new CountDownLatch(3);

        //Start 3 worker thread
        for (int i = 0; i < 3; i++) {
            Thread workerThread = new Thread(new Worker(latch));
            workerThread.start();
        }

        //Wait until latch count becomes 0
        latch.await();

        System.out.println("All workers have completed their tasks");
    }

    static class Worker implements Runnable {
        private CountDownLatch latch;

        public Worker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep((long) (Math.random() *1000));
                System.out.println(Thread.currentThread().getName() + " has completed its task.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }
}
