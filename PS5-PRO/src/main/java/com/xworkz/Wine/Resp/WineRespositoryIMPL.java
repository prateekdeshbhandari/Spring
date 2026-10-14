package com.xworkz.Wine.Resp;

import com.xworkz.Wine.dto.WineDTO;
import com.xworkz.Wine.entity.WineEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class WineRespositoryIMPL implements WineRespository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public boolean save(WineEntity entity) {
        System.out.println("Running save in WineRespositoryIMPL");
        System.out.println(entity);
        entityManager.persist(entity);
        return true;
    }

    @Override
    public boolean update(WineEntity entity) {
        System.out.println("Running update in WineRespositoryIMPL");
        System.out.println(entity);
        entityManager.merge(entity);
        return true;
    }

    @Override
    public boolean delete(int id) {
        System.out.println("Running delete in WineRespositoryIMPL with id: " + id);
        WineEntity wineEntity = entityManager.find(WineEntity.class, id);
        if(wineEntity != null) {
            entityManager.remove(wineEntity);
            System.out.println("Entity deleted successfully");
            return true;
        }
        System.out.println("Entity not found for deletion");
        return false;
    }

    @Override
    public Optional<WineEntity> EditById(int id) {
        System.out.println("findById() called in WineRepoImpl() with id: " + id);
        WineEntity wineEntity= this.entityManager.find(WineEntity.class, id);
        return Optional.ofNullable(wineEntity);
    }

    public WineRespositoryIMPL() {
        System.out.println("creted WineRepoImpl()");
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
