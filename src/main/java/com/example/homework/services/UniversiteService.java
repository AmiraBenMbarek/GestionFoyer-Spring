package com.example.homework.services;

import com.example.homework.entities.Bloc;
import com.example.homework.entities.Foyer;
import com.example.homework.entities.Reservation;
import com.example.homework.entities.Universite;
import com.example.homework.repositories.IFoyerRepo;
import com.example.homework.repositories.IUniversiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversiteService implements IUniversiteService{
    @Autowired
    IUniversiteRepo iUniversiteRepo;

    @Autowired
    IFoyerRepo iFoyerRepo;

    @Override
    public Universite addUniversite(Universite universite) {
        return iUniversiteRepo.save(universite);
    }

    @Override
    public List<Universite> getUniversites() {
        return (List<Universite>) iUniversiteRepo.findAll();
    }

    @Override
    public Universite getUniversiteById(long idUniversite) {
        return iUniversiteRepo.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return iUniversiteRepo.save(universite);
    }

    @Override
    public void deleteUniversite(long idUniversite) {
        iUniversiteRepo.deleteById(idUniversite);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite universite = iUniversiteRepo.findByNomUniversite(nomUniversite);
        Foyer foyer = iFoyerRepo.findById(idFoyer).orElse(null);

        if (universite != null && foyer != null) {
            foyer.setUniversites(universite);
            iFoyerRepo.save(foyer);
            return universite;
        }
        return null;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = iUniversiteRepo.findById(idUniversite).orElse(null);

        if (universite != null) {
            universite.getFoyers().setUniversites(null);
            iUniversiteRepo.save(universite);
            return universite;
        }
        return null;
    }

}
