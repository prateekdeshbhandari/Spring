package com.xworkz.service;

import com.xworkz.dto.PlaceDTO;
import com.xworkz.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class PlaceServiceIMPL implements PlaceService{


    @Override
    public boolean vaalidetionAndSave(PlaceDTO dto) {
        System.out.println("PlaceServiceIMPL validectionAndSved method");
        return true;
    }
}
