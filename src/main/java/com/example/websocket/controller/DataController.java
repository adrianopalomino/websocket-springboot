package com.example.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.websocket.service.NotificationService;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/update/{parametro}")
    public ResponseEntity<String> updateData(@PathVariable String parametro) {
        // Notificar clientes após a atualização
        notificationService.notifyClients(parametro);
        return ResponseEntity.ok("Data Updated!");
    }
}