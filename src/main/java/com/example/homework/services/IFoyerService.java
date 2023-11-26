package com.example.homework.services;

import com.example.homework.entities.Foyer;

import java.util.List;
import java.util.Optional;

public interface IFoyerService {
    Foyer addFoyer(Foyer foyer);
    List<Foyer> getFoyers();

    Foyer getFoyerById(long idFoyer);

    Foyer updateFoyer(Foyer foyer);

    void deleteFoyer(long idFoyer);

    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
    }
