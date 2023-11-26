package com.example.homework.services;

import com.example.homework.entities.Etudiant;
import java.util.List;
import java.util.Optional;

public interface IEtudiantService {

    Etudiant addEtudiant(Etudiant foyer);
    List<Etudiant> getEtudiants();

    Etudiant getEtudiantById(long idEtudiant);

    Etudiant updateEtudiant(Etudiant foyer);

    void deleteEtudiant(long idEtudiant);
}
