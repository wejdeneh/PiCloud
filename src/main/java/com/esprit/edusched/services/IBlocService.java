package com.esprit.edusched.services;

import com.esprit.edusched.entities.Bloc;

import java.util.List;

public interface IBlocService {

    Bloc getBlocById(Long id);
    Bloc addBloc(Bloc bloc);
    String deleteBloc(Long id);
    Bloc updateBloc(Long id, Bloc updatedBloc);
    List<Bloc> getAllBlocs();


}
