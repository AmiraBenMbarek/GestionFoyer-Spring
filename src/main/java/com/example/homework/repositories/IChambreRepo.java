package com.example.homework.repositories;

import com.example.homework.entities.Bloc;
import com.example.homework.entities.Chambre;
import com.example.homework.entities.typeChambre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface IChambreRepo extends CrudRepository<Chambre,Long> {
    Chambre findByNumeroChambreContainingAndTypeCOrderByBlocsIdBloc(long numCh, typeChambre type);

    List<Chambre> findByBlocs(Bloc bloc);

    List<Chambre> findChambreByBlocsIdBlocAndTypeC(long idBloc, typeChambre typeC);

    @Query("SELECT c FROM Chambre c WHERE c.blocs.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> findChambresByBlocIdAndTypeChambres(@Param("idBloc") long idBloc, @Param("typeC") typeChambre typeC);

    List<Chambre> findByBlocsAndTypeCAndReservationsIsEmpty(Bloc bloc, typeChambre type);

}
