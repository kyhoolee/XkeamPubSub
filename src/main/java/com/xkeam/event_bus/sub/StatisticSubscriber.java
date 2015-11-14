package com.xkeam.event_bus.sub;

import com.xkeam.event_bus.Subscriber;
import com.xkeam.event_bus.interaction.Message;
import com.xkeam.event_bus.sub.worker.EventWorker;
import com.xkeam.util.InteractConstant;

public class StatisticSubscriber extends Subscriber {
	
	public EventWorker eventWorker;

    public StatisticSubscriber(String channel) {
    	this.addChannel(InteractConstant.create_audio_video);
    	this.addChannel(InteractConstant.delete_audio_video);
    	
    	this.addChannel(InteractConstant.view_video);
    	
    	this.addChannel(InteractConstant.like_video);
    	this.addChannel(InteractConstant.unlike_video);
    	
    	this.addChannel(InteractConstant.comment_video);
    	this.addChannel(InteractConstant.delete_comment_video);
    	
    	this.addChannel(InteractConstant.reply_comment);
    	this.addChannel(InteractConstant.delete_reply);
    	
    	
    	
	}

	@Override
    public void onMessage(Message message) {
		
		
    }
}
