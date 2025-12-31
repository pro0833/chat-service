package com.smartpayment.realtimechat.service;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserPresenceService {

	private final Set<String> onlineUsers = ConcurrentHashMap.newKeySet();

	public void markOnline(String userId) {
		onlineUsers.add(userId);
	}

	public void markOffline(String userId) {
		onlineUsers.remove(userId);
	}

	public boolean isOnline(String userId) {
		return onlineUsers.contains(userId);
	}

	public Set<String> getOnlineUsers() {
		return onlineUsers;
	}
}
