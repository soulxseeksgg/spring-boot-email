package com.example.training.email.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Value("${spring.mail.username}")
    private String fromEmail;

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public boolean sendEmail (String toEmail, String subject, String formEmail){
        try {
            MimeMessagePreparator message = mimeMessage -> {
                MimeMessageHelper helper =
                        new MimeMessageHelper(mimeMessage,true,"UTF-8");
                helper.setFrom(fromEmail);
                helper.setTo(toEmail);
                helper.setSubject(subject);
                helper.setText(formEmail,true);
            };
            javaMailSender.send(message);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
