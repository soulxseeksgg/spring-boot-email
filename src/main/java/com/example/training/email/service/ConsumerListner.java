package com.example.training.email.service;

import com.example.training.email.business.EmailBusiness;
import com.example.training.email.request.EmailRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ConsumerListner {

    private final EmailBusiness emailBusiness;

    public ConsumerListner(EmailBusiness emailBusiness) {
        this.emailBusiness = emailBusiness;
    }

    @KafkaListener(topics = "activation-email")
    public void listnerForActivationEmail(String message) {

        log.info(message);
        EmailRequest request =new EmailRequest();
        request.setToEmail(message);
        request.setContent("123");
        emailBusiness.prepareFormatEmail(request);

    }
}
