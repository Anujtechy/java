package multithreading.restroom;

public class Person implements Runnable {
    private int id;
    public Person(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Person " + id + " is using the restroom.");
        try {
            // Simulating time sent in the restroom
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Person " + id + " exists the restroom");
    }
}
