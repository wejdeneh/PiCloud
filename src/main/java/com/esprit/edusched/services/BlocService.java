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
    public Bloc getBlocById(long id) {
        return blocRepository.findById(id).orElse(null);    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public String deleteBloc(long id) {
        if (blocRepository.existsById(id)) {
            blocRepository.deleteById(id);
            return "Bloc deleted";
        }
        return "Bloc not found";

    }

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
    }*/

    /*@Override
    public String deleteBloc(Long id) {
        if (blocRepository.existsById(id)) {
            blocRepository.deleteById(id);
            return "Bloc deleted";
        }
        return "Bloc not found";
    }*/
}
