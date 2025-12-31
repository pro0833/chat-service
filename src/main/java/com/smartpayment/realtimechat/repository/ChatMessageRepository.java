package com.smartpayment.realtimechat.repository;


import com.smartpayment.realtimechat.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
