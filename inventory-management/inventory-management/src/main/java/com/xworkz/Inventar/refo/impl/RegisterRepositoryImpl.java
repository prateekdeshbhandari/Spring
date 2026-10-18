package com.xworkz.Inventar.refo.impl;

import com.xworkz.Inventar.entity.RegisterEntity;
import com.xworkz.Inventar.refo.RegisterRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class RegisterRepositoryImpl implements RegisterRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void rejestarRefo(RegisterEntity registerEntity) {
        System.out.println("Running rejestarRefo() in RegisterRepositoryImpl");
        System.out.println("RegisterEntity: " + registerEntity);
        entityManager.persist(registerEntity);
        System.out.println("RegisterEntity saved successfully");

    }
}
