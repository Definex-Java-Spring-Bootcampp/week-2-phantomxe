import java.util.concurrent.CompletableFuture;

public class AsyncExample {
    public static void main(String[] args) {
        System.out.println("Start"); 
        CompletableFuture<Void> future = asyncMethod();
        try {
            future.get(); // Wait for the async method to complete
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End");
    }

    public static CompletableFuture<Void> asyncMethod() { 
        return CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Processing step " + i);
                try {
                    Thread.sleep(1000); // Simulating delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
