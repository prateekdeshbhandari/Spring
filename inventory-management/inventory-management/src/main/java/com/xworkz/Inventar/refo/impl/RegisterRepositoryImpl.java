package com.xworkz.Inventar.refo.impl;

import com.xworkz.Inventar.entity.AuditEntity;
import com.xworkz.Inventar.entity.RegisterEntity;
import com.xworkz.Inventar.refo.RegisterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@Repository
@Transactional
public class RegisterRepositoryImpl implements RegisterRepository {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void rejestarRefo(RegisterEntity registerEntity) {
        log.info("Running rejestarRefo() in RegisterRepositoryImpl");
        log.info("RegisterEntity: " + registerEntity);
        entityManager.persist(registerEntity);
        log.info("RegisterEntity saved successfully");
    }


    @Override
    public boolean emailExists(String email) {

        log.info("Checking email: [" + email + "]");

        List<?> result = entityManager
                .createQuery("SELECT e FROM RegisterEntity e WHERE e.email = :email")
                .setParameter("email", email.trim())
                .getResultList();

        log.info("Records found: " + result.size());

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

        log.info("Finding email: [" + email + "]");

        try {
            return (RegisterEntity) entityManager
                    .createNamedQuery("getEmailId")
                    .setParameter("email", email.trim())
                    .getSingleResult();

        } catch (javax.persistence.NoResultException e) {
            log.info("Email not found in database");
            return null;
        }
    }

    @Override
    public void update(RegisterEntity registerEntity) {

        RegisterEntity registerEntity1 = entityManager.find(RegisterEntity.class, registerEntity.getId());

        if (registerEntity1 == null) {
            log.info("RegisterEntity not found");
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

    @Override
    public boolean saveOtp(String email, String otp) {
        EntityManager entityManager =emf.createEntityManager();

        EntityTransaction transaction=entityManager.getTransaction();
        try {
            transaction.begin();
            int result= entityManager.createNamedQuery("updatingOtpByEmail").setParameter("otp",otp).setParameter("email",email).executeUpdate();
            transaction.commit();
            if(result>0){
                return true;
            }

        } catch (PersistenceException e) {
            transaction.rollback();

        }
        finally {
            entityManager.close();
        }

        return false;
    }

    @Override
    public RegisterEntity findEntityByResetToken(String resetToken) {

        EntityManager manager = emf.createEntityManager();

        try {
            return manager.createQuery("SELECT r FROM RegisterEntity r WHERE r.resetToken = :token", RegisterEntity.class)
                    .setParameter("token", resetToken)
                    .getSingleResult();

        } catch (NoResultException e) {
            return null;

        } finally {
            manager.close();
        }
    }
}

