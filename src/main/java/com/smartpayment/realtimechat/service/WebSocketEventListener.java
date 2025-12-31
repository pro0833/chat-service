package com.smartpayment.realtimechat.service;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Service
public class WebSocketEventListener {
	private final UserPresenceService presenceService;

	public WebSocketEventListener(UserPresenceService presenceService) {
		this.presenceService = presenceService;
	}

	@EventListener
	public void handleConnect(SessionConnectEvent event) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
		String userId = accessor.getFirstNativeHeader("userId");

		if (userId != null) {
			presenceService.markOnline(userId);
		}
	}

	@EventListener
	public void handleDisconnect(SessionDisconnectEvent event) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
		String userId = accessor.getFirstNativeHeader("userId");

		if (userId != null) {
			presenceService.markOffline(userId);
		}
	}
}
