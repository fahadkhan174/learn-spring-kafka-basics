package com.fmg.kafkaexample;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
public class MessageController {

  private final KafkaTemplate<String, String> kafkaTemplate;

  @PostMapping
  public void publish(@RequestBody MessageRecord messageRecord) {
    kafkaTemplate.send("fmgTopic", messageRecord.message());
  }
}
