package com.fmg.kafkaexample;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

  @KafkaListener(topics = "fmgTopic", groupId = "groupId")
  void listener(String data) {
    System.out.println("Listener Received: " + data + " ;) ");
  }

}
