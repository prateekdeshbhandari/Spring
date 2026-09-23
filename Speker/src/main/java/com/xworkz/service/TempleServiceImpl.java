package com.xworkz.service;

import com.xworkz.dto.TelephoneOperatorDTO;
import com.xworkz.dto.TempleDTO;
import org.springframework.stereotype.Component;

@Component
public class TempleServiceImpl implements TempleService{

    @Override
    public boolean validetionAndSave(TempleDTO dto) {
        System.out.println("Running validetionAndSave in TempleServiceImpl");
        return true;
    }
}
