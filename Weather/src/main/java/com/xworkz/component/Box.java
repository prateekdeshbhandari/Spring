package com.xworkz.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Box {
    private Paint paint;
    public Box(){
        System.out.println("Create Box...");
    }
    @Autowired


    public void setPaint(Paint paint) {
        this.paint = paint;
        System.out.println("Paint set in Box: " );
    }
}
