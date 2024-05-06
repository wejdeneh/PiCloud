package com.esprit.edusched.services;

<<<<<<< HEAD
<<<<<<< HEAD
import com.esprit.edusched.entities.Class;
=======
import com.esprit.edusched.entities.Bloc;
import com.esprit.edusched.entities.Class;
import com.esprit.edusched.repositories.BlocRepository;
>>>>>>> origin/main
=======
import com.esprit.edusched.entities.Bloc;
import com.esprit.edusched.entities.Class;
import com.esprit.edusched.repositories.BlocRepository;
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
import com.esprit.edusched.repositories.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

<<<<<<< HEAD
<<<<<<< HEAD
public class ClassService {
    @Autowired
    private ClassRepository classRepository;
=======
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
public class ClassService implements IClassService{

    private final ClassRepository classRepository;
    private final BlocRepository blocRepository     ;
<<<<<<< HEAD
>>>>>>> origin/main
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda

    public Class addClass(Class clazz) {
        return classRepository.save(clazz);
    }

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    public Class getClassById(Long id) {
        return classRepository.findById(id).orElse(null);
    }

    public Class updateClass(Long id, Class updatedClass) {
        Class clazz = classRepository.findById(id).orElse(null);
        if (clazz != null) {
            clazz.setNum(updatedClass.getNum());
            clazz.setReservationCS(updatedClass.getReservationCS());
            clazz.setBloc(updatedClass.getBloc());
            return classRepository.save(clazz);
        }
        return null;
    }

<<<<<<< HEAD
<<<<<<< HEAD
=======


>>>>>>> origin/main
=======


>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
    public String deleteClass(Long id) {
        if (classRepository.existsById(id)) {
            classRepository.deleteById(id);
            return "Class deleted";
        }
        return "Class not found";
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda

    @Override
    public Class addClasandaffectbloc(Long idBloc, Class clas) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
clas.setBloc(bloc);
classRepository.save(clas);

return clas;
    }
<<<<<<< HEAD

>>>>>>> origin/main
}
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
