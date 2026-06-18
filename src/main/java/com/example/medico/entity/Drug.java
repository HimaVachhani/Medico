package com.example.medico.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String drugName;

    private String dosage;

    @Column(length = 1000)
    private String sideEffects;

    private String manufacturer;

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;
}
