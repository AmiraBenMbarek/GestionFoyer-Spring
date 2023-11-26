package com.example.homework.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@RequiredArgsConstructor
@Setter
@Getter
@ToString(exclude = {"id"})
@EqualsAndHashCode
@Table(name="Universite")
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUniversite", nullable = false)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    private long idUniversite;
    private String nomUniversite;
    private String adresse;

    @OneToOne(mappedBy = "universites")
    private Foyer foyers;
}