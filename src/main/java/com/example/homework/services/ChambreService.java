package com.example.homework.services;

import com.example.homework.entities.*;
import com.example.homework.repositories.IBlocRepo;
import com.example.homework.repositories.IChambreRepo;
import com.example.homework.repositories.IFoyerRepo;
import com.example.homework.repositories.IUniversiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ChambreService implements IChambreService{
    @Autowired
    IChambreRepo iChambreRepo;
    @Autowired
    IBlocRepo iBlocRepo;
    @Autowired
    IUniversiteRepo iUniversiteRepo;
    @Autowired
    IFoyerRepo iFoyerRepo;
    public Chambre findByNumCh(Chambre chambre) {
        return iChambreRepo.findByNumeroChambreContainingAndTypeCOrderByBlocsIdBloc(chambre.getNumeroChambre(), typeChambre.Double);
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        return iChambreRepo.save(chambre);
    }

    @Override
    public List<Chambre> getChambres() {
        return (List<Chambre>) iChambreRepo.findAll();
    }

    @Override
    public Chambre getChambreById(long idChambre) {
        return iChambreRepo.findById(idChambre).orElse(null);
    }

    @Override
    public Chambre updateChambre(Chambre bloc) {
        return iChambreRepo.save(bloc);
    }

    @Override
    public void deleteChambre(long idChambre) {
        iChambreRepo.deleteById(idChambre);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = iBlocRepo.findById(idBloc).orElse(null);

        if (bloc != null) {
            Set<Chambre> chambres = (Set<Chambre>) iChambreRepo.findAllById(numChambre);
            if (!chambres.isEmpty()) {
                for (Chambre chambre : chambres) {
                    chambre.setBlocs(bloc);
                }
                bloc.getChambres().addAll(chambres);
                iBlocRepo.save(bloc);
                return bloc;
            }
        }
        return null;
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        Universite universite = iUniversiteRepo.findByNomUniversite(nomUniversite);
        List<Chambre> chambres = new ArrayList<>();

        if (universite != null) {
            Foyer foyer = iFoyerRepo.findFoyerByUniversites(universite);
            if (foyer != null) {
                Set<Bloc> blocs = foyer.getBlocs();
                for (Bloc bloc : blocs) {
                    List<Chambre> chambresByBloc = iChambreRepo.findByBlocs(bloc);
                    chambres.addAll(chambresByBloc);
                }
            }
        }
        return chambres;
    }

    @Override
    public List<Chambre> getChambresParBlocEtTypeKeyWord(long idBloc, typeChambre typeC) {
        return iChambreRepo.findChambreByBlocsIdBlocAndTypeC(idBloc, typeC);
    }

    @Override
    public List<Chambre> getChambresParBlocEtTypeJPQL(long idBloc, typeChambre typeC) {
        return iChambreRepo.findChambresByBlocIdAndTypeChambres(idBloc, typeC);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, typeChambre type) {
        Universite universite = iUniversiteRepo.findByNomUniversite(nomUniversite);
        List<Chambre> nonReservedChambres = new ArrayList<>();

        if (universite != null) {
            Foyer foyer = iFoyerRepo.findFoyerByUniversites(universite);
            if (foyer != null) {
                Set<Bloc> blocs = foyer.getBlocs();
                for (Bloc bloc : blocs) {
                    List<Chambre> chambres = iChambreRepo.findByBlocsAndTypeCAndReservationsIsEmpty(bloc, type);
                    nonReservedChambres.addAll(chambres);
                }
            }
        }
        return nonReservedChambres;
    }
}
