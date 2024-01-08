package com.example.websocket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import com.example.websocket.dto.Notification;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"spring.websocket.url=ws://localhost:${local.server.port}/websocket"})
class WebSocketControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Value("${local.server.port}")
    private String serverPort;

    @Test
    public void testWebSocketConnection() throws ExecutionException, InterruptedException {
        WebSocketStompClient stompClient = new WebSocketStompClient(new StandardWebSocketClient());
        stompClient.setMessageConverter(new StringMessageConverter());

        CompletableFuture<Notification> completableFuture = new CompletableFuture<>();

        StompSession stompSession = stompClient.connect(
                "ws://localhost:" + port + "/websocket", new WebSocketHttpHeaders(),
                new StompSessionHandlerAdapter() {}).get();

        stompSession.subscribe("/topic/notifications", new StompFrameHandler() {
            @Override
            public Type getPayloadType(StompHeaders headers) {
                return String.class;
            }

            @Override
            public void handleFrame(StompHeaders headers, Object payload) {
                completableFuture.complete(new Notification((String) payload));
            }
        });

        // Perform some action that triggers a notification
        // In this example, we're assuming your WebSocketController.notify method is triggered by some action

        // Wait for the notification
        Notification notification = completableFuture.get();

        assertNotNull(notification);
        assertEquals("Hello, WebSocket!", notification.getMessage());
    }

    // ... Rest of the test class
}
