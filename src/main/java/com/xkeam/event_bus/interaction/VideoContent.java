package com.xkeam.event_bus.interaction;

public class VideoContent extends Message {
	private String videoId;
	private String audioId;
	
	
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getAudioId() {
		return audioId;
	}
	public void setAudioId(String audioId) {
		this.audioId = audioId;
	}

	
	
}
