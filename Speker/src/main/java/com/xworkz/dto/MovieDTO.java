package com.xworkz.dto;


import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class MovieDTO {

    @Min(1)
    @Max(99999)
    private int movieId;

    @NotBlank
    @Size(min = 2, max = 50)
    private String movieName;

    @NotBlank
    @Size(min = 3, max = 30)
    private String hero;

    @NotBlank
    @Size(min = 3, max = 30)
    private String director;
}
