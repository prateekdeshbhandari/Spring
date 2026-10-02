package com.xworkz.dto;

 import lombok.Data;

 import javax.validation.constraints.Max;
 import javax.validation.constraints.Min;
 import javax.validation.constraints.NotBlank;
 import javax.validation.constraints.Size;

@Data
public class MobileDTO {

    @Min(1)
    @Max(99999)
    private int mobileId;

    @NotBlank
    @Size(min = 3, max = 30,message = "Mobile name must be between 3 and 30 characters")
    private String mobileName;

    @NotBlank
    @Size(min = 2, max = 30, message = "Brand name must be between 2 and 30 characters")
    private String brand;

    @Min(1000)
    @Max(2000000)
    private double price;
}
