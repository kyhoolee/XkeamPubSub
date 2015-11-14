package com.xkeam.event_bus.sub.worker;

import java.util.ArrayList;
import java.util.List;

import com.xkeam.event_bus.interaction.UserInteract;
import com.xkeam.event_bus.interaction.VideoContent;

public class DeliveryWorker {
	
	public void process(UserInteract event) {
		String authorId = event.getAuthorId();
		String userId = event.getUserId();
		
		// 1. Get user-video-list
		List<String> videoList = new ArrayList<String>();
		
		// 2. Insert video-list to author-video-time-line
	}
	
	public void process(VideoContent event) {
		// 1. Get user-follow-list
		List<String> follows = new ArrayList<String>();
		
		// 2. Insert video into follow-video-time-line
		for(String followId : follows) {
			System.out.println(
					followId + " " + event.getAuthorId() + " " 
					+ event.getVideoId() + " " + event.getAudioId() + " " + event.getTimeStamp());
		}
		
		
	}

}
