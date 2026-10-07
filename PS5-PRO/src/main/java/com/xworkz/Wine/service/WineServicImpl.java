package com.xworkz.Wine.service;

import com.xworkz.Wine.Resp.WineRespository;
import com.xworkz.Wine.dto.WineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WineServicImpl implements WineService {

    public WineServicImpl(){
        System.out.println("Created Service" );
    }
    @Autowired
private WineRespository wineRespository;
    public boolean validateAndSave(WineDTO dto){
        System.out.println("Validating and saving DTO: " + dto);

        wineRespository.save(dto);

        return true;
    }
}
