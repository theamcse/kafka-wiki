package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SpringBootProducerApplication implements org.springframework.boot.CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerApplication.class, args);

    }
    @Autowired
    private WikiChangesProducer wikiChangesProducer;

    public void run(String... args) throws Exception {
       wikiChangesProducer.sendMessage();
    }
}