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
import java.util.Optional;
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
    public List<WineDTO> getShowAlll() {
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

    @Override
    public WineDTO getEdit(Integer id) {

        System.out.println("The findById() method is called in service");

        if ( id > 0) {

            Optional<WineEntity> optional = this.wineRespository.EditById(id);

            if (optional.isPresent()) {
                WineEntity wineEntity = optional.get();
                WineDTO wineDTO = new WineDTO();
                BeanUtils.copyProperties(wineEntity, wineDTO);

                return wineDTO;
            }
        }

        System.out.println("Invalid ID or Wine record not found");
        return null;
    }

    @Override
    public boolean validateAndUpdate(WineDTO dto) {
        System.out.println("Validating and updating DTO: " + dto);
        if(dto != null && dto.getId() != null) {
            System.out.println("DTO is not null with ID, proceeding with update");
            Optional<WineEntity> optional = this.wineRespository.EditById(dto.getId());
            if(optional.isPresent()) {
                WineEntity wineEntity = optional.get();
                BeanUtils.copyProperties(dto, wineEntity);
                wineRespository.update(wineEntity);
                System.out.println("Update successful for ID: " + dto.getId());
                return true;
            } else {
                System.out.println("Entity not found with ID: " + dto.getId());
                return false;
            }
        }
        System.out.println("DTO is null or ID is missing");
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        System.out.println("Delete method called in service with ID: " + id);
        if(id != null && id > 0) {
            return this.wineRespository.delete(id);
        }
        System.out.println("Invalid ID for deletion");
        return false;
    }
}
