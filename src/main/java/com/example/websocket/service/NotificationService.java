package com.example.websocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.websocket.dto.Notification;

@Service
public class NotificationService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void notifyClients(String parametro) {
    	Notification notification = new Notification(parametro);
        messagingTemplate.convertAndSend("/topic/notifications", notification);
    }
}
