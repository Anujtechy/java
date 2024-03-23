package multithreading.restroom;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class RestRoomUsingSemaphore {
    //Semaphore to control access to the restroom
    private static Semaphore restroomSemaphore = new Semaphore(3);
    public static void main(String[] args) {
        //Thread pool of 5
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            Runnable person = new PersonUsingSemaphore(i);
            executor.execute(person); // Submitting tasks to the Tccc   hreadPool
        }

        executor.shutdown(); // Shutdown the ThreadPool
    }

    static class PersonUsingSemaphore implements Runnable {
        private int id;

        public PersonUsingSemaphore(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                restroomSemaphore.acquire();

                System.out.println("Person " + id + " is using the restroom.");

                Thread.sleep(2000);

                System.out.println("Person " + id + " exits the restroom.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                restroomSemaphore.release();
            }
        }
    }
}
