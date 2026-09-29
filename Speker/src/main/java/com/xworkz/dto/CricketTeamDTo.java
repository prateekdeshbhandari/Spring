package com.xworkz.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CricketTeamDTo {


    @Min(1)
    @Max(99999)
    private int teamId;

    @NotBlank
    @Size(min = 3, max = 30)
    private String teamName;

    @NotBlank
    @Size(min = 3, max = 30)
    private String captain;

    @NotBlank
    @Size(min = 3, max = 30)
    private String coach;
}
