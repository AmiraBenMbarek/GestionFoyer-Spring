package com.example.homework.services;

import com.example.homework.entities.Bloc;

import java.util.List;
import java.util.Optional;

public interface IBlocService {

    Bloc addBloc(Bloc bloc);
    List<Bloc> getBlocs();

    Bloc getBlocById(long idBloc);

    Bloc updateBloc(Bloc bloc);

    void deleteBloc(long idBloc);

}
