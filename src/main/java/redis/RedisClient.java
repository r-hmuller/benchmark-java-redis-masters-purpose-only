package redis;

import com.github.javafaker.Faker;
import redis.clients.jedis.Jedis;

public class RedisClient implements Runnable {

    private int requests;

    public RedisClient(int requests) {
        this.requests = requests;
    }

    @Override
    public void run() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Faker faker = new Faker();
        for (int i=0; i<requests;i++) {
            jedis.rpush("processText", faker.harryPotter().quote());
        }
    }
}
