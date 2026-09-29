package com.xworkz.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ProductDTO {

    @Min(1)
    @Max(99999)
    private int productId;

    @NotBlank
    @Size(min = 3, max = 50)
    private String productName;

    @Min(1)
    @Max(1000000)
    private double price;

    @NotBlank
    @Size(min = 3, max = 30)
    private String category;

}
