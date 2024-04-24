package com.esprit.edusched.services;

import com.esprit.edusched.entities.Class;
import com.esprit.edusched.repositories.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ClassService {
    @Autowired
    private ClassRepository classRepository;

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

    public String deleteClass(Long id) {
        if (classRepository.existsById(id)) {
            classRepository.deleteById(id);
            return "Class deleted";
        }
        return "Class not found";
    }
}
