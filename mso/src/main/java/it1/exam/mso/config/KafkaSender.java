package it1.exam.mso.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaSender {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        log.info("[MSO]:[KAFKA]:[SENDER] - sending message to test-topic");
        kafkaTemplate.send("test-topic", message);
    }
}
