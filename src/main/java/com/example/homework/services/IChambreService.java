package com.example.homework.services;

import com.example.homework.entities.Bloc;
import com.example.homework.entities.Chambre;
import com.example.homework.entities.typeChambre;

import java.util.List;
import java.util.Optional;

public interface IChambreService {

    Chambre addChambre(Chambre chambre);

    List<Chambre> getChambres();

    Chambre getChambreById(long idChambre);

    Chambre updateChambre(Chambre chambre);

    void deleteChambre(long idChambre);

    Chambre findByNumCh(Chambre chambre);

    Bloc affecterChambresABloc(List<Long> numChambre, long idBloc);

    List<Chambre> getChambresParNomUniversite(String nomUniversite);

    List<Chambre> getChambresParBlocEtTypeKeyWord(long idBloc, typeChambre typeC);

    List<Chambre> getChambresParBlocEtTypeJPQL(long idBloc, typeChambre typeC);

    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, typeChambre type);

}
