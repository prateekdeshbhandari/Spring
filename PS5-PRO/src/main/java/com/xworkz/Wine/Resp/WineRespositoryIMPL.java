package com.xworkz.Wine.Resp;

import com.xworkz.Wine.dto.WineDTO;
import com.xworkz.Wine.entity.WineEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

@Repository
public class WineRespositoryIMPL implements WineRespository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public boolean save(WineEntity entity) {
        System.out.println("Running save in WineRespositoryIMPL");
        System.out.println(entity);
        entityManager.merge(entity);
        return true;
    }

    @Override
    public List<WineEntity> findAll() {
        System.out.println("findAll() called in WineRepoImpl");
        List<WineEntity> wineEntityList = this.entityManager
                .createNamedQuery("findAll", WineEntity.class)
                .getResultList();

        System.out.println("wineEntityList total: " + wineEntityList.size());
        return wineEntityList;
        }
}
