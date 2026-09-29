package com.xworkz.dto;


import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class TelephoneOperatorDTO {

    @Min(1)
    @Max(99999)
    private int operatorId;

    @NotBlank
    @Size(min = 3, max = 30)
    private String operatorName;

    @NotBlank
    @Size(min = 2, max = 30)
    private String company;

    @Min(1000000000L)
    @Max(9999999999L)
    private long mobile;
}
