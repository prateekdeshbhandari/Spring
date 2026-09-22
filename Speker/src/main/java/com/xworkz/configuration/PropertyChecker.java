package com.xworkz.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;




@Component
public class PropertyChecker {
    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    public PropertyChecker() {
        System.out.println("PropertyChecker Created");
    }

    @PostConstruct
    public void check() {
        System.out.println("Checking Properties");
        System.out.println("user name: " + username);
        System.out.println("password: " + password);
    }
}