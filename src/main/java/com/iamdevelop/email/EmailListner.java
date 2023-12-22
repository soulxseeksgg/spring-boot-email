package com.iamdevelop.email;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class EmailListner {

    @KafkaListener(topics = "activation-email")
    public void listenForActivationEmail(String message){
        log.info("Kafka recive message:"+message);
    }
}
