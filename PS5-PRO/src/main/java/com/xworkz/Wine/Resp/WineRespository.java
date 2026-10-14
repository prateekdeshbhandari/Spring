package com.xworkz.Wine.Resp;

import com.xworkz.Wine.dto.WineDTO;
import com.xworkz.Wine.entity.WineEntity;

import java.util.List;
import java.util.Optional;

public interface WineRespository {
    boolean save(WineEntity entity);
    boolean update(WineEntity entity);
    boolean delete(int id);
    Optional<WineEntity> EditById(int id);
    List<WineEntity> findAll();
}
