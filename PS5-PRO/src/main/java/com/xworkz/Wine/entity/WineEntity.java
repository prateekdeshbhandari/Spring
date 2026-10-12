package com.xworkz.Wine.entity;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "wine_table")
@NamedQuery(name = "findAll", query = "SELECT w FROM WineEntity w")
public class WineEntity {
    @Id
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "manf_name")
    private String manfName;

    @Column(name = "manf_date")
    @NotNull
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date manfDate;

    @Column(name = "age")
    private Double age;
}
