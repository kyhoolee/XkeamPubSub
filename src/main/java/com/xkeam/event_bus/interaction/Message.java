package com.xkeam.event_bus.interaction;

import com.xkeam.util.CommonUtil;

public class Message {
	private String authorId;
	private long timeStamp;
	
	private String interaction;
	
	
	
	
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getInteraction() {
		return interaction;
	}
	public void setInteraction(String interaction) {
		this.interaction = interaction;
	}

	

	@Override
	public String toString(){
		String result = "";
		try {
			result = CommonUtil.toString(this);
		} catch (Exception e) {
			
		}
		return result;
	}
}
