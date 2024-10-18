package com.example.training.email.business;


import com.example.training.email.request.EmailRequest;
import com.example.training.email.service.EmailService;
import com.example.training.email.util.SecurityUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;

@Log4j2
@Service
public class EmailBusiness {

    private final EmailService emailService;
    private final ResourceLoader resourceLoader;

    public EmailBusiness(EmailService emailService, ResourceLoader resourceLoader) {
        this.emailService = emailService;
        this.resourceLoader = resourceLoader;
    }

    public boolean prepareFormatEmail(EmailRequest request) {

        String token = SecurityUtil.generateToken();

        String subject = "Place activate email";
        String formEmail = "";
        try {
            formEmail = getFileTemplateEmail("email-activate-user.html");
        } catch (IOException e) {

        }
        formEmail = formEmail.replace("${USER}",request.getToEmail());
        formEmail = formEmail.replace("${LINK}",token);

        boolean sentEmailstatus = emailService.sendEmail(request.getToEmail(), subject, formEmail);
        return sentEmailstatus;
    }

    private String getFileTemplateEmail(String filename) throws IOException {
        Resource file = resourceLoader.getResource("classpath:email/" + filename);
        try (InputStreamReader reader = new InputStreamReader(file.getInputStream())) {
            return FileCopyUtils.copyToString(reader);
        }
    }
}
