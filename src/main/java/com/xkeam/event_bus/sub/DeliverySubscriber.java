package com.xkeam.event_bus.sub;

import com.xkeam.event_bus.Subscriber;
import com.xkeam.event_bus.interaction.Message;
import com.xkeam.util.InteractConstant;

public class DeliverySubscriber extends Subscriber {

	public DeliverySubscriber() {
		this.addChannel(InteractConstant.create_audio_video);
		this.addChannel(InteractConstant.delete_audio_video);
		
		this.addChannel(InteractConstant.follow_user);
		this.addChannel(InteractConstant.unfollow_user);
	}
	
	@Override
    public void onMessage(Message message) {
		
		
    }
	
	

}
