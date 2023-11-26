package com.example.homework.services;

import com.example.homework.entities.Bloc;
import com.example.homework.entities.Chambre;
import com.example.homework.repositories.IBlocRepo;
import com.example.homework.repositories.IChambreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BlocService implements IBlocService {

    @Autowired
    IBlocRepo iblocRepo;

    @Autowired
    IChambreRepo iChambreRepo;

    @Override
    public Bloc addBloc(Bloc bloc) {
        return iblocRepo.save(bloc);
    }

    @Scheduled(cron = "*/30 * * * * *")
    @Override
    public List<Bloc> getBlocs() {
        return (List<Bloc>) iblocRepo.findAll();
    }

    @Override
    public Bloc getBlocById(long idBloc) {
        return iblocRepo.findById(idBloc).orElse(null);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return iblocRepo.save(bloc);
    }

    @Override
    public void deleteBloc(long idBloc) {
        iblocRepo.deleteById(idBloc);
    }


}
