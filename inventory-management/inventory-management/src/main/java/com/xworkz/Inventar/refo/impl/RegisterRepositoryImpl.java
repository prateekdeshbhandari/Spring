package com.xworkz.Inventar.refo.impl;

import com.xworkz.Inventar.entity.AuditEntity;
import com.xworkz.Inventar.entity.RegisterEntity;
import com.xworkz.Inventar.refo.RegisterRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.time.LocalDateTime;
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
    public boolean emailExists(String email) {

        System.out.println("Checking email: [" + email + "]");

        List<?> result = entityManager
                .createQuery("SELECT e FROM RegisterEntity e WHERE e.email = :email")
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
    public RegisterEntity findEntityByEmail(String email) {

        System.out.println("Finding email: [" + email + "]");

        try {
            return (RegisterEntity) entityManager
                    .createNamedQuery("getEmailId")
                    .setParameter("email", email.trim())
                    .getSingleResult();

        } catch (javax.persistence.NoResultException e) {
            System.out.println("Email not found in database");
            return null;
        }
    }

    @Override
    public void update(RegisterEntity registerEntity) {

        RegisterEntity registerEntity1 = entityManager.find(RegisterEntity.class, registerEntity.getId());

        if (registerEntity1 == null) {
            System.out.println("RegisterEntity not found");
            return;
        }

        registerEntity1.setName(registerEntity.getName());
        registerEntity1.setMobileNumber(registerEntity.getMobileNumber());
        registerEntity1.setAddress(registerEntity.getAddress());

        entityManager.merge(registerEntity1);

        AuditEntity auditEntity = entityManager.createQuery("SELECT a FROM AuditEntity a WHERE a.register.id = :registerId", AuditEntity.class)
                .setParameter("registerId", registerEntity1.getId())
                .getResultStream()
                .findFirst()
                .orElse(null);

        if (auditEntity != null) {
            auditEntity.setUpdatedAt(LocalDateTime.now());
            auditEntity.setUpdatedBy(registerEntity1.getName());
            entityManager.merge(auditEntity);
        } else {
            auditEntity = new AuditEntity();
            auditEntity.setCreatedBy(registerEntity1.getName());
            auditEntity.setCreatedAt(LocalDateTime.now());
            auditEntity.setUpdatedBy(registerEntity1.getName());
            auditEntity.setUpdatedAt(LocalDateTime.now());

            auditEntity.setRegister(registerEntity1);
            registerEntity1.setAuditEntity(auditEntity);

            entityManager.persist(auditEntity);
        }

    }
}

