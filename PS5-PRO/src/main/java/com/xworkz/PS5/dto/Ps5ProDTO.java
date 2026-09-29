package com.xworkz.PS5.dto;
import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
public class Ps5ProDTO {



    @Min(1)
    @Max(999)
    private int id;

    @NotNull

    private String model;

    @Min(10000)
    @Max(100000)
    private double price;

    @NotNull
    @Size(min = 3, max = 20)
    private String storage;
    }

