package com.esprit.edusched.services;

import com.esprit.edusched.entities.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> getAllBlocs();
<<<<<<< HEAD
<<<<<<< HEAD
    Bloc getBlocById(long id);
    Bloc addBloc(Bloc bloc);
    String deleteBloc(long id);
=======

    Bloc getBlocById(Long id);
    Bloc addBloc(Bloc bloc);
    String deleteBloc(Long id);
>>>>>>> origin/main
=======

    Bloc getBlocById(Long id);
    Bloc addBloc(Bloc bloc);
    String deleteBloc(Long id);
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
    Bloc updateBloc(Long id, Bloc updatedBloc);

}
