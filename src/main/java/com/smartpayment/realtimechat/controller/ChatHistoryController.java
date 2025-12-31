package com.smartpayment.realtimechat.controller;

import com.smartpayment.realtimechat.entity.ChatMessage;
import com.smartpayment.realtimechat.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatHistoryController {
	private final ChatService chatService;

	public ChatHistoryController(ChatService chatService) {
		this.chatService = chatService;
	}

	@GetMapping("/history/{user1}/{user2}")
	public List<ChatMessage> getChatHistory(
			@PathVariable String user1,
			@PathVariable String user2
	) {
		return chatService.getChatHistory(user1, user2);
	}
}
