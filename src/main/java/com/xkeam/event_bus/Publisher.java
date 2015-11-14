package com.xkeam.event_bus;


import redis.clients.jedis.Jedis;

public class Publisher {

    private final Jedis publisherJedis;

    public Publisher(Jedis publisherJedis) {
        this.publisherJedis = publisherJedis;
    }
    
    public void publish(String channel, String message) {
    	this.publisherJedis.publish(channel, message);
    }


}
