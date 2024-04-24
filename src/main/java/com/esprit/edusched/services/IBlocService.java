package com.esprit.edusched.services;

import com.esprit.edusched.entities.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> getAllBlocs();
    Bloc getBlocById(int id);
    Bloc addBloc(Bloc bloc);
    void updateBloc(int id, Bloc bloc);
    void deleteBloc(int id);
    Bloc updateBloc(Long id, Bloc updatedBloc);

}
