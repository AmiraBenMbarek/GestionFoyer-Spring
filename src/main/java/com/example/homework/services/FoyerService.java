package com.example.homework.services;

import com.example.homework.entities.Bloc;
import com.example.homework.entities.Chambre;
import com.example.homework.entities.Foyer;
import com.example.homework.entities.Universite;
import com.example.homework.repositories.IUniversiteRepo;
import com.example.homework.repositories.IBlocRepo;
import com.example.homework.repositories.IFoyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class FoyerService implements IFoyerService {
    @Autowired
    IFoyerRepo iFoyerRepo;

    @Autowired
    IUniversiteRepo iUniversiteRepo;

    @Autowired
    IBlocRepo iBlocRepo;

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return iFoyerRepo.save(foyer);
    }

    @Override
    public List<Foyer> getFoyers() {
        return (List<Foyer>) iFoyerRepo.findAll();
    }

    @Override
    public Foyer getFoyerById(long idFoyer) {
        return iFoyerRepo.findById(idFoyer).orElse(null);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return iFoyerRepo.save(foyer);
    }

    @Override
    public void deleteFoyer(long idFoyer) {
        iFoyerRepo.deleteById(idFoyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = iUniversiteRepo.findById(idUniversite).orElse(null);

        if (universite != null) {
            Set<Bloc> blocs = foyer.getBlocs();
            if (blocs != null && !blocs.isEmpty()) {
                for (Bloc bloc : blocs) {
                    bloc.setFoyers(foyer);
                    Set<Chambre> chambres = bloc.getChambres();
                    if (chambres != null && !chambres.isEmpty()) {
                        for (Chambre chambre : chambres) {
                            chambre.setBlocs(bloc);
                        }
                    }
                }
            }
            foyer.setUniversites(universite);
            Foyer savedFoyer = iFoyerRepo.save(foyer);
            return savedFoyer;
        }
        return null;
    }
}
