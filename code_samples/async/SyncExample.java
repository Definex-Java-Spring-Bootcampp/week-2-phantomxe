public class SyncExample {
    public static void main(String[] args) {
        System.out.println("Start");
        syncMethod();
        System.out.println("End");
    }

    public static void syncMethod() { 
        for (int i = 0; i < 5; i++) {
            System.out.println("Processing step " + i);
            try {
                Thread.sleep(1000); // Simulating delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
    }
}
