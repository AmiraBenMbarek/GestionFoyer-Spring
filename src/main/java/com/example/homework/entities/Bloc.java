package com.example.homework.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@RequiredArgsConstructor
@Setter
@Getter
@ToString(exclude = {"id"})
@EqualsAndHashCode
@Table(name="Bloc")
@Entity
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bloc", nullable = false)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    //@ToString.Exclude
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc;

    @ManyToOne
    private Foyer foyers;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blocs")
    private Set<Chambre> chambres;
}
