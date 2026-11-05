package com.xworkz.Inventar.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "register_details")
@NamedQuery(name = "getEmailId", query = "SELECT e FROM RegisterEntity e WHERE e.email = :email")
@NamedQuery(name = "findpno", query = "SELECT e FROM RegisterEntity e WHERE e.mobileNumber = :phoneNumber")
@NamedQuery(name = "updatingOtpByEmail", query = "UPDATE RegisterEntity e SET e.otp = :otp WHERE e.email = :email")

public class RegisterEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "name")
        private String name;

        @Column(name = "email",nullable = false,unique = true)
        private String email;

        @Column(name = "password")
        private String password;

        @Column(name = "phone_number", nullable = false,unique = true)
        private String mobileNumber;

        @Column(name = "address")
        private String address;

        @Column(name = "gender")
        private String gender;


    @OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
    private AuditEntity auditEntity;
    @Column(name = "profile_image")
    private String profileImage;
    @Column(name = "otp")
    private String otp;

    @Column(name = "attempts")
    private Integer attempts = 0;


    @Column(name = "is_blocked")
    private Boolean blocked = false;

    @Column(name = "reset_token")
    private String resetToken;

    @Column(name = "reset_token_expiry")
    private LocalDateTime resetTokenExpiry;
    }

