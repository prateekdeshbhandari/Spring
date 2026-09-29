package com.xworkz.PS5.service;

import com.xworkz.PS5.dto.Ps5ProDTO;
import org.springframework.stereotype.Component;

@Component
public class PS5ProServicImpl implements PS5ProService{

    public PS5ProServicImpl(){
        System.out.println("Created Service" );
    }

    public boolean validateAndSave(Ps5ProDTO dto){
        System.out.println("Validating and saving DTO: " + dto);
        return true;
    }
}
