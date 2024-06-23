package com.example;

import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    @KafkaListener(topics = "wiki-change", groupId = "group_id")
    public void consume(String message) {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}