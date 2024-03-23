package multithreading.restroom;

public class RestRoomUsingSynchronization {
    private static Object lock = new Object();
    public static void main(String[] args) {

        /**
         * 1. We use an Object called lock as a synchronization object.
         * 2. Each thread(person) enters a synchronized lock using synchronized(lock) to acquire the lock before
         *      accessing the restroom
         * 3. If the lock is available, the thread(person) enters the critical section(restroom) and release the lock
         *      after finishing its work.
         * 4. If lock is not available, the thread waits until it becomes available.
         */


        for (int i = 1; i <= 5; i++) {
            Thread th = new Thread(new PersonUsingSynchronization(i));
            th.start();
        }
    }

    static class PersonUsingSynchronization implements Runnable {
        private int id;

        public PersonUsingSynchronization(int id) {
            this.id = id;
        }

        @Override
        public void run() {
           synchronized (lock) { //Acquiring lock
               System.out.println("Person " + id + " is using the restroom");

               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           } //Releasing lock

            System.out.println("Person " + id + " exits the restroom.");
        }
    }
}
