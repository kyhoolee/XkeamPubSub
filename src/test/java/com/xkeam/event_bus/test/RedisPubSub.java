package com.xkeam.event_bus.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.xkeam.event_bus.Publisher;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPubSub {
	public static final String CHANNEL_NAME = "channel1";

	public static void start(Publisher publisher, String channel) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String line = reader.readLine();

                if (!"quit".equals(line)) {
                    publisher.publish(channel, line);
                } else {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("IO failure while reading input " + e);
        }
    }

    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        JedisPool jedisPool = new JedisPool(poolConfig, "localhost", 6379, 0);
        
	
	    
	    Jedis publisherJedis = jedisPool.getResource();
	    Publisher publisher = new Publisher(publisherJedis);
	    start(publisher, CHANNEL_NAME);
	
	    jedisPool.returnResource(publisherJedis);
	    jedisPool.close();
    }

}
