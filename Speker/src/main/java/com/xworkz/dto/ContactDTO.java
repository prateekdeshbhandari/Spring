package com.xworkz.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ContactDTO {

    @Min(1)
    @Max(99999)
    private int contactId;

    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    @NotBlank
    @Email
    private String email;

    @Min(1000000000L)
    @Max(9999999999L)
    private long mobile;
}