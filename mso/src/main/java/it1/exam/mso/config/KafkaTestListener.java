package it1.exam.mso.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaTestListener {

    @KafkaListener(topics = "test-topic", groupId = "group-1")
    public void listen(String message) {
        log.info("[MSO]:[KAFKA]:[LISTENER] - received message from test-topic: {}", message);
    }
}
