package com.example.homework.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Setter
@Getter
@ToString(exclude = {"id"})
@EqualsAndHashCode
@Table(name="Chambre")
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChambre", nullable = false)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    private long idChambre;
    private long numeroChambre;
    @Enumerated(EnumType.STRING)
    private typeChambre typeC;

    @ManyToOne
    @JoinColumn(name = "id_bloc")
    private Bloc blocs;

    //unidirectionnelle
    @OneToMany
    private List<Reservation> reservations;
}
