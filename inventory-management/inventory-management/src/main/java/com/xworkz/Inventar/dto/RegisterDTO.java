package com.xworkz.Inventar.dto;

import com.xworkz.Inventar.entity.AuditEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
    public class RegisterDTO {

        @NotBlank(message = "Name is required")
        @Size(min = 1, max = 10, message = "Gender must be between 1 and 10 characters")
        private String name;

        @NotBlank(message = "Email is required")
        @Email(message = "Enter a valid email")
        private String email;

        @NotBlank(message = "Password is required")
        @Size(min = 6,max = 25, message = "Password must be at least 8 characters")
        private String password;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[6-9][0-9]{9}$",
            message = "Enter a valid 10-digit mobile number")
    private String mobileNumber;

        @NotBlank(message = "Address is required")
        private String address;
@NotBlank(message = "Gender is required")
@Size(min = 1, max = 10, message = "Gender must be between 1 and 10 characters")
       private String gender;




    }

