package hu.haladojava.milestone2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    public JavaMailSender javaMailSender;
    
    public void sendEmail(String email, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        
        javaMailSender.send(message);
    }
}
