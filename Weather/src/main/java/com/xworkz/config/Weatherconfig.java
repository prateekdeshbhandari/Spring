package com.xworkz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(" com.xworkz")
public class Weatherconfig
{
    public Weatherconfig(){
        System.out.println("create Weatherconfig");
    }
}
