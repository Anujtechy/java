package multithreading.restroom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restroom {
    public static void main(String[] args) {
        //ThreadPool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            Runnable person = new Person(i);
            //Submitting task to thread pool
            executor.execute(person);
        }

        //Shutdown the thread pool
        executor.shutdown();
    }
}
