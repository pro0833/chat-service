package com.smartpayment.realtimechat.service;

import com.smartpayment.realtimechat.dto.ChatMessageDTO;
import com.smartpayment.realtimechat.entity.ChatMessage;
import com.smartpayment.realtimechat.repository.ChatMessageRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

  private final ChatMessageRepository repository;

  public ChatService(ChatMessageRepository repository) {
    this.repository = repository;
  }

  public ChatMessage save(ChatMessageDTO dto) {
    ChatMessage msg = new ChatMessage();
    msg.setSenderId(dto.senderId);
    msg.setReceiverId(dto.receiverId);
    msg.setContent(dto.content);
    return repository.save(msg);
  }
}
