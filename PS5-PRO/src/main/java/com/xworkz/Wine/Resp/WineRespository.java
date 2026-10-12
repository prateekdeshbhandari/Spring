package com.xworkz.Wine.Resp;

import com.xworkz.Wine.dto.WineDTO;
import com.xworkz.Wine.entity.WineEntity;

import java.util.List;

public interface WineRespository {
    boolean save(WineEntity entity);
//    boolean update(WineDTO dto);
//    boolean delete(WineDTO dto);
//    WineDTO findById(int id);
    List<WineEntity> findAll();
}
