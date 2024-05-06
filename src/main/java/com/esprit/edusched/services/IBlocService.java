package com.esprit.edusched.services;

import com.esprit.edusched.entities.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> getAllBlocs();
<<<<<<< HEAD
    Bloc getBlocById(long id);
    Bloc addBloc(Bloc bloc);
    String deleteBloc(long id);
=======

    Bloc getBlocById(Long id);
    Bloc addBloc(Bloc bloc);
    String deleteBloc(Long id);
>>>>>>> origin/main
    Bloc updateBloc(Long id, Bloc updatedBloc);

}
