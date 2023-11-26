package com.example.homework.repositories;

import com.example.homework.entities.Bloc;
import com.example.homework.entities.Universite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

public interface IUniversiteRepo extends CrudRepository<Universite,Long> {

    @Query("SELECT u FROM Universite u JOIN u.foyers.blocs b WHERE b.idBloc = :idBloc")
    Universite findUniversityByBlocId(@Param("idBloc") Long idBloc);

    Universite findByNomUniversite(String nomUniversite);

}
