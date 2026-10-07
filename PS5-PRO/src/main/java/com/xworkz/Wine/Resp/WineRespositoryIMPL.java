package com.xworkz.Wine.Resp;

import com.xworkz.Wine.dto.WineDTO;
import org.springframework.stereotype.Repository;

@Repository
public class WineRespositoryIMPL implements WineRespository{

    @Override
    public boolean save(WineDTO dto) {
        System.out.println("Running save in WineRespositoryIMPL");
        return true;
    }
}
