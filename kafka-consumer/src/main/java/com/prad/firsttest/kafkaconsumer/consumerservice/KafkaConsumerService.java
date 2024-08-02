package com.prad.firsttest.kafkaconsumer.consumerservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class KafkaConsumerService {

    Logger log = LoggerFactory.getLogger(KafkaConsumerService.class.getName());

    @KafkaListener(topics = "accident-topic" , groupId = "news-grp")
    public void consume(String message) {
        log.info("Consumer Consume The Message {} " , message);

    }

}
