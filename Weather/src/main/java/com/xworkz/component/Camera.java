package com.xworkz.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Camera {
    private Camera  camera;
    public Camera(){
        System.out.println("Create Camera...");
    }
    @Autowired
    public void setCamera(Camera camera) {
        this.camera = camera;
        System.out.println("Camera set in Camera: " );
    }
}
