package com.example.training.email.request;

import lombok.Data;

@Data
public class EmailRequest {
    private String toEmail;
    private String content;
}
