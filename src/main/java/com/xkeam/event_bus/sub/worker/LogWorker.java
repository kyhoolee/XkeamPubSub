package com.xkeam.event_bus.sub.worker;

import com.xkeam.event_bus.interaction.AudioInteract;
import com.xkeam.event_bus.interaction.Message;
import com.xkeam.event_bus.interaction.UserInteract;
import com.xkeam.event_bus.interaction.VideoContent;
import com.xkeam.event_bus.interaction.VideoInteract;


public class LogWorker {
	
	/**
	 * Logging user-interaction into appropriate stream
	 * @param event
	 */
	public void process(UserInteract event) {
		
	}
	
	/**
	 * Logging video-content into appropriate stream
	 * @param event
	 */
	public void process(VideoContent event) {
		
	}
	
	/**
	 * Logging video-interaction into appropriate stream
	 * @param event
	 */
	public void process(VideoInteract event) {
		
	}

	/**
	 * Logging audio-interaction into appropriate stream
	 * @param event
	 */
	public void process(AudioInteract event) {
		
	}
}
