package com.xkeam.event_bus.test;

import com.xkeam.event_bus.Subscriber;
import com.xkeam.event_bus.interaction.Message;

public class RedisPubSubTest {
	
	public static final String CHANNEL_1 = "channel1";
	public static final String CHANNEL_2 = "channel2";
	
	public static class DefaultSubscriber extends Subscriber {

		public DefaultSubscriber(String channel) {
			super(channel);
			// TODO Auto-generated constructor stub
		}
		

		@Override
		public void onMessage(Message message) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void initSub(String channel) {
        Subscriber subscriber = new DefaultSubscriber(channel);
	    subscriber.start();
	    
	}
	
	public static void main(String[] args) {
		
        
        
        initSub(CHANNEL_1);
        initSub(CHANNEL_2);
	    
	    
	    
	    
	}

}
