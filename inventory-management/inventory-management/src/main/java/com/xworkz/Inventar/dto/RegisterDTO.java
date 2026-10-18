package com.xworkz.Inventar.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


    public class RegisterDTO {

        @NotBlank(message = "Name is required")
        @Size(min = 1, max = 10, message = "Gender must be between 1 and 10 characters")
        private String name;

        @NotBlank(message = "Email is required")
        @Email(message = "Enter a valid email")
        private String email;

        @NotBlank(message = "Password is required")
        @Size(min = 8, message = "Password must be at least 8 characters")
        private String password;

        @NotBlank(message = "Mobile number is required")
        @Pattern(regexp = "^[0-9]{10}$",
                message = "Mobile number must contain 10 digits")
        private String mobileNumber;

        @NotBlank(message = "Address is required")
        private String address;
@NotBlank(message = "Gender is required")
@Size(min = 1, max = 10, message = "Gender must be between 1 and 10 characters")
       private String gender;

    }

