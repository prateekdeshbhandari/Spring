package com.xworkz.Wine.Resp;

import com.xworkz.Wine.dto.WineDTO;
import com.xworkz.Wine.entity.WineEntity;

import java.util.List;
import java.util.Optional;

public interface WineRespository {
    boolean save(WineEntity entity);
//    boolean update(WineDTO dto);
//    boolean delete(WineDTO dto);
    Optional<WineEntity> EditById(int id);
    List<WineEntity> findAll();
}
