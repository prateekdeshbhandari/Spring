package com.xworkz.Wine.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan  ("com.xworkz.Wine")
@EnableWebMvc
public class AplicetionConfig {
    public AplicetionConfig() {
        System.out.println("Created " + this.getClass().getSimpleName());
    }

}
