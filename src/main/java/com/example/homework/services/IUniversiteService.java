package com.example.homework.services;

import com.example.homework.entities.Universite;

import java.util.List;
import java.util.Optional;

public interface IUniversiteService {

    Universite addUniversite(Universite universite);
    List<Universite> getUniversites();

    Universite getUniversiteById(long idUniversite);

    Universite updateUniversite(Universite universite);

    void deleteUniversite(long idUniversite);

    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    Universite desaffecterFoyerAUniversite(long idUniversite);
}
