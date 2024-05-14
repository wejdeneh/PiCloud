package com.esprit.edusched.controllers;
import com.esprit.edusched.entities.RatingT;
import com.esprit.edusched.entities.User;
import com.esprit.edusched.repositories.RatingTRepository;
import com.esprit.edusched.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
public class RatingTController {
    @Autowired
    IUserService iUserService;
    @Autowired
    RatingTRepository ratingTRepository;

    @PostMapping("/addRating/{idUser}")
    public RatingT addRating(@RequestBody RatingT r, @PathVariable int idUser) {
        User user = iUserService.findUserById(idUser);
        r.setUser(user);
        return ratingTRepository.save(r);
    }

    @GetMapping("/findAllRatings")
    public List<RatingT> findAllRatings() {
        return ratingTRepository.findAll();

    }

    @GetMapping("/findRatingById/{id}")
    public RatingT findRatingById(@PathVariable("id") int id) {
        return ratingTRepository.findById(id).get();
    }

    @GetMapping("/rating/count")
    public long countRating() {
        return ratingTRepository.count();
    }

    @GetMapping("/rating/above")
    public long getAbove() {
        long total = ratingTRepository.count();
        long count = 0;
        List<RatingT> allRatings = ratingTRepository.findAll();
        for (RatingT rating : allRatings) {
            if (rating.getValue() >= 3) {
                count = count + 1;
                //return count;
            }
        }
        return count;


    }

    @GetMapping("/rating/below")
    public long getBelow() {
        long total = ratingTRepository.count();
        long count = 0;
        List<RatingT> allRatings = ratingTRepository.findAll();
        for (RatingT rating : allRatings) {
            if (rating.getValue() < 3) {
                count = count + 1;
                //return count;
            }
        }
        return count;

    }
}