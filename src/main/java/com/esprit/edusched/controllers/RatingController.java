package com.esprit.edusched.controllers;

import com.esprit.edusched.entities.Rating;
import com.esprit.edusched.entities.ReservationT;
import com.esprit.edusched.entities.Terrain;
import com.esprit.edusched.entities.User;
import com.esprit.edusched.repositories.RatingRepository;
import com.esprit.edusched.services.IReservationTService;
import com.esprit.edusched.services.ITerrainService;
import com.esprit.edusched.services.IUserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class RatingController {
    @Autowired
    IUserService iUserService;
    @Autowired
    RatingRepository ratingRepository;

    @PostMapping("/addRating/{idUser}")
    public Rating addRating(@RequestBody Rating r ,@PathVariable int idUser) {
        User user = iUserService.findUserById(idUser);
        r.setUser(user);
        return ratingRepository.save(r);
    }

    @GetMapping("/findAllRatings")
    public List<Rating> findAllRatings() {
        return ratingRepository.findAll();

    }
    @GetMapping("/findRatingById/{id}")
    public Rating findRatingById(@PathVariable("id") int id){
        return ratingRepository.findById(id).get();
    }

    @GetMapping("/rating/count")
    public long countRating(){
        return ratingRepository.count();
    }
}
