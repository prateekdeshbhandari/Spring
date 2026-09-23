package com.xworkz.service;

import com.xworkz.dto.TelephoneOperatorDTO;
import org.springframework.stereotype.Component;

@Component
public class TelephoneOperatorServiceImpl implements TelephoneOperatorService{
    @Override
    public boolean validetionAndSave(TelephoneOperatorDTO dto) {
        System.out.println("TelephoneOperatorServiceImpl validetionAndSave method");
        return true;
    }
}
