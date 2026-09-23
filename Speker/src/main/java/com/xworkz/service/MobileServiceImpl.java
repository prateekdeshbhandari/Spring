package com.xworkz.service;

import com.xworkz.dto.MobileDTO;
import org.springframework.stereotype.Component;

@Component
public class MobileServiceImpl  implements  MobileService{
    @Override
    public boolean validetionAndSave(MobileDTO dto) {
        System.out.println("Running validetionAndSave in MobileServiceImpl");
        return true;
    }
}
