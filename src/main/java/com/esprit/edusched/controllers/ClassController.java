<<<<<<< HEAD
package com.esprit.edusched.controllers;

import com.esprit.edusched.entities.Bloc;
import com.esprit.edusched.entities.Class;
<<<<<<< HEAD
=======

package com.esprit.edusched.controllers;

import com.esprit.edusched.entities.Bloc;
import com.esprit.edusched.entities.Class;
import com.esprit.edusched.repositories.BlocRepository;
import com.esprit.edusched.repositories.ClassRepository;
>>>>>>> origin/main
=======
import com.esprit.edusched.repositories.BlocRepository;
import com.esprit.edusched.repositories.ClassRepository;
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
import com.esprit.edusched.services.ClassService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
<<<<<<< HEAD
<<<<<<< HEAD
@CrossOrigin
@RequestMapping(value = "/api/classes")
@Tag(name="Class")
public class ClassController {
    @Autowired
    private  ClassService classService;
=======
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/classes")
@Tag(name="Class")
public class ClassController {
    private final ClassService classService;
    private final BlocRepository blocRepository;
    private final ClassRepository classRepository;
>>>>>>> origin/main
=======
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/classes")
@Tag(name="Class")
public class ClassController {
    private final ClassService classService;
    private final BlocRepository blocRepository;
    private final ClassRepository classRepository;
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda

    // Create
    @PostMapping("/add")
    public ResponseEntity<Class> addClass(@RequestBody Class clazz) {
        return new ResponseEntity<>(classService.addClass(clazz), HttpStatus.CREATED);
    }

    // Read all classes
    @GetMapping("/all")
    public ResponseEntity<List<Class>> getAllClasses() {
        List<Class> classes = classService.getAllClasses();
        return ResponseEntity.ok(classes);
    }

    // Read one class by ID
    @GetMapping("/{id}")
    public ResponseEntity<Class> getClassById(@PathVariable Long id) {
        Class clazz = classService.getClassById(id);
        if (clazz != null) {
            return ResponseEntity.ok(clazz);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update
    @PutMapping("/update/{id}")
<<<<<<< HEAD
<<<<<<< HEAD
    public ResponseEntity<Class> updateClass(@PathVariable Long id, @RequestBody Class updatedClass) {
        Class clazz = classService.updateClass(id, updatedClass);
        if (clazz != null) {
            return ResponseEntity.ok(clazz);
        } else {
            return ResponseEntity.notFound().build();
        }
=======
    public ResponseEntity<Class> updateClass(@PathVariable Long id, @RequestBody Class classDto) {
        Class existingClass = classRepository.findById(id).orElse(null);
        if (existingClass == null) {
            return ResponseEntity.notFound().build();
        }
=======
    public ResponseEntity<Class> updateClass(@PathVariable Long id, @RequestBody Class classDto) {
        Class existingClass = classRepository.findById(id).orElse(null);
        if (existingClass == null) {
            return ResponseEntity.notFound().build();
        }
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda

        Bloc bloc = blocRepository.findById(classDto.getBloc().getIdB()).orElse(null);
        existingClass.setBloc(bloc);
        existingClass.setNum(classDto.getNum());
        existingClass.setLiberated(classDto.isLiberated());

        classRepository.save(existingClass);
        return ResponseEntity.ok(existingClass);
<<<<<<< HEAD
>>>>>>> origin/main
=======
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClass(@PathVariable Long id) {
        String result = classService.deleteClass(id);
        if (result.equals("Class deleted")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
    @PostMapping("/addclaasAffectBloc/{idBloc}")
    public Class addClasandaffectbloc(@PathVariable Long idBloc,@RequestBody Class clas) {
        return classService.addClasandaffectbloc(idBloc, clas);
    }
>>>>>>> b4a3d431c1b7f8a20def6d08b42cd6225d502eda
}
=======
    @PostMapping("/addclaasAffectBloc/{idBloc}")
    public Class addClasandaffectbloc(@PathVariable Long idBloc,@RequestBody Class clas) {
        return classService.addClasandaffectbloc(idBloc, clas);
    }
}

>>>>>>> origin/main
