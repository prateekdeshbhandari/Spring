package com.xworkz.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Shield {
    private Paint paint;
    public Shield(){
        System.out.println("Create Shield...");
    }
    @Autowired
    public void setPaint(Paint paint) {
        this.paint = paint;
        System.out.println("Paint set in Shield: " );
    }
}
