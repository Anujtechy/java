package multithreading.counter_latch;

public class CounterExample {

    /**
     * Since multiple threads may access and modify the counter concurrently, we use synchronization
     * to ensure thread safety.
     */
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int getCount() {
        return count;
    }
}
