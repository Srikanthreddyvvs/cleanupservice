package com.app.cleanupservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${user.email}")
    private String userEmail;

    public void sendCompletionMail(int count,String userEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userEmail);
        message.setSubject("Cleanup Completed");
        message.setText("Total scrap files moved: " + count);
        mailSender.send(message);
    }
}
