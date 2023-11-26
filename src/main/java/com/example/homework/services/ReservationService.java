package com.example.homework.services;

import com.example.homework.entities.*;
import com.example.homework.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationService implements IReservationService{
    @Autowired
    IReservationRepo iReservationRepo;
    @Autowired
    IUniversiteRepo iUniversiteRepo;
    @Autowired
    IChambreRepo iChambreRepo;
    @Autowired
    IEtudiantRepo iEtudiantRepo;
    @Autowired
    IFoyerRepo iFoyerRepo;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return iReservationRepo.save(reservation);
    }

    @Override
    public List<Reservation> getReservations() {
        return (List<Reservation>) iReservationRepo.findAll();
    }

    @Override
    public Reservation getReservationById(long idReservation) {
        return iReservationRepo.findById(idReservation).orElse(null);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return iReservationRepo.save(reservation);
    }

    @Override
    public void deleteReservation(long idReservation) {
        iReservationRepo.deleteById(idReservation);
    }

    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Chambre chambre = iChambreRepo.findById(idBloc).orElse(null);
        Etudiant etudiant = iEtudiantRepo.findByCin(cinEtudiant);

        if (chambre != null && etudiant != null) {
            int currentCapacity = chambre.getReservations().size();
            int maxCapacity = 0;
            switch (chambre.getTypeC()) {
                case Simple:
                    maxCapacity = 1;
                    break;
                case Double:
                    maxCapacity = 2;
                    break;
                case Triple:
                    maxCapacity = 3;
                    break;
                // Add more cases for other chambre types if needed
            }

            if (currentCapacity < maxCapacity) {
                String numReservation = chambre.getNumeroChambre() + "-" + chambre.getBlocs().getNomBloc() + "-" + new Date().getYear();
                Reservation reservation = new Reservation();
                reservation.setIdReservation(numReservation);
                reservation.setAnneeUniversitaire(new Date());
                reservation.setEstValide(true);
                reservation.getEtudiants().add(etudiant);
                chambre.getReservations().add(reservation);
                return iReservationRepo.save(reservation);
            }
        }
        return null;
    }

    @Override
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant etudiant = iEtudiantRepo.findByCin(cinEtudiant);
        if (etudiant != null) {
            Reservation reservation = iReservationRepo.findByEtudiantsContainingAndEstValideIsTrue(etudiant);
            if (reservation != null) {
                reservation.setEstValide(false);

                Chambre chambre = null;
                for (Chambre currentChambre : iChambreRepo.findAll()) {
                    for (Reservation res : currentChambre.getReservations()) {
                        if (res.getIdReservation().equals(reservation.getIdReservation())) {
                            chambre = currentChambre;
                            break;
                        }
                    }
                }

                if (chambre != null) {
                    chambre.getReservations().remove(reservation);
                    iChambreRepo.save(chambre);
                }
                reservation.getEtudiants().remove(etudiant);
                return iReservationRepo.save(reservation);
            }
        }
        return null;
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {
        Universite universite = iUniversiteRepo.findByNomUniversite(nomUniversite);
        List<Reservation> reservations = new ArrayList<>();

        if (universite != null) {
            Foyer foyer = iFoyerRepo.findFoyerByUniversites(universite);
            if (foyer != null) {
                Set<Bloc> blocs = foyer.getBlocs();
                for (Bloc bloc : blocs) {
                    List<Chambre> chambres = iChambreRepo.findByBlocs(bloc);
                    for (Chambre chambre : chambres) {
                        for (Reservation reservation : chambre.getReservations()) {
                            if (reservation.getAnneeUniversitaire().equals(anneeUniversite) && reservation.getEstValide()) {
                                reservations.add(reservation);
                            }
                        }
                    }
                }
            }
        }
        return reservations;
    }

}
