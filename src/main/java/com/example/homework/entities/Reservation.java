package com.example.homework.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@Setter
@Getter
@ToString(exclude = {"id"})
@EqualsAndHashCode
@Table(name="Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idReservation", nullable = false)
    @EqualsAndHashCode.Exclude
    private String idReservation;
    private Date anneeUniversitaire;
    private Boolean estValide;

    @ManyToMany
    private Set<Etudiant> etudiants;
}
