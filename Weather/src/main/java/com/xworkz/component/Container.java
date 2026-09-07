package com.xworkz.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Container {
    private Glass glass;
    public Container(){
        System.out.println("Create Container...");
    }
@Autowired
    public void setGlass(Glass glass) {
        this.glass = glass;
        System.out.println("Glass set in Container: " );
    }
}
