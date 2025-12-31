package com.smartpayment.realtimechat.controller;


import com.smartpayment.realtimechat.dto.ChatMessageDTO;
import com.smartpayment.realtimechat.entity.ChatMessage;
import com.smartpayment.realtimechat.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

  private final SimpMessagingTemplate messagingTemplate;
  private final ChatService chatService;

  public ChatController(SimpMessagingTemplate messagingTemplate, ChatService chatService) {
    this.messagingTemplate = messagingTemplate;
    this.chatService = chatService;
  }

  @MessageMapping("/chat.send")
  public void send(ChatMessageDTO dto) {

    ChatMessage saved = chatService.save(dto);

    // send to receiver only (1-to-1)

    messagingTemplate.convertAndSend(
        "/topic/chat/" + dto.receiverId,
        saved
    );

  }
}
