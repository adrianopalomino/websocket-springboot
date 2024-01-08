package com.example.websocket.dto;

import org.springframework.context.ApplicationEvent;

public class DadoAlteradoEvent extends ApplicationEvent {

	private final Notification dado;

	public DadoAlteradoEvent(Object source, Notification dado) {
		super(source);
		this.dado = dado;
	}

	public Notification getDado() {
		return dado;
	}
}
