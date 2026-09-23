package com.xworkz.service;

import com.xworkz.dto.ContactDTO;
import org.springframework.stereotype.Component;

@Component
public class ContactServiceImpl implements ContactService {

    @Override
    public boolean validetionAndSavd(ContactDTO dto) {
        System.out.println("ContactServiceImpl validetionAndSavd method");
        return true;
    }
}
