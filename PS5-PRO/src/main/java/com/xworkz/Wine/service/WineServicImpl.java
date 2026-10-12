package com.xworkz.Wine.service;

import com.xworkz.Wine.Resp.WineRespository;
import com.xworkz.Wine.dto.WineDTO;
import com.xworkz.Wine.entity.WineEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Component
public class WineServicImpl implements WineService {

    public WineServicImpl(){
        System.out.println("Created Service" );
    }
    @Autowired
private WineRespository wineRespository;
    public boolean validateAndSave(WineDTO dto){
        System.out.println("Validating and saving DTO: " + dto);
        if(dto!=null) {
            System.out.println("DTO is not null, proceeding with save");
            WineEntity wineEntity = new WineEntity();
            BeanUtils.copyProperties(dto, wineEntity);


            wineRespository.save(wineEntity);


            return true;
        }
        return false;
    }

    @Override
    public List<WineDTO> getShowAll() {
        System.out.println("get getShowAll method call..");
        List<WineEntity>wineEntities=this.wineRespository.findAll();
        List<WineDTO>wineDTOList=new ArrayList<>();
        if(wineEntities!=null && !wineEntities.isEmpty()){
           wineDTOList= wineEntities.stream().map(entity -> {
               WineDTO dto = new WineDTO();
               BeanUtils.copyProperties(entity, dto);
               return dto;
           }).collect(Collectors.toList());
        }
        System.out.println("Total wine list"+wineDTOList.size());
        return wineDTOList;
    }
}
