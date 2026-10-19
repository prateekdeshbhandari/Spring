package com.xworkz.Inventar.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "register_details")

public class RegisterEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "name")
        private String name;

        @Column(name = "email")
        private String email;

        @Column(name = "password")
        private String password;

        @Column(name = "phone_number")
        private String mobileNumber;

        @Column(name = "address")
        private String address;

        @Column(name = "gender")
        private String gender;
    }

