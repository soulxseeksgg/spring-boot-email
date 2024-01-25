package com.iamdevelop.email;

import com.iamdevelop.common.EmailRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class EmailListner {

    @KafkaListener(topics = "activation-email")
    public void listenForActivationEmail(EmailRequest request){
        log.info("Kafka recied:"+request.getTo());
        log.info("Kafka recied:"+request.getContent());
    }
}
