package com.example.homework.services;

import com.example.homework.entities.Foyer;
import com.example.homework.entities.Reservation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IReservationService {

    Reservation addReservation(Reservation reservation);
    List<Reservation> getReservations();

    Reservation getReservationById(long idReservation);

    Reservation updateReservation(Reservation reservation);

    void deleteReservation(long idReservation);

    Reservation ajouterReservation(long idBloc, long cinEtudiant);

    Reservation annulerReservation(long cinEtudiant);

    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) ;

}
