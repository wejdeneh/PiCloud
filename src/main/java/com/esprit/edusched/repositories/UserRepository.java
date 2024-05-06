package com.esprit.edusched.services;

import com.esprit.edusched.entities.Bloc;
import com.esprit.edusched.repositories.BlocRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

<<<<<<< HEAD
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);
<<<<<<< HEAD
=======

>>>>>>> origin/main
    Optional<User> findByEmail(String email);
    //User findByEmail1(String email);


<<<<<<< HEAD
    
}
=======
}
>>>>>>> origin/main
=======
@Service
@AllArgsConstructor


public class BlocService implements IBlocService{

    private BlocRepository blocRepository;

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc getBlocById(Long id) {
        return blocRepository.findById(id).orElse(null);    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public String deleteBloc(Long id) {
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
<<<<<<< HEAD
    }*/

    /*@Override
=======
    }
    @Override
>>>>>>> wejdene-creates-crud-v1.3
    public String deleteBloc(Long id) {
        if (blocRepository.existsById(id)) {
            blocRepository.deleteById(id);
            return "Bloc deleted";
        }
        return "Bloc not found";
    }*/
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
