package com.example.homework.repositories;

import com.example.homework.entities.Chambre;
import com.example.homework.entities.Etudiant;
import com.example.homework.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface IReservationRepo extends CrudRepository<Reservation,Long> {


    Reservation findByEtudiantsContainingAndEstValideIsTrue(Etudiant etudiant);

}
