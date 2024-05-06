package com.esprit.edusched.services;

import com.esprit.edusched.entities.Bloc;
import com.esprit.edusched.repositories.BlocRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor


public class BlocService implements IBlocService{

    private BlocRepository blocRepository;

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
<<<<<<< HEAD
    public Bloc getBlocById(long id) {
=======
    public Bloc getBlocById(Long id) {
>>>>>>> origin/main
        return blocRepository.findById(id).orElse(null);    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
<<<<<<< HEAD
    public String deleteBloc(long id) {
=======
    public String deleteBloc(Long id) {
>>>>>>> origin/main
        if (blocRepository.existsById(id)) {
            blocRepository.deleteById(id);
            return "Bloc deleted";
        }
        return "Bloc not found";
<<<<<<< HEAD

    }

=======
    }


>>>>>>> origin/main
    @Override
    public Bloc updateBloc(Long id, Bloc updatedBloc) {
        Bloc bloc = blocRepository.findById(id).orElse(null);
        if (bloc != null) {
            bloc.setName(updatedBloc.getName());
            bloc.setClasses(updatedBloc.getClasses());
            return blocRepository.save(bloc);
        }
        return null;    }

/*
    @Override
    public Bloc getBlocById(Long id) {
        return blocRepository.findById(id).orElse(null);
    }*/

   /* @Override
    public Bloc updateBloc(Long id, Bloc updatedBloc) {
        Bloc bloc = blocRepository.findById(id).orElse(null);
        if (bloc != null) {
            bloc.setName(updatedBloc.getName());
            bloc.setClasses(updatedBloc.getClasses());
            return blocRepository.save(bloc);
        }
        return null;
<<<<<<< HEAD
    }*/

    /*@Override
=======
<<<<<<< HEAD
    }*/

    /*@Override
=======
    }
    @Override
>>>>>>> wejdene-creates-crud-v1.3
>>>>>>> origin/main
    public String deleteBloc(Long id) {
        if (blocRepository.existsById(id)) {
            blocRepository.deleteById(id);
            return "Bloc deleted";
        }
        return "Bloc not found";
    }*/
}
