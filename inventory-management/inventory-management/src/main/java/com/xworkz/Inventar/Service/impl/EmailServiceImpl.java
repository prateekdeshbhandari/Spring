package com.xworkz.Inventar.Service.impl;

import com.xworkz.Inventar.Service.EmailService;
import com.xworkz.Inventar.config.EmailConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private  EmailConfig emailConfig;
    @Override
    public boolean sendEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("OTP for Registration");
        message.setText("Your OTP is: " + otp);
        javaMailSender.send(message);
        return true;
    }
    @Override
    public Boolean sendEmail(String email, String subject, String body) {

        if (email != null && subject != null && body != null) {

            SimpleMailMessage message = new SimpleMailMessage();

            message.setTo(email);
            message.setSubject(subject);
            message.setText(body);

            emailConfig.mailSender().send(message);

            log.info("Password reset email sent successfully to {}", email);

            return true;
        }

        return false;
    }
}
