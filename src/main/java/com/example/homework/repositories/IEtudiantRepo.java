package com.example.homework.repositories;

import com.example.homework.entities.Bloc;
import com.example.homework.entities.Etudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IEtudiantRepo extends CrudRepository<Etudiant,Long> {

    Etudiant findByCin(long cin);
}
