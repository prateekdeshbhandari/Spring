package com.xworkz.Wine.dto;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class WineDTO {



    @NotBlank
    @Size(min = 3, max = 50,message = "Company name should be between 3 and 50 characters")
    private String companyName;

    @NotBlank
    @Size(min = 3, max = 50,message = "Manufacturer name should be between 3 and 50 characters")
    private String manfName;

    @NotNull
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date manfDate;

    @NotNull
    @DecimalMin(value = "0.1")
    @DecimalMax(value = "2500")

    private Double age;
}

