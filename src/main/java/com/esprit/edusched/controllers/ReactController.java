package com.esprit.edusched.controllers;

import com.esprit.edusched.dto.ReactDTO;
import com.esprit.edusched.entities.React;
import com.esprit.edusched.entities.ReactType;
import com.esprit.edusched.services.ReactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reacts")
public class ReactController {

    private final ReactService reactService;

    public ReactController(ReactService reactService) {
        this.reactService = reactService;
    }



    @PostMapping("/add/like")
    public ResponseEntity<React> addLike(@RequestBody ReactDTO reactDTO) {
        React react = reactService.addReact(reactDTO, ReactType.LIKE);
        return ResponseEntity.ok(react);
    }

    @PostMapping("/add/dislike")
    public ResponseEntity<React> addDislike(@RequestBody ReactDTO reactDTO) {
        React react = reactService.addReact(reactDTO, ReactType.DISLIKE);
        return ResponseEntity.ok(react);
    }

    @PostMapping("/add/haha")
    public ResponseEntity<React> addHaha(@RequestBody ReactDTO reactDTO) {
        React react = reactService.addReact(reactDTO, ReactType.HAHA);
        return ResponseEntity.ok(react);
    }

    @PostMapping("/add/love")
    public ResponseEntity<React> addLove(@RequestBody ReactDTO reactDTO) {
        React react = reactService.addReact(reactDTO, ReactType.LOVE);
        return ResponseEntity.ok(react);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReact(@PathVariable("id") Long id) {
        reactService.deleteReact(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<React> updateReact(@PathVariable(value = "id") Long id,
                                             @RequestBody ReactDTO reactDTO) {
        React react = reactService.updateReact(id, reactDTO);
        if (react != null) {
            return ResponseEntity.ok(react);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

