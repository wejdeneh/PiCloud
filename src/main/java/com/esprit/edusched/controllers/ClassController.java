package com.esprit.edusched.controllers;

import com.esprit.edusched.entities.Class;
import com.esprit.edusched.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/classes")
public class ClassController {
    @Autowired
    private ClassService classService;

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
    public ResponseEntity<Class> updateClass(@PathVariable Long id, @RequestBody Class updatedClass) {
        Class clazz = classService.updateClass(id, updatedClass);
        if (clazz != null) {
            return ResponseEntity.ok(clazz);
        } else {
            return ResponseEntity.notFound().build();
        }
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
}
