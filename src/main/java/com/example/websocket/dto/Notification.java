package com.example.websocket.dto;

public class Notification {

	private String message;

	public Notification() {
	}

	public Notification(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}