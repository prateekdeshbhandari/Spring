package com.xworkz.Inventar.Service;

public interface EmailService {
    boolean sendEmail(String email,String otp);


    Boolean sendEmail(String email, String subject, String body);




}
