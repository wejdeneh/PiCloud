package com.esprit.edusched.services;

import com.esprit.edusched.entities.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> getAllBlocs();
    Bloc getBlocById(long id);
    Bloc addBloc(Bloc bloc);
    String deleteBloc(long id);
    Bloc updateBloc(Long id, Bloc updatedBloc);

}
