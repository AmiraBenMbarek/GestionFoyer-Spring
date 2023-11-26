package com.example.homework.services;

import com.example.homework.entities.Etudiant;
import com.example.homework.repositories.IEtudiantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService implements IEtudiantService{
    @Autowired
    IEtudiantRepo iEtudiantRepo;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return iEtudiantRepo.save(etudiant);
    }

    @Override
    public List<Etudiant> getEtudiants() {
        return (List<Etudiant>) iEtudiantRepo.findAll();
    }

    @Override
    public Etudiant getEtudiantById(long idEtudiant) {
        return iEtudiantRepo.findById(idEtudiant).orElse(null);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return iEtudiantRepo.save(etudiant);
    }

    @Override
    public void deleteEtudiant(long idEtudiant) {
        iEtudiantRepo.deleteById(idEtudiant);
    }

}
