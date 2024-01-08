package com.example.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.example.websocket.dto.Notification;

@Controller
public class WebSocketController {

	@MessageMapping("/notify")
	@SendTo("/topic/notifications")
	public Notification notify(Notification notification, SimpMessageHeaderAccessor headerAccessor) {
		System.out.println(" ### NOTIFICAÇÃO RECEBIDA: " + notification);
		String sessionId = headerAccessor.getSessionId();
		return notification;
	}
}