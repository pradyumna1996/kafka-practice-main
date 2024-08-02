package com.prad.firsttest.kafkaproducerexample.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("accident-topic", message);
future.whenComplete((result,ex) -> {
    if(ex == null) {
        System.out.println("Sent message successfully = [" + message + "]");
    }else {
        System.out.println("Unable to send message=[" + ex.getMessage() + "] " + ex.getCause() + " " + result.getRecordMetadata().offset());
    }
});
    }


}
