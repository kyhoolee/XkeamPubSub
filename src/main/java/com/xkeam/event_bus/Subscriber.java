package com.xkeam.event_bus;

import java.util.ArrayList;
import java.util.List;

import com.xkeam.event_bus.interaction.AudioInteract;
import com.xkeam.event_bus.interaction.Message;
import com.xkeam.event_bus.interaction.UserInteract;
import com.xkeam.event_bus.interaction.VideoContent;
import com.xkeam.event_bus.interaction.VideoInteract;
import com.xkeam.util.InteractConstant;
import com.xkeam.util.RedisPool;
import com.xkeam.util.ResourceUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public abstract class Subscriber extends JedisPubSub {
	private List<String> channel;
	private Jedis subscriberJedis;
	
	public Subscriber() {
		channel = new ArrayList<String>();
		this.subscriberJedis = RedisPool.getJedis();
	}
	public Subscriber(String channel) {
		this.channel = new ArrayList<String>();
		this.channel.add(channel);
		this.subscriberJedis = RedisPool.getJedis();
	}
	
	public void addChannel(String channel) {
	    this.channel.add(channel);
	}
	
	public void start() {
		new Thread(new Runnable() {
	        
	        public void run() {
	            try {
	                subscriberJedis.subscribe(Subscriber.this, channel.toArray(new String[channel.size()]));
	            } catch (Exception e) {
	            	e.printStackTrace();
	            }
	        }
	    }).start();
	}
	
	private Message parseEvent(String message, Class<? extends Message> type) {
		
		try {
        	Message event = ResourceUtil.getObjectMapper().readValue(message, type);
        	onMessage(event);
        	return event;
        } catch (Exception e) {
        	
        }
		
		return null;
	}

    @Override
    public void onMessage(String channel, String message) {
        System.out.println(channel + " " + message);
        
        Message event = null;
        
        switch(channel)  {
        case InteractConstant.create_audio_video :
        	event = parseEvent(message, VideoContent.class);
        	break;
        case InteractConstant.follow_user:
        	event = parseEvent(message, UserInteract.class);
        	break;
		case InteractConstant.view_video:
			event = parseEvent(message, VideoInteract.class);
			break;
		case InteractConstant.like_video:
			event = parseEvent(message, VideoInteract.class);
			break;
		case InteractConstant.comment_video:
			event = parseEvent(message, VideoInteract.class);
			break;
		case InteractConstant.reply_comment:
			event = parseEvent(message, VideoInteract.class);
			break;
		case InteractConstant.save_audio:
			event = parseEvent(message, AudioInteract.class);
			break;
		default:
			break;
        }
        
        onMessage(event);
        
    }
    
    public abstract void onMessage(Message message);
}
