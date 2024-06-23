package com.example;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikiChangesProducer {
    private KafkaTemplate<String, String> kafkaTemplate;

    public WikiChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws Exception {
        //TODO:: Implement logic to read data from even source and pushed it to the producer
        //Even source
        EventHandler eventHandler = new WikiChangesHandler(kafkaTemplate, "wiki-change");
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();

        eventSource.start();
        TimeUnit.MINUTES.sleep(10);

    }
}
