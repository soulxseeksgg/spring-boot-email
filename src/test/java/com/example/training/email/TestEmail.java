package com.example.training.email;

import com.example.training.email.business.EmailBusiness;
import com.example.training.email.request.EmailRequest;
import com.example.training.email.util.SecurityUtil;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestEmail {

    @Autowired
    private EmailBusiness emailBusiness;

    @Test
    void contextLoads() {
        String token = SecurityUtil.generateToken();
        System.out.print("token:"+token);
        EmailRequest request = new EmailRequest();
        request.setToEmail("soulxseeks4temp@gmail.com");
        request.setContent("gg");
        emailBusiness.prepareFormatEmail(request);
    }


}
