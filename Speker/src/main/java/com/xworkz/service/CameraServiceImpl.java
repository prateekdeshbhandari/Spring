package com.xworkz.service;

import com.xworkz.dto.CameraDTO;
import org.springframework.stereotype.Component;

@Component
public class CameraServiceImpl implements CameraService{
    @Override
    public boolean validetionAndSave(CameraDTO dto) {
        System.out.println("Running validetionAndSave in CameraServiceImpl");
        return true;
    }
}
