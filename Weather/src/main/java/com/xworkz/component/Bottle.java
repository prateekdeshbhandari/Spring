package com.xworkz.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bottle {

    private Perfume perfume;
    private Paint paint;
    private Glue glue;
    public Bottle(){
        System.out.println("Create Bottle...");
    }
    @Autowired
    public void setPerfume(Perfume perfume) {
        this.perfume = perfume;
        System.out.println("Perfume set in Bottle: " );
    }
    @Autowired
    public void setPaint(Paint paint) {
        this.paint = paint;
        System.out.println("Paint set in Bottle: " );
    }
    @Autowired
    public void setGlue(Glue glue) {
        this.glue = glue;
        System.out.println("Glue set in Bottle: " );
    }
}
