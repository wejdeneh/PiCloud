package com.esprit.edusched.services;

import com.esprit.edusched.entities.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> getAllBlocs();
    Bloc getBlocById(int id);
    void addBloc(Bloc bloc);
    void updateBloc(int id, Bloc bloc);
    void deleteBloc(int id);
}
