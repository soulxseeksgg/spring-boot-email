package com.example.training.email.api;


import com.example.training.email.business.EmailBusiness;
import com.example.training.email.request.EmailRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmailAPI {

    private final EmailBusiness emailBusiness;

    public EmailAPI(EmailBusiness emailBusiness) {
        this.emailBusiness = emailBusiness;
    }

    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        boolean sentEmailStatus = emailBusiness.prepareFormatEmail(request);
        if(sentEmailStatus == true){
            return ResponseEntity.ok("Email sent successfully");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to sent email");
        }
    }
}
