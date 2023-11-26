package com.example.homework.repositories;

import com.example.homework.entities.Bloc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlocRepo extends CrudRepository<Bloc,Long> {

    List<Bloc> findByCapaciteBloc(long capaciteBloc);
}
