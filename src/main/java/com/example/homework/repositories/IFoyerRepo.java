package com.example.homework.repositories;

import com.example.homework.entities.Bloc;
import com.example.homework.entities.Foyer;
import com.example.homework.entities.Universite;
import org.springframework.data.repository.CrudRepository;

public interface IFoyerRepo extends CrudRepository<Foyer,Long> {
    Foyer findFoyerByUniversites(Universite universite);
}
