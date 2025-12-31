package com.smartpayment.realtimechat.repository;


import com.smartpayment.realtimechat.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

	List<ChatMessage> findBySenderIdAndReceiverIdOrReceiverIdAndSenderIdOrderByTimestampAsc(
			String sender1,
			String receiver1,
			String sender2,
			String receiver2
	);
}

