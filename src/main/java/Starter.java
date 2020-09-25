import redis.RedisClient;

public class Starter {
    public static void main(String[] args) {
        System.out.println("Starting program to generate Redis requests");

        int numberThread, numberRequests;
        try {
            numberThread = Integer.parseInt(args[0]);
            numberRequests = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            numberThread = Runtime.getRuntime().availableProcessors();
            numberRequests = 1000;
        }

        for (int i=0; i < numberThread; i++) {
            Runnable runnable = new RedisClient(numberRequests);
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
