package com.example.websocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.websocket.dto.DadoAlteradoEvent;
import com.example.websocket.dto.Notification;

@Service
public class DadoService {

	private final ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	public DadoService(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	// Método para alterar o dado na base de dados
	public void alterarDado(Notification dado) {

		// Publica um evento de notificação
		applicationEventPublisher.publishEvent(new DadoAlteradoEvent(this, dado));
	}
}