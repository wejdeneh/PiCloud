package com.esprit.edusched.services;

import com.esprit.edusched.entities.Class;

import java.util.List;

public interface IClassService {
    // Method to add a new class
    Class addClass(Class clazz);

    // Method to retrieve all classes
    List<Class> getAllClasses();

    // Method to retrieve a class by its ID
    Class getClassById(Long id);

    // Method to update an existing class
    Class updateClass(Long id, Class updatedClass);

    // Method to delete a class by its ID
    String deleteClass(Long id);
<<<<<<< HEAD
<<<<<<< HEAD
=======

    Class addClasandaffectbloc(Long idBloc, Class clas);
>>>>>>> origin/main
=======

    Class addClasandaffectbloc(Long idBloc, Class clas);
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
}
