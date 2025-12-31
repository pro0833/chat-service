package com.smartpayment.realtimechat.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(
        name = "chat_messages",
        indexes = {
                @Index(name = "idx_sender", columnList = "senderId"),
                @Index(name = "idx_receiver", columnList = "receiverId")
        }
)
public class ChatMessage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String senderId;
  private String receiverId;
  private String content;

  private LocalDateTime timestamp;

  public ChatMessage() {
    this.timestamp = LocalDateTime.now();
  }

  // getters and setters
}
