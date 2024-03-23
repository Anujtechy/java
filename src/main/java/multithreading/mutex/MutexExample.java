package multithreading.mutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexExample {
    //Mutex
    private static Lock mutex  = new ReentrantLock();

    public static void main(String[] args) {
        Thread  thread1 = new Thread(new Worker(), "Thread 1");
        Thread thread2 = new Thread(new Worker(), "Thread 2");

        thread1.start();
        thread2.start();
    }

    static class Worker implements Runnable {

        @Override
        public void run() {
            mutex.lock(); // Acquire the mutex lock
            try {
                System.out.println(Thread.currentThread().getName() + " is accessing the shared resource.");

                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mutex.unlock(); // Release the mutex lock
            }
        }
    }
}
