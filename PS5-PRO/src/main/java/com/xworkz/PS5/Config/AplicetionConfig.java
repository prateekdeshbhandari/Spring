package com.xworkz.PS5.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan  ("com.xworkz.PS5")
@EnableWebMvc
public class AplicetionConfig {
    public AplicetionConfig() {
        System.out.println("Created " + this.getClass().getSimpleName());
    }

}
