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
@Table(name="Etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtudiant", nullable = false)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    private int idEtudiant;
    private String nomEt;
    private String prenomEt;
    private long cin;
    private String ecole;
    private Date dateNaissance;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "etudiants")
    private Set<Reservation> reservations;
}
