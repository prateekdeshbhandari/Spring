package com.xworkz.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Light {
    private Marker marker;
    public Light(){
        System.out.println("Create Light...");
    }
    @Autowired
    public void setMarker(Marker marker) {
        this.marker = marker;
        System.out.println("Marker set in Light: " );
    }
}
