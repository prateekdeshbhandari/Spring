package com.xworkz.Inventar.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity

@Data
@Table(name = "audit_entity")
public class AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "register_id", referencedColumnName = "id", unique = true)
    private RegisterEntity register;
}
