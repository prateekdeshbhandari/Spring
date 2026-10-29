package com.xworkz.Inventar.refo.impl;

import com.xworkz.Inventar.entity.RegisterEntity;
import com.xworkz.Inventar.refo.RegisterRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

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

    @Override
    public RegisterEntity findByEmail(String email) {

        System.out.println("Running findByEmail() in RegisterRepositoryImpl");


        System.out.println("Finding email: [" + email + "]");

        try {
            List<RegisterEntity> list = entityManager
                    .createNamedQuery("getEmailId", RegisterEntity.class)
                    .setParameter("email", email)
                    .getResultList();

            if (list.isEmpty()) {
                return new RegisterEntity();
            }

            return list.get(0);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean emailExists(String email) {



        System.out.println("Checking email: [" + email + "]");

        List<?> result = entityManager
                .createQuery(  "SELECT COUNT(r) FROM RegisterEntity r WHERE r.email = :email")
                .setParameter("email", email.trim())
                .getResultList();

        System.out.println("Records found: " + result.size());

        return !result.isEmpty();
    }

    @Override
    public boolean phoneNumberExists(String phoneNumber) {

        RegisterEntity entity = (RegisterEntity) entityManager
                .createNamedQuery("findpno")
                .setParameter("phoneNumber", phoneNumber)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);

        return entity != null;
    }

    @Override
    public RegisterEntity findByPassword(String password) {
        return null;
    }


    }

