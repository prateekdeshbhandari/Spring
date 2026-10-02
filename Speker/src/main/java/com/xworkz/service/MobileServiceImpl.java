package com.xworkz.service;

import com.xworkz.dto.MobileDTO;
import com.xworkz.refo.MobileRefo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MobileServiceImpl  implements  MobileService{
    @Autowired
    private MobileRefo mobileRefo;

    @Override
    public boolean validetionAndSave(MobileDTO dto) {
        System.out.println("Running validetionAndSave in MobileServiceImpl");
        mobileRefo.saved(dto);
        return true;
    }
}
