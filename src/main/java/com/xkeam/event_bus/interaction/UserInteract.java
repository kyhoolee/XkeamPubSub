package com.xkeam.event_bus.interaction;

public class UserInteract extends Message {
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
