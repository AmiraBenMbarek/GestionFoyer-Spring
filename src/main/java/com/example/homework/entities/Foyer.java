package com.example.homework.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@RequiredArgsConstructor
@Setter
@Getter
@ToString(exclude = {"id"})
@EqualsAndHashCode
@Table(name="Foyer")
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFoyer", nullable = false)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    private long idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foyers")
    private Set<Bloc> blocs;

    @OneToOne
    @JoinColumn(name = "id_universite")
    private Universite universites;
}
