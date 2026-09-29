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
    @Size(min = 3, max = 30)
    private String mobileName;

    @NotBlank
    @Size(min = 2, max = 30)
    private String brand;

    @Min(1000)
    @Max(200000)
    private double price;
}
