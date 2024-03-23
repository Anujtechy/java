package multithreading.asynchronousprogramming;

import java.util.concurrent.CompletableFuture;

public class AsynchronousProgramming {
    public static void main(String[] args) {
        /**
         * 1. Use CompletableFuture to execute tasks asynchronously.
         * 2. Each task is wrapped in a CompletableFuture.runAsync() call, which executes the tasks
         *      in a separate thread from the common ForkJoinPool.
         * 3. The CompletableFuture.allOf() method waits for both tasks to compete before continuing execution.
         */

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() ->{
            System.out.println("Task 1 is executing asynchronously");
        });

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println("Task 2 is executing asynchronously");
        });

        //Wait for both tasks to complete
        CompletableFuture.allOf(future1, future2).join();
    }
}
