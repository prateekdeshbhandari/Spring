package com.xworkz.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Elephan {

    public Elephan(){
        System.out.println("Create Elephan...");
    }
    private Glue glue;
@Autowired
    public void setGlue(Glue glue) {

        this.glue = glue;
        System.out.println("Glue set in Elephan: " );

    }
}
