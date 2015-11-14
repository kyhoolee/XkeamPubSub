package com.xkeam.event_bus.sub.worker;

import com.xkeam.event_bus.interaction.AudioInteract;
import com.xkeam.event_bus.interaction.Message;
import com.xkeam.event_bus.interaction.VideoInteract;

public class EventWorker {
	
	public void process(VideoInteract event) {
		
		// 1. Get base-entity
		String authorId = event.getAuthorId();
		String videoId = event.getVideoId();
		String audioId = event.getAudioId();
		
		// 2. Check interaction
		
		// 3. Real-time update ranking / delivery
		
		
	}
	
	

}
