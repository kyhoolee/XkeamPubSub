package com.xkeam.event_bus.interaction;

import com.xkeam.event_bus.Publisher;
import com.xkeam.util.RedisPool;

public class InteractPublisher {
	
	public static Publisher publisher = new Publisher(RedisPool.getJedis());
	
	public static void publish(Message message) {
		publisher.publish(message.getInteraction().toString(), message.toString());
	}
	
	public static void publish(String channel, String message) {
		publisher.publish(channel, message);
	}

}
