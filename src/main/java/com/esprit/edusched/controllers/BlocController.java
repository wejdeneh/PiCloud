package com.esprit.edusched.controllers;

import com.esprit.edusched.entities.Bloc;
import com.esprit.edusched.services.BlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/blocs")
public class BlocController {
    @Autowired
    private BlocService blocService;

    // Create
    @PostMapping("/add")
    public ResponseEntity<Bloc> addBloc(@RequestBody Bloc bloc) {
        return new ResponseEntity<>(blocService.addBloc(bloc), HttpStatus.CREATED);
    }

    // Read all blocs
    @GetMapping("/all")
    public ResponseEntity<List<Bloc>> getAllBlocs() {
        List<Bloc> blocs = blocService.getAllBlocs();
        return ResponseEntity.ok(blocs);
    }

    // Read one bloc by ID
    @GetMapping("/{id}")
    public ResponseEntity<Bloc> getBlocById(@PathVariable Long id) {
        Bloc bloc = blocService.getBlocById(id);
        if (bloc != null) {
            return ResponseEntity.ok(bloc);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update
    @PutMapping("/update/{id}")
    public ResponseEntity<Bloc> updateBloc(@PathVariable Long id, @RequestBody Bloc updatedBloc) {
        Bloc bloc = blocService.updateBloc(id, updatedBloc);
        if (bloc != null) {
            return ResponseEntity.ok(bloc);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBloc(@PathVariable Long id) {
        String result = blocService.deleteBloc(id);
        if (result.equals("Bloc deleted")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
