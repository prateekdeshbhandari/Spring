package com.xworkz.dto;

import lombok.Data;

@Data
public class ContactDTO {

    private int contactId;
    private String name;
    private String email;
    private long mobile;

}